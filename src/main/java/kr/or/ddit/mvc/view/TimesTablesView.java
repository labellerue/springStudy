package kr.or.ddit.mvc.view;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

// 구구단을 출력하는 custom view
// spring customview를 만들기 위해서는 View interface를 구현할 필요가 있음
public class TimesTablesView implements View{

	@Override
	public String getContentType() {
		//스스로 html임을 인지
		return null;
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		response.setContentType("text/html; charset=utf-8");
		
		// url에서 파라메터로 받아 단 설정
		int dan = (int)model.get("tables");
		
		PrintWriter out = response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>TimesTables</title>");
		out.print("<style type=\"text/css\">");
		out.print("	tr td {border: 1px solid skyblue;}");
		out.print("</style>");
		out.print("</head>");
		out.print("<body>");
		out.print("<table>");
		for(int i=2 ; i<dan+1 ; i++){
			out.print("	<tr>");
			for(int j=1 ; j<10 ; j++){
				out.print("		<td>"+i+"*"+j+"="+(i*j)+"</td>");
			}
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	
	}
	
	
	
	
	
	

}





















