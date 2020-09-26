package com.tinyurl.tinyurl.tinyurl.impl;


import com.tinyurl.tinyurl.tinyurl.exception.ClientNotExistException;
import com.tinyurl.tinyurl.tinyurl.service.ClientService;
import com.tinyurl.tinyurl.tinyurl.service.UrlShortnerService;
import com.tinyurl.tinyurl.tinyurl.util.UrlShortnerEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class UrlShortnerImpl implements UrlShortnerService {

    @Autowired
    ClientService clientService;
    Map<String, BigInteger> tinyURLmap = new ConcurrentHashMap<>();
    private static BigInteger urlId = new BigInteger("1");

    Lock lock = new ReentrantLock();
    @Override
    public String getUrlShortner(String url, String clientId) throws ClientNotExistException {

        if (!clientService.clientIsExist(clientId)) {
            System.out.println("Client ID doesn't exist. Please provide a valid client ID.");
            throw new ClientNotExistException("Client Not Found");
        }
        String mapKey = url + "_" + clientId;
        if (tinyURLmap.containsKey(mapKey)) {
            BigInteger value = tinyURLmap.get(mapKey);
            String shortURL = UrlShortnerEncoding.encodeBase62(value);
            return shortURL;
        } else {
            lock.lock();
            try {
                String shortURL = UrlShortnerEncoding.encodeBase62(urlId);
                tinyURLmap.put(mapKey, urlId);
                urlId = urlId.add(new BigInteger("1"));
                return shortURL;
            } finally {
                lock.unlock();
            }
        }
    }
}
