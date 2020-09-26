package com.tinyurl.tinyurl.tinyurl.controller;

import com.tinyurl.tinyurl.tinyurl.exception.ClientNotExistException;
import com.tinyurl.tinyurl.tinyurl.response.UrlShortnerResponse;
import com.tinyurl.tinyurl.tinyurl.service.ClientService;
import com.tinyurl.tinyurl.tinyurl.service.UrlShortnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlEncoderController {

    @Autowired
    UrlShortnerService urlShortnerService;

    @Autowired
    ClientService clientService;

    @GetMapping("/shorturl/url/{url}/{clientId}")
    public UrlShortnerResponse getShortenedUrl(@PathVariable String url, @PathVariable String clientId) {

        UrlShortnerResponse urlShortnerResponse = new UrlShortnerResponse();
        try {
            String result = urlShortnerService.getUrlShortner(url, clientId);
            urlShortnerResponse.setEncodedResult(result);
            urlShortnerResponse.setSuccess(true);
            return urlShortnerResponse;
        } catch (ClientNotExistException e) {
            return new UrlShortnerResponse();
        }
    }

    @GetMapping("/shorturl/client/{clientId}")
    public void addClient(@PathVariable String clientId) {
        clientService.addClient(clientId);
    }

    @GetMapping("/test")
    public String test() {
        return "12";
    }


}
