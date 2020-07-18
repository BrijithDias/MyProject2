package com.example.microservicesdemo;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebAccountsControllers {
   
	
	public WebAccountsControllers() {
	}


	@Autowired
	protected WebAccountsService accountsService;

	

	public WebAccountsControllers(WebAccountsService accountsService) {
		this.accountsService = accountsService;
	}


	@RequestMapping(value= "/getdata")
	public Account byNumber(Model model) throws AccountNotFoundException {
		Account account = accountsService.getAccountInfo();
		model.addAttribute("account", account);
		return account;
	}

}
