package com.ajay.spring.logging.api.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAdvice {

	// Logger
	Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

	/*
	 * Pointcut expression
	 * example: execution(* com.ajay.spring.logging.api.controller.ProductController.addProduct(Product))
	 * */
	@Pointcut("execution(* com.ajay.spring.logging.api.*.*.*(..))")
	public void myPointCut() {

	}

	@Around("myPointCut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().getName();
		Object[] array = pjp.getArgs();

		/* Before execution */
		log.info("method invoked " + className + " : " + methodName + "() " + "arguments "
				+ mapper.writeValueAsString(array));

		/* to run our method */
		Object responseObj = pjp.proceed();

		/* After execution */
		log.info(className + " : " + methodName + "() " + "response " + mapper.writeValueAsString(responseObj));

		return responseObj;
	}
}
