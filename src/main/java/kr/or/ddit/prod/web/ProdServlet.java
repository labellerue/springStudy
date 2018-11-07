package kr.or.ddit.prod.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.util.model.PageVo;

/**
 * Servlet implementation class ProdServlet
 */
@WebServlet(urlPatterns={"/prodPageList", "/prodDetail"})
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdServiceInf prodService;       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println("userServlet doGet URI => " + uri);
		
		//제품 페이징 조회
		if(uri.equals("/prodPageList"))
			prodPageList(request, response);
		//제품 상세조회
		else if(uri.equals("/prodDetail"))
			prodDetail(request,response);
	
	}

	
	/**
	* Method : prodPageList
	* 작성자 : sohyoung
	* 변경이력 :
	* @param request
	* @param response
	* Method 설명 : 제품 request
	 * @throws IOException 
	 * @throws ServletException 
	*/
	private void prodPageList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		prodService = new ProdService();
		//userPageList 호출: 메소드 인자-pageVo : page, pageSize
		PageVo pageVo = new PageVo();
		//get 방식의 url로 받아온 page와 pageSize
		pageVo.setPage(Integer.parseInt(request.getParameter("page")));
		pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));

		Map<String, Object> resultMap = prodService.selectProdPageList(pageVo);
		//페이지 리스트
		List<ProdVo> pageList = (List<ProdVo>)resultMap.get("prodPageList");
		
		//페이지 건수
		int pageCnt = (int)resultMap.get("prodPageCnt");
		
		//request 객체에 저장
		request.setAttribute("prodPageList", pageList);
		request.setAttribute("prodPageCnt", pageCnt);
		
		//forward (userAllList.jsp --> userPagingList.jsp)
		RequestDispatcher rd = request.getRequestDispatcher("/prod/prodPageList.jsp");
		rd.forward(request, response);
	}
	
	/**
	* Method : prodDetail
	* 작성자 : sohyoung
	* 변경이력 :
	* @param sohyoung
	* @param response
	* Method 설명 : 제품 상세조회
	 * @throws IOException 
	 * @throws ServletException 
	*/
	private void prodDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String prod_id = request.getParameter("prod_id");
		System.out.println("prod_id 가지고 왔니? " +prod_id);
		
		//prod_id 에 맞는 vo 가져오기
		prodService = new ProdService();
		ProdVo prodVo = prodService.selectProd(prod_id);
		
		//request 객체 생성
		request.setAttribute("prodDetail", prodVo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/prod/prodDetail.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}



























