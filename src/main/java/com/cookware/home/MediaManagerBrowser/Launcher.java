package com.cookware.home.MediaManagerBrowser;

import com.cookware.common.Utilities.DirectoryInitialiser;
import org.apache.log4j.*;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.File;
import java.net.URL;


/**
 * Created by Kody on 5/09/2017.
 * NOTE THAT THIS PROGRAM MUST BE RUN WITH THE FOLLOWING FLAG: -Dhttps.protocols=TLSv1.1,TLSv1.2
 */
public class Launcher {
    private static final Logger log = Logger.getLogger(Launcher.class);

    public static void main( String[] args ) {

        setUpDirectory();

        String configPath;
        if(args.length == 0)
        {
            configPath = "conf/config.properties";
        }
        else{
            configPath = args[0];
        }

        Config config = (new ConfigManager(configPath)).getConfig();
        System.setProperty("logfilename", config.logsPath);
        DOMConfigurator.configure(config.logPropertiesPath);

        log.info("Launcher Started");



        WebAppRequestHandler webAppRequestHandler = new WebAppRequestHandler(config);
    }

    private static void setUpDirectory(){
        String rootDirectory = System.getProperty("user.dir");

        log.info("Root directory is: " + rootDirectory);

        DirectoryInitialiser directoryInitialiser = new DirectoryInitialiser(rootDirectory);
        createDirectoryStructure(directoryInitialiser);
        unpackConfig(directoryInitialiser);
    }


    public static void createDirectoryStructure(DirectoryInitialiser directoryInitialiser){
        directoryInitialiser.createDirectory("conf");
        directoryInitialiser.createDirectory("logs");
    }


    public static void unpackConfig(DirectoryInitialiser directoryInitialiser){
        directoryInitialiser.copyResource("config.properties", "conf");
        directoryInitialiser.copyResource("log4j.xml", "conf");
    }
}
