package com.au.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//multiple advices inside aspect
@Aspect
public class LoggingAspect {
	
	//to write specifically for circle class write om.au.aop.model.Circle.getName()
//	@Before("execution(public String getName())")
//	public void LoggingAdvice() {
//		System.out.println("Logging Advice");
//	}
	
	//Apply before all methods start with get
	//execution(public * get*(*) - with parameter
	//execution(public * get*(..) - with any number of parameters
	//execution(* com.au.aop.model.*.get*()) - all get functions for class under model
	@Before("execution(public * get*())")
	public void LoggingAdvice() {
		System.out.println("Logging Advice");
		
	}
	
	@Before("allGetters()")
	public void SecondAdvice() {
		System.out.println("Method Invoked BEFORE all Getters");
		
	}
	
	//Define pointcut expression
	@Pointcut("execution(public * get*(..))")
	public void allGetters() { 
		/* this is a dummy method for holding pointcut expressions, so they can be referenced later in annotations @Before etc */
	}
	// Assignment
	
	
	// After Annotation
	@After("allGetters()")
	public void AfterGetter() {
		System.out.println("Method Invoked AFTER all Getters");
	}
	
	// After returning Annotation
	@AfterReturning(pointcut="execution( public * *(..))", returning = "retVal")
	public void afterReturning(JoinPoint jp, Object retVal) {
		System.out.println("Method Invoked after Returning");
		//System.out.println("Method has Args "  + jp.getArgs());
		//System.out.println("Method Class Name "  + jp.getClass());
		System.out.println("Method Signature Name"  + jp.getSignature());
	} 
	
	// Around Annotation
	@Pointcut("execution (public * set*(..))")
	private void allSet() {}
	
	@Around("allSet()")
	public void aroundAdvice() {
		System.out.println("Print before entering and after exiting the Setter");
	}
	
	
	// After Throwing 
	@AfterThrowing(pointcut ="execution( public * *(..))",throwing="error")
	public void afterThrowingAdvice() {
		System.out.println("Exception Occured");
	}
	

}
