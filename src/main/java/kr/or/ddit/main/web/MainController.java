package kr.or.ddit.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	/**
	* Method : main
	* 작성자 : sohyoung
	* 변경이력 :
	* @return
	* Method 설명 : 메인 화면 요청
	*/
	@RequestMapping("/main")
	public String main() {
		
		return "main";
	}
	/*
	우선순위에 따라 viewResolver를 검색
	1. beanNameResolver
	1-1. bean id(name)가 "main"인 bean이 있는지 확인 --> 없음
	2. tilesViesResolver
	2-1. tiles-config.xml에서 main이라는 definition이 있는지 확인
	2-2. 해당 definition에 맞는 layout이 적용된 jsp를 결합하여 응답 생성
	 */
	
}
