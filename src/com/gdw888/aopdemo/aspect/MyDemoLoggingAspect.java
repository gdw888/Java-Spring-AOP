package com.gdw888.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.gdw888.aopdemo.Account;
import com.gdw888.aopdemo.MainDemoApp;

@Aspect
@Component
@Order(-1)
public class MyDemoLoggingAspect {
	
	private static Logger myLogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageExceptSettersAndGetters()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n====>>> Executing @Before advice on addAccount()");
		
		// display the method signiture
		myLogger.info(""+theJoinPoint.getSignature());
		
		// display the method arguments
		for (Object obj :theJoinPoint.getArgs()) {
			if (obj instanceof Account)  {
				Account account = (Account)obj;
				System.out.print("Account:" +account.getName() +","+ account.getLevel()+"\n");
			}
			else {
				myLogger.info(""+obj);
			}
		}
		myLogger.info("====>>> Exiting @Before advice on addAccount()\n");
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.findAccountsForDaoPackage()")
	public void BeforeFindAccountsAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n====>>> Executing BeforeGetAccountsAdvice");
		myLogger.info(""+theJoinPoint.getSignature());
		for (Object obj : theJoinPoint.getArgs()) {
			myLogger.info(""+obj);
		}
		myLogger.info("====>>> Exiting BeforeGetAccountsAdvice\n");
	}
	
	@AfterReturning(pointcut="com.luv2code.aopdemo.aspect.LuvAopExpressions.findAccountsForDaoPackage()",
					returning="result")
	public void AfterReturningFindAccountsAdvice(JoinPoint theJoinPoint, Account result) {
		myLogger.info("\n====>>> Executing AfterGetAccountsAdvice");
		myLogger.info(""+theJoinPoint.getSignature());
		
		myLogger.info(""+result);
		result.setName(result.getName().toUpperCase()); // Able to modify the result data at the post call
		myLogger.info("====>>> Exiting AfterGetAccountsAdvice\n");
	}
	
	@AfterThrowing(pointcut="com.luv2code.aopdemo.aspect.LuvAopExpressions.findAccountsForDaoPackage()",
					throwing="theExc")
	public void AfterThrowFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		myLogger.info("\n====>>> Executing AfterThrowFindAccountsAdvice");
		myLogger.info(""+theJoinPoint.getSignature());
		myLogger.info(theExc.toString());
		myLogger.info("====>>> Exiting AfterThrowFindAccountsAdvice\n");
	}
	
	@After(value="com.luv2code.aopdemo.aspect.LuvAopExpressions.findAccountsForDaoPackage()")
	public void AfterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n====>>> Executing AfterFinallyindAccountsAdvice");
		myLogger.info(""+theJoinPoint.getSignature());
		myLogger.info("====>>> Exiting AfterFinallyFindAccountsAdvice\n");
	}
	
	@Around(value="com.luv2code.aopdemo.aspect.LuvAopExpressions.listAccountsForDaoPackage()")
	public Object AroundListAccountsAdvice(ProceedingJoinPoint proceddingJoinPoint) {
		Object result = null;
		myLogger.info("\n====>>> Executing AroundListAccountsAdvice");
		long start, end, duration;
		start = System.currentTimeMillis();
		
		myLogger.info(""+proceddingJoinPoint.getSignature());
		try {
			result = proceddingJoinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		end = System.currentTimeMillis();
		duration = end - start;
		myLogger.info("====>>> Exiting AroundListAccountsAdvice: " + duration + "\n");
		
		return result;
	}
}
