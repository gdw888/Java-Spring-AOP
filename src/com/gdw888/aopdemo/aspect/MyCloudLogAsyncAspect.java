package com.gdw888.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageExceptSettersAndGetters()")
	public  void logToCloudAsync() {
		//System.out.println("====>>> Executing @Before advice on logToCloudAsync()");
	}
}
