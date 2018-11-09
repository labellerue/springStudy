package kr.or.ddit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* LoggingAdvice.java
*
* @author pc02
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* pc02 최초 생성
* 공통 관심사(메소드 호출 로깅)를 담당하는 advice
*
* </pre>
*/
public class LoggingAdvice {
	
	private Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);

	// 우리가 구현하는 비지니스 로직이 실행되기 전에 실행되는 공통 로직
	public void beforeAdvice(JoinPoint joinPoint) {
		
		// joinPoint: 우리가 구현한 로직을 담은 메서드
		// beforeAdvice가 먼저 호출, 그 다음 joinPoint 호출
		String methodName = joinPoint.getSignature().getName();
		String clasName = joinPoint.getTarget().getClass().getName();
		
		logger.debug("BEFORE className : {} ", clasName);
		logger.debug("BEFORE methodName : {} ", methodName);
	}
	
	public void afterAdvice(JoinPoint joinPoint) {
		
		// joinPoint: 우리가 구현한 로직을 담은 메서드
		// beforeAdvice가 먼저 호출, 그 다음 joinPoint 호출
		String methodName = joinPoint.getSignature().getName();
		String clasName = joinPoint.getTarget().getClass().getName();
		
		logger.debug("AFTER className : {} ", clasName);
		logger.debug("AFTER methodName : {} ", methodName);
	}
	
	// 비지니스로직 전 후로 다른 로직을 삽입
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

		// 실제 메소드 실행 전
		long startTime = System.currentTimeMillis();
		
		// 실제 비지니스 메소드 호출(원하는 시점에 호출) 인자도 받을 후 있음
		Object[] args = joinPoint.getArgs();	// 비지니스 메소드 매개변수
		Object obj = joinPoint.proceed(args);	// 비지니스 메소드 실행
		
		// 실제 비지니스 메소드 호출 후
		long endTime = System.currentTimeMillis();
		logger.debug("AOP duration : {}", endTime-startTime);
		
		return obj;
	}
	
	
	
}


















