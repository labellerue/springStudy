package kr.or.ddit.mvc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.file.service.FileServiceInf;
import kr.or.ddit.file.util.FileUtil;

//@ModelAttribute에 의해 저장된 속성이 있을 경우
//재요청시 @ModelAttribute가 적용된 메소드를 재실행하지 않고
//세션에 저장하여 값을 재활용(잘 변경되지 않는 값을 저장할 경우 메소드가 매번 호출되는 과부하를 줄일 수 있다.)
@SessionAttributes("rangers")
@Controller
public class MvcController {
	private Logger logger = LoggerFactory.getLogger(MvcController.class);
	@Resource(name="fileService")
	private FileServiceInf fileService;
	
	//@RequestMapping이 붙은 메소드가 실행되기 전에 **먼저** 실행됨
	//해당 컨트롤러에서 공통적으로 사용될 속성이 있을 경우
	//중복을 피하기 위해 @ModelAttribute 어노테이션을 적용한 메소드를 통해 
	//코드 중복을 막을 수 있음
/*	@ModelAttribute
	public List<String> setup(Model model) {
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		
		model.addAttribute("rangers", rangers);
	}
*/
	//컨트롤러가 호출 될 때 마다 실행되기 때문에 클래스에 @SessionAttributes("rangers")를 추가해줍니다.
	@ModelAttribute(value="rangers")//리턴 값의 이름을 정해줌
	public List<String> setup(Model model) {
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		logger.debug("{}","setup");
		
		//model.addAttribute("rangers", rangers);
		return rangers;
	}
	
	@RequestMapping("/mvc/view")
	public String mvcView() {
		
		return "mvc/view";
	}
	
	
	@RequestMapping("/mvc/view2")
	public String mvcView2(@ModelAttribute("rangers")List<String> rangers) {
		
		for(String ranger : rangers)
			logger.debug("ranger : {}",ranger);
		rangers.add("james");
		return "mvc/view";
	}
	
	//@PathVariable : 요청 url의 일부를 메소드 인자로 쉽게 받을 수 있는 어노테이션
	// http://localhost:8081/mvc/central 이면 콘솔에 libcd central 
	// http://localhost:8081/mvc/left 이면 콘솔에 libcd left가 나와야 함 
	@RequestMapping("/mvc/{libcd}")
	public String pathVariable(@PathVariable("libcd") String libcd) {
		logger.debug("libcd {}",libcd);
		return "mvc/view";
	}
	
	/* 파일 처리 */
	
	// fileuploadView와 fileupload는 같은 맵핑이지만 method 방식으로 호출이 갈림
	// 기본 method는 get 입니다.
	
	//fileupload 테스트를 위한 view(get)
	@RequestMapping(value="/mvc/fileupload")
	public String fileuploadView() {
		
		return "mvc/fileuploadView";
	}
	
	//fileupload (파일전송)을 처리하기 위한 controller method(post)
	@RequestMapping(value="/mvc/fileupload", method= RequestMethod.POST)
	public String fileupload(@RequestPart("uploadfile") MultipartFile part,
							 @RequestParam("userId") String userId) {
		logger.debug("userId {}",userId);
		
		// 1. File객체 생성(경로+파일명 ==> 파일명 충돌방지를 위한 유니크한 임의의 파일명 생성)
		String path = "D:\\A_TeachingMaterial\\6.JspSrpgin\\upload"; //저장될 경로
		String fileName = UUID.randomUUID().toString();			//임의의 이름으로 문자와 숫자의 조합으로 만들어 줍니다.
		String originalFileName = part.getOriginalFilename();	//사용자가 업로드한 실제 파일명
		String fileExt = FileUtil.getFileExt(originalFileName);
		File file = new File(path + File.separator + fileName +fileExt);
		
		FileVo fileVo = new FileVo();
		fileVo.setFile_name(fileName+fileExt);
		fileVo.setFile_path(path);
		fileVo.setOrg_file_name(originalFileName);
		fileVo.setFile_ext(fileExt);
		
		logger.debug("fileVo : {}",fileVo);
		
		try {
			if(part.getSize() > 0) {
				//파일 객체를 인자로 받아 정해진 path에 업로드 파일을 작성
				part.transferTo(file);
				
				//데이터베이스에 첨부파일 정보 저장
				fileService.insertFile(fileVo);
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return "mvc/fileuploadView";
	}
	
	
	
	
	
	
	
	
	
	
	
}














