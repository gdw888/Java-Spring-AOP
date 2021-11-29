package com.gdw888.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDAO {
	public void addAccount() {
		System.out.println(getClass() + "Doing my db work: adding an account");
	}
}
