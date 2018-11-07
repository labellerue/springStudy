package kr.or.ddit.prod.web;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.user.web.UserController;
import kr.or.ddit.util.model.PageVo;

@RequestMapping("/prod")
@Controller
public class ProdController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource(name="prodService")
	private ProdServiceInf prodService;
	
	/********	페이징	********/
	@RequestMapping(value="/prodPageList")
	public String prodPageList(Model model, PageVo pageVo) {
		pageVo.setPage(pageVo.getPage());
		pageVo.setPageSize(pageVo.getPageSize());

		Map<String, Object> resultMap = prodService.selectProdPageList(pageVo);
		
		model.addAllAttributes(resultMap);
		
		return "prod/prodPageList";
	}
	
	/********	상세정보	********/
	@RequestMapping(value="/prodDetail")
	public String prodDetail(Model model, @RequestParam("prod_id") String prod_id) {
		ProdVo prodDetail = prodService.selectProd(prod_id);
		
		model.addAttribute("prodDetail", prodDetail);
		
		return "prod/prodDetail";
	}
	
	
	
	

}





















