package com.cookware.home.MediaManagerBrowser;

import com.cookware.home.MediaManagerBrowser.MediaType;

import java.util.List;

/**
 * Created by Kody on 12/05/2018.
 */
public interface WebAppScraper {

    public List<WebAppMediaItem> getMediaOptions(String searchQuery);

    public List<WebAppMediaItem> getMediaOptions(String searchQuery, int page);

    public List<WebAppMediaItem> getMediaOptions(String searchQuery, String mediaType);

    public List<WebAppMediaItem> getMediaOptions(String searchQuery, String mediaType, int page);
}
