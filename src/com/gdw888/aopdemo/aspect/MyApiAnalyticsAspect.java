package com.gdw888.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
	
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageExceptSettersAndGetters()")
	public void performApiAnalytics() {
		//System.out.println("====>>> Executing @Before advice on performApiAnalytics()");
	}
}
