package kr.or.ddit.ioc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardServiceInf;

public class IocMain {
	//어디서 에러가 났는지 클래스 위치를 알려주는 역할
	private static Logger logger = LoggerFactory.getLogger(IocMain.class);
	
	public static void main(String[] args) {
		
		//스프링 컨테이너 생성
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {
				"classpath:kr/or/ddit/ioc/application-context.xml"
		});
		
		//스프링 컨테이너에서 boardDao 스프링 빈을 요청(DL : Dependency Lookup)
		BoardDaoInf boardDao = (BoardDaoInf)context.getBean("boardDao");
		List<BoardVo> boardList = boardDao.selectBoardList();
		for(BoardVo boardVo : boardList) {
			//디버그 실행시에만 문자열 결합이 되도록 {}와 같은 템플릿 제공
			logger.debug("boardVo : {}, {}",boardVo,"test");
		}
		
		//스프링 컨테이너에서 boardService 스프링 빈을 요청후 selectBoardList
		//결과를 logger를 이용해 console 출력
		BoardServiceInf boardService = (BoardServiceInf)context.getBean("boardService");
		boardList = boardService.selectBoardList();
		for(BoardVo boardVo : boardList) {
			logger.debug("boardVo : {} from {}",boardVo,"서비스");
		}
		
		//생성자 주입을 통해 생성된 boardService 스프링 빈을 요청
		BoardServiceInf boardServiceConst = context.getBean("boardServiceConst", BoardServiceInf.class);
		boardList = boardServiceConst.selectBoardList();
		for(BoardVo boardVo : boardList) {
			logger.debug("boardVo : {} from {}",boardVo,"서비스Const");
		}
		
		//spring scope-prototype test
		BoardDaoInf boardDaoPrototype1 = context.getBean("boardDaoPrototype1", BoardDaoInf.class);
		BoardDaoInf boardDaoPrototype2 = context.getBean("boardDaoPrototype1", BoardDaoInf.class);
		logger.debug("spring prototype bean test: {}",boardDaoPrototype1==boardDaoPrototype2);
		
		//spring scope-singleton test
		BoardDaoInf boardDaoSingletone1 = context.getBean("boardDaoSingleton", BoardDaoInf.class);
		BoardDaoInf boardDaoSingletone2 = context.getBean("boardDaoSingleton", BoardDaoInf.class);
		logger.debug("spring singletone bean test: {}",boardDaoSingletone1==boardDaoSingletone2);
		
	}
	

}


















