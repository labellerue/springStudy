package kr.or.ddit.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
public class JsonViewController {
	
	@ModelAttribute
	public void modelAttribute(Model model) {
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		model.addAttribute("rangers",rangers);
	}
	
	// json 응답을 생성하는 url 요청
	// 레인저스 정보를 json으로 응답을 생성
	@RequestMapping("/rangersJsonView")
	public String jsonView() {
		
		// 아래와 같이 직접 작성해야할 문자열을
		// "{rangers : [{name:cony, id:rabbit}, {name:brown, id:bear}] }"
		// 컬렉션, object정보를 json 문자열로 생성

		
		// json을 생성하는 view
		// servlet-context에 추가한 빈 MappingJackson2JsonView의 아이디
		return "jsonView";
		
		// controller에서 리턴하는 viewName(jsonView)를 처리하기 위해
		// 처리해줄 viewResolver를 우선순위(order)에 따라서
		// 1. beanNameResolver를 통해 view를 생성하려고 시도하게 됨
		// 2. jsonView라고 하는 이름의 빈이 있는지를 확인
		// 3. 해당 viewName과 동일한 이름의 빈이 있으므로
		// internalResourceViewResolver까지 가지 않고 beanNameViewResolver에서 처리하게 됨
		
		// 만약 viewName이 "hello"인 경우라면
		// 처리해줄 viewResolver를 통해 view를 생성하려고 시도하게됨
		// 1. beanNameResolver를 통해 view를 생성하려고 시도하게 됨
		// 2. hello라고 하는 이름의 빈이 있는지를 확인  ==> 존재하지 않음
		// 3. 다음 우선순위인 InternalResourceViewResolver가 처리하게됨
		// InternalResourceViewResolver는 해당 리소스(hello.jsp)가 있는지 여부를 
		// 상관하지 않고 prefix, suffix를 무조건 반영하여 forward 합니다.
		// 그렇기 때문에 오타 또는 존재하지 않는 파일(jsp)을 리턴하게되면 에러 발생
		// 그런 이유로 InternalResourceViewResolver는 viewResolver 설정시
		// 우선순위를 최하위로 둔다.
		
	}
	
	// 위와 같은 행위를 하나, 실무에서는 위와 같은 형태를 더 자주 사용합니다.
	@RequestMapping("/rangersJsonViewObj")
	public View rangersJsonViewObj() {
		
		return new MappingJackson2JsonView();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
