package com.mphasis.ocs.config;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectHelper {
	
	private static Logger logger=Logger.getLogger(AspectHelper.class);
	@Pointcut("execution(* com.mphasis.ocs.*.*.*(..))")
	public void getAll() {}
	
	@Before("getAll()")
	public void beforeMethod(JoinPoint joinPoint) {
		logger.debug("before the method"+joinPoint.getSignature().getName());
		logger.debug(Arrays.toString(joinPoint.getArgs()));
	}
	
	@After("getAll()")
	public void afterMethod(JoinPoint joinPoint) {
		logger.debug("after the method"+joinPoint.getSignature().getName());
		logger.debug(Arrays.toString(joinPoint.getArgs()));
	}
	
	@AfterThrowing(pointcut="execution(* com.mphasis.ocs.*.*.*(..))",throwing="ex")
    public void afterThrowingExecution(JoinPoint jp,Exception ex) {
		logger.debug("After throwing advice:"+jp.getSignature().getName()+".Class:"+jp.getTarget().getClass().getSimpleName());
		logger.debug(Arrays.toString(jp.getArgs()));
    }
   /* @Around("getAll()")
	public void aroundMethod(JoinPoint joinPoint) {
		System.out.println("around the method"+joinPoint.getSignature().getName());
		System.out.println(Arrays.toString(joinPoint.getArgs()));
	}*/
	
    @AfterReturning("getAll()")
    public void afterReturnMethod(JoinPoint joinPoint) {
    	logger.debug("after returning the method"+joinPoint.getSignature().getName());
    	logger.debug(Arrays.toString(joinPoint.getArgs()));
    }

}
