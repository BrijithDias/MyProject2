package com.example.microservicesdemo;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebAccountsService {

    @Autowired        // NO LONGER auto-created by Spring Cloud (see below)
    @LoadBalanced     // Explicitly request the load-balanced template               // with Ribbon built-in
    protected RestTemplate restTemplate; 

    protected String serviceUrl;
    

    public WebAccountsService() {
	}

	public WebAccountsService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ?
               serviceUrl : "http://" + serviceUrl;
    }

    public Account getAccountInfo() throws AccountNotFoundException {
        Account account = restTemplate.getForObject(serviceUrl+ "/data", Account.class);

        if (account == null)
            throw new AccountNotFoundException();
        else
            return account;
    }
}