package kr.or.ddit.hello;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.user.model.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/servlet-context.xml"})
@WebAppConfiguration		//spring.ioc 컨테이너 구성을 web 환경에 맞게 구성
public class HelloControllerTest {

	private Logger logger = LoggerFactory.getLogger(HelloControllerTest.class);
	
	//spring ioc 컨테이너
	@Autowired
	private WebApplicationContext ctx;
	
	//dispatcher servlet(front controller) 개발자가 설정해줘야 함
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		// 임시 테스트 목업 입니다. 테스트를 위해 jsp 대신으로 사용할거예요
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void helloTest() throws Exception {
		/***Given***/

		/***When***/
		//dispatcher servlet으로 요청 전송
		MvcResult result = mockMvc.perform(get("/hello/hello.do")).andReturn(); //리턴을 해주는 것이 MvcResult 타입
		ModelAndView mav = result.getModelAndView();
		
		/***Then***/
		//view: hello
		assertEquals("hello", mav.getViewName());  // controller에서의 return 뷰 입니다. 
		
	}
	
	@Test
	public void modelTest() throws Exception {
		/***Given***/
		MvcResult result = mockMvc.perform(get("/hello/model")).andReturn();
		
		/***When***/
		ModelAndView mav = result.getModelAndView();
		String viewName = mav.getViewName();
		List<String> rangers = (List<String>)mav.getModel().get("rangers");
//		List<String> rangers = (List<String>)mav.getModelMap().get("rangers");
		
		for(String ranger : rangers)
			logger.debug("ranger: {}",ranger);
		
		/***Then***/
		//1. view 이름
		assertEquals("hello", viewName);
		//2. rangers 속성(model)
		assertEquals(3, rangers.size());
		
	}
	
	@Test
	public void requestTest() throws Exception {
		/***Given***/
		MvcResult result = mockMvc.perform(get("/hello/request").param("userId", "brown").param("pass", "brownpass")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();

		//view Name
		String viewName = mav.getViewName();
		
		//userId, pass 속성
		String userId = (String)mav.getModel().get("userId");
		String pass = (String)mav.getModel().get("pass");
		
		/***Then***/
		assertEquals("hello", viewName);
		assertEquals("brown_attr", userId);
		assertEquals("brownpass_attr", pass);
		
	}
	
	
	@Test
	public void voTest() throws Exception {
		/***Given***/
		//vo메서드는 parameter를 UserVo로 받아요~ spring은 변수명이 동일하면 알아서 매칭 합니다.
		//그래서 param(String, String) 형태로 인자값을 넘겨줍니다.
		MvcResult result = mockMvc.perform(get("/hello/vo").param("userId", "brown").param("pass", "brownpass")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();
		
		//view name
		String viewName = mav.getViewName();
		// HelloController에서 설정한 attribute 중 "userVo"인 결과값 받아와요 
		UserVo userVo = (UserVo)mav.getModel().get("userVo");

		/***Then***/
		assertEquals("hello", viewName);
		assertEquals("brown", userVo.getUserId());
		assertEquals("brownpass", userVo.getPass());
		
	}
	
	@Test
	public void modelAndViewTest() throws Exception {
		/***Given***/
		MvcResult result = mockMvc.perform(get("/hello/medelAndView")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();
		String viewName = mav.getViewName();
		
		List<String> rangers = (List<String>)mav.getModel().get("rangers");
		
		/***Then***/
		assertEquals("hello", viewName);
		assertEquals("brown", rangers.get(0));
		assertEquals("cony", rangers.get(1));
		assertEquals("sally", rangers.get(2));
	}

}

























