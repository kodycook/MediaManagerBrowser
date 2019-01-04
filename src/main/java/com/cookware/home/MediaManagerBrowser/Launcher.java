package com.cookware.home.MediaManagerBrowser;

import com.cookware.common.Tools.DirectoryTools;
import org.apache.log4j.*;
import org.apache.log4j.xml.DOMConfigurator;


/**
 * Created by Kody on 5/09/2017.
 * NOTE THAT THIS PROGRAM MUST BE RUN WITH THE FOLLOWING FLAG: -Dhttps.protocols=TLSv1.1,TLSv1.2
 */
public class Launcher {
    private static final Logger log = Logger.getLogger(Launcher.class);

    public static void main( String[] args ) {

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

    public static void instantiateDirectories(){
        DirectoryTools directoryTools = new DirectoryTools();
        directoryTools.createNewDirectory("logs");
        directoryTools.createNewDirectory("data");
        directoryTools.createNewDirectory("media");
    }
}
