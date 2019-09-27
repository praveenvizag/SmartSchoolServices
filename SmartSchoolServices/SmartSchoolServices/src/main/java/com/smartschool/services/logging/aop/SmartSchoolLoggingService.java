package com.smartschool.services.logging.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Aspect
public class SmartSchoolLoggingService {

	private Logger logger = LoggerFactory.getLogger(SmartSchoolLoggingService.class);

	@Pointcut(value="execution(* com.smartschool.services.*.*.*(..) )")
	public void getAroundLoggers() {

	}

	@Around("getAroundLoggers()")
	public Object loggService(ProceedingJoinPoint joinPoint) throws Throwable {
		ObjectMapper objectMapper = new ObjectMapper();
		String signature = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		String targetClass = joinPoint.getTarget().toString();
		logger.info("Class Name {} Method Name  {} Arguments {} ", targetClass, signature,
				objectMapper.writeValueAsString(args));

		Object object = joinPoint.proceed();
		logger.info("Class Name {} Method Name  {} Arguments {} ", targetClass, signature,
				objectMapper.writeValueAsString(args));
		return object;

	}

}
