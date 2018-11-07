package kr.or.ddit.exception.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

	/**
	* Method : view
	* 작성자 : sohyoung
	* 변경이력 :
	* @return
	* Method 설명 : 예외를 강제로 발생시키는 url
	*/
	// http://localhost:8081/exception
	@RequestMapping("/exception")
	public String view() {
		throw new ArithmeticException();
	}
	
	
	
	
	
	
}

























