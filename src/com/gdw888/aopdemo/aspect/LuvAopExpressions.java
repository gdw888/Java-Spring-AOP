package com.gdw888.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setterForDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getterForDaoPackage() {}
	
	@Pointcut("forDaoPackage() && !(setterForDaoPackage() || getterForDaoPackage() || findAccountsForDaoPackage())")
	public void forDaoPackageExceptSettersAndGetters() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.findAccounts(..))")
	public void findAccountsForDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.listAccounts(..))")
	public void listAccountsForDaoPackage() {}
}
