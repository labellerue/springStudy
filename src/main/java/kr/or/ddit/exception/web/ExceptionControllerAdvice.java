package kr.or.ddit.exception.web;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.exception.NoFileException;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler({ArithmeticException.class})
	public String exceptionHandler() {
		
		return "error/arithmetic";
	}
	
	// response status 테스트를 위한 url
	@RequestMapping("/responseStatus")
	public String responseStatus() throws NoFileException {
		ClassPathResource resource = new ClassPathResource("kr/or/ddit/config/db/mybatis-config.xml");
		try {
			resource.getInputStream();
		} catch (IOException e) {
			throw new NoFileException();
		}
		
		return "error/arithmetic";
	}
	
	
	
}
