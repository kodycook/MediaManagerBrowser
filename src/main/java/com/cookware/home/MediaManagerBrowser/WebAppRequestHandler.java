package com.cookware.home.MediaManagerBrowser;

import org.apache.log4j.Logger;
import com.cookware.home.MediaManagerBrowser.Config;

/**
 * Created by Kody on 5/09/2017.
 */
public class WebAppRequestHandler {
    final private WebAppRequestHandlerRunnable webAppRequestHandlerRunnable;
    private static final Logger log = Logger.getLogger(WebAppRequestHandler.class);


    public WebAppRequestHandler(Config config) {
        webAppRequestHandlerRunnable = new WebAppRequestHandlerRunnable(config);
    }


    public void start(){
        Thread thread = new Thread(webAppRequestHandlerRunnable);
        thread.start();
    }
}