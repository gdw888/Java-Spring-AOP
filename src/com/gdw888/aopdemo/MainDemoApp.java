package com.gdw888.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gdw888.aopdemo.dao.AccountDAO;
import com.gdw888.aopdemo.dao.MemberShipDAO;

public class MainDemoApp {

	private static Logger myLogger = Logger.getLogger(MainDemoApp.class.getName());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		//MemberShipDAO memberShipDAO = context.getBean("memberShipDAO", MemberShipDAO.class);

		accountDAO.addAccount(new Account("Terry","Platinum"), true);
		accountDAO.addAccount(new Account("Curry","Silver"), true);
		
		
		
		try {
			Account account = accountDAO.findAccounts("Curry");
			myLogger.info("MainDemoApp: "+account);
			
			accountDAO.findAccounts("Curry1");
			
			myLogger.info(""+accountDAO.listAccounts());
		} catch (Exception e) {
			myLogger.info("MainDemoApp: Caught an exception!");
		}
		
		try {
			myLogger.info(""+accountDAO.listAccounts());
		} catch (Exception e) {
			myLogger.info("MainDemoApp: Caught an exception!");
		}
		
		//memberShipDAO.addAccount();

		context.close();
	}
}
