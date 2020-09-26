package com.tinyurl.tinyurl.tinyurl.service;

import com.tinyurl.tinyurl.tinyurl.exception.ClientNotExistException;

public interface UrlShortnerService {

    public String getUrlShortner(String url, String clientId) throws ClientNotExistException;
}
