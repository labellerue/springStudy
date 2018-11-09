package kr.or.ddit.mvc;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.user.model.UserVo;

@RequestMapping("/ajax")
@Controller
public class AjaxController {

	private Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	// ajax 테스트를 위한 view 요청
	@RequestMapping("/view")
	public String view() {
		return "ajax/view";		//jsp
	}
	
	@ResponseBody
	@PostMapping(value="/getRangers", produces= {"application/json"})
	public List<UserVo> getRangers(@RequestBody UserVo userVo){
		// ajax/view의 json값 넘어오는지 확인
		// json -> java(UserVo) 마샬링
		logger.debug("json : {}", userVo);
		
		// java -> json 언마샬링 준비
		List<UserVo> rangers = new ArrayList<UserVo>();
		rangers.add(new UserVo("brown", "브라운"));
		rangers.add(new UserVo("sally", "샐리"));
		rangers.add(new UserVo("cony", "코니"));
		
		return rangers;
	}
	
	
	
}
