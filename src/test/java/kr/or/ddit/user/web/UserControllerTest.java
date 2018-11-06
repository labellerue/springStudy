package kr.or.ddit.user.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.test.ControllerTestConfig;

public class UserControllerTest extends ControllerTestConfig {

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























