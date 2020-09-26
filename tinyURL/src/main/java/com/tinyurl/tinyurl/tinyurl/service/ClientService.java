package com.tinyurl.tinyurl.tinyurl.service;

import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    public void addClient(String clientID);
    public boolean clientIsExist(String clientID);

}
