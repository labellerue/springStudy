package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

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
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.model.PageVo;

/*
 * get과 post는 기본적으로 따로 나뉘어져 있지 않습니다.
 * 설정을 걸어주려면 RequestMethod에 있는 enum 중에 골라주세요
 */
@RequestMapping("/user")
@Controller
public class UserController {

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource(name = "userService")
	private UserServiceInf userService;

	@RequestMapping(value = "/loginView", method = RequestMethod.GET)
	public String loginView() {
		return "login/login";
	}

	@RequestMapping(value = "/loginProcess", method = { RequestMethod.POST, RequestMethod.GET })
	public String loginProcess(UserVo userVo, Model model) {
		logger.debug("userId / pass : {}, {}", userVo.getUserId(), userVo.getPass());
		String url = "login/login";

		url = (userVo.getUserId().equals("brown") && userVo.getPass().equals("brownpass")) ? "main" : "login/login";

		if (url.equals("main"))
			model.addAttribute("userId", userVo.getUserId());

		return url;
	}

	@RequestMapping(value = "/userAllList")
	public String userAllList(Model model) {

		// userService 사용자 전체 정보조회
		List<UserVo> userList = userService.selectUserAll();

		model.addAttribute("userList", userList);

		return "user/userAllList";
	}

	@RequestMapping(value = "/userPageList")
	public String userPageList(Model model, PageVo pageVo) {

		// get 방식의 url로 받아온 page와 pageSize
		pageVo.setPage(pageVo.getPage());
		pageVo.setPageSize(pageVo.getPageSize());

		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		model.addAllAttributes(resultMap);

		return "user/userPageList";
	}

	@RequestMapping(value = "/userDetail")
	public String userDetail(Model model, @RequestParam("userId") String userId) {

		// 사용자 아이디에 해당하는 사용자 정보 조회
		UserVo userDetail = userService.selectUser(userId);
		// jsp로 위임하기 위해 사용자 정보를 attribute에 저장
		model.addAttribute("userDetail", userDetail);

		return "user/userDetail";
	}

	/******** 등록 *********/
	@RequestMapping(value = "/userForm", method = RequestMethod.GET)
	public String userFormView() {
		return "user/userForm";
	}

	@RequestMapping(value = "/userForm", method = RequestMethod.POST)
	public String userForm(@RequestPart("profilePic") MultipartFile part, HttpServletRequest request, UserVo userVo) {

		try {
			if (part.getSize() > 0) {
				String path = request.getServletContext().getRealPath("/profile");
				String fileName = part.getOriginalFilename();
				part.transferTo(new File(path + File.separator + fileName));

				userVo.setProfile("/profile/" + fileName);
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

		int insertCnt = userService.insertUser(userVo);

		// 브라우저 url에 입력될 경로입니다. / 로 시작 필수
		return "redirect:/user/userPageList?page=1&pageSize=10";
	}

	/******** 수정 *********/
	@RequestMapping(value = "/userUpdate", method = RequestMethod.GET)
	public String userUpdate(Model model, String userId) {
		UserVo userDetail = userService.selectUser(userId);
		model.addAttribute("userDetail", userDetail);

		return "user/userUpdateForm";
	}

	@RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
	public String userUpdateForm(@RequestPart("profilePic") MultipartFile part, HttpServletRequest request,
			UserVo userVo) {

		try {
			if (part.getSize() > 0) {
				String path = request.getServletContext().getRealPath("/profile");
				String fileName = part.getOriginalFilename();
				part.transferTo(new File(path + File.separator + fileName));

				userVo.setProfile("/profile/" + fileName);
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

		int updateCnt = userService.updateUser(userVo);

		return "redirect:/user/userDetail?userId=" + userVo.getUserId();
	}

}
