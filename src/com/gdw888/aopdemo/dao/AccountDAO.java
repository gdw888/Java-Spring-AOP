package com.gdw888.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gdw888.aopdemo.Account;

@Component
public class AccountDAO {
	List<Account> accounts;

	public void addAccount(Account account, boolean vipFlag) {
		if (accounts == null) {
			accounts = new ArrayList<>();
		}
		System.out.println(getClass() + "Doing my db work: adding an account\n");
		accounts.add(account);
	}
	
	public Account findAccounts(String matchingName) throws Exception{
		System.out.println(getClass() +": inside of findAccounts");
		for (Account account : accounts) {
			if (account.getName().equals(matchingName)) {
				return account;
			}
		}
		
		throw new Exception();
	}
	
	public List<Account> listAccounts() throws InterruptedException{
		Thread.sleep(3);
		return accounts;
	}
}
