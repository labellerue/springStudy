package kr.or.ddit.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringMessageController {

	@RequestMapping("/messageView")
	public String messageView() {
		return "msg/view";
	}
	
	@PostMapping("/messageView")
	public String messageViewChLocale(Model model, @RequestParam("lang")String lang ) {
		model.addAttribute("lang", lang);
		
		return "msg/view";
	}
	
	
	
}
