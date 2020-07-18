package com.example.microservicesdemo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Account")
public class Account {
private String name;
private String accountNumber;
private String balance;


public Account() {
	
}

public Account(String name, String accountNumber, String balance) {
	this.name = name;
	this.accountNumber = accountNumber;
	this.balance = balance;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}

public String getBalance() {
	return balance;
}

public void setBalance(String balance) {
	this.balance = balance;
}


}
