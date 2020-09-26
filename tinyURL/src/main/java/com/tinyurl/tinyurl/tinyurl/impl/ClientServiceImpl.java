package com.tinyurl.tinyurl.tinyurl.impl;

import com.tinyurl.tinyurl.tinyurl.service.ClientService;
import com.tinyurl.tinyurl.tinyurl.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {

    Set<String> clientData = new HashSet<>();

    @Override
    public void addClient(String clientID) {
        this.clientData.add(clientID);
        System.out.println("Client Added:" + clientID);
    }

    @Override
    public boolean clientIsExist(String clientID) {
        if (this.clientData.contains(clientID))
            return true;
        return false;
    }
}
