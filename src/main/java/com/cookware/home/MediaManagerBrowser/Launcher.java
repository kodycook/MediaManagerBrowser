package com.cookware.home.MediaManagerBrowser;

import com.cookware.common.Tools.DirectoryTools;
import org.apache.log4j.*;
import org.apache.log4j.xml.DOMConfigurator;


/**
 * Created by Kody on 5/09/2017.
 */
public class Launcher {
    private static final Logger log = Logger.getLogger(Launcher.class);

    public static void main( String[] args ) {

        String configPath;
        if(args.length == 0)
        {
            configPath = "config/config.properties";
        }
        else{
            configPath = args[0];
        }

        Config config = (new ConfigManager(configPath)).getConfig();
        System.setProperty("logfilename", config.logsPath);
        DOMConfigurator.configure(config.logPropertiesPath);

        log.info("Launcher Started");

        WebAppRequestHandler webAppRequestHandler = new WebAppRequestHandler();
    }

    public static void instantiateDirectories(){
        DirectoryTools directoryTools = new DirectoryTools();
        directoryTools.createNewDirectory("logs");
        directoryTools.createNewDirectory("data");
        directoryTools.createNewDirectory("media");
    }
}
