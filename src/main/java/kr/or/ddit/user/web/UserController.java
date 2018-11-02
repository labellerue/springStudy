package kr.or.ddit.user.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.user.model.UserVo;
/*
 * 문제:
 * [사용자 로그인]
	kr.or.ddit.user.web.UserController
	
	/user/loginView ==> /WEB-INF/view/login/login.jsp
	/user/loginProcess ==> userId == brown / brwonPass
	                       이면 /WEB-INF/view/main.jsp
						   그렇지 않으면 
						   /WEB-INF/view/login/login.jsp
	login.jsp, main.jsp 화면을 jsp/servlet
	수업시간에 만든 결과물과 동일하게 브라우저에
	표시될 수 있도록 개발
 */

/*
 * get과 post는 기본적으로 따로 나뉘어져 있지 않습니다.
 * 설정을 걸어주려면 RequestMethod에 있는 enum 중에 골라주세요
 */
@RequestMapping("/user")
@Controller
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	
	@RequestMapping(value="/loginView", method= RequestMethod.GET)
	public String loginView() {
		return "login/login";
	}
	
	@RequestMapping(value="/loginProcess", method= {RequestMethod.POST,RequestMethod.GET})
	public String loginProcess(UserVo userVo, Model model) {
		logger.debug("userId / pass : {}, {}", userVo.getUserId(), userVo.getPass());
		String url = "login/login";
		
		url = (userVo.getUserId().equals("brown") && userVo.getPass().equals("brownpass")) ? "main":"login/login";
		
		if(url.equals("main"))
			model.addAttribute("userId",userVo.getUserId());
		
		return url;
	}
	
	
}









