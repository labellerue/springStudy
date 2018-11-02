package kr.or.ddit.user.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/servlet-context.xml"})
@WebAppConfiguration	// 스프링 컨테이너를 web 기반 컨테이너로 생성
public class UserControllerTest {

	//spring 컨테이너
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void loginViewTest() throws Exception {
		/***Given***/
		MvcResult result = mockMvc.perform(get("/user/loginView")).andReturn();
		
		/***When***/
		String viewName = result.getModelAndView().getViewName();

		/***Then***/
		assertEquals("login/login", viewName);
	}
	
	@Test
	public void loginProcessSuccessTest() throws Exception {
		/***Given***/
		MvcResult result = mockMvc.perform(get("/user/loginProcess").param("userId", "brown").param("pass","brownpass")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();
		String viewName = mav.getViewName();
		
		/***Then***/
		assertEquals("main", viewName);
	}
	
	@Test
	public void loginProcessFailTest() throws Exception {
		/***Given***/
		MvcResult result = mockMvc.perform(post("/user/loginProcess").param("userId", "brown").param("pass","brownpasss")).andReturn();
		
		/***When***/
		ModelAndView mav = result.getModelAndView();
		String viewName = mav.getViewName();
		
		/***Then***/
		assertEquals("login/login", viewName);
	}

}























