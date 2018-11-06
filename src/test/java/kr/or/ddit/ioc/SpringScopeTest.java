package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.BoardDaoInf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/ioc/application-context.xml"})
public class SpringScopeTest {
	//DI
			//name=스프링 빈의 id
	@Resource(name="boardDao")
	private BoardDaoInf boardDao;

	@Resource(name="boardDaoSingleton")
	private BoardDaoInf boardDaoSingleton;
	
	/**
	* Method : springBeanScopeSingletonTest
	* 작성자 : sohyoung
	* 변경이력 :
	* Method 설명 : 스프링의 scope singleton 테스트
	*/
	@Test
	public void springBeanScopeSingletonTest() {
		/***Given***/
		

		/***When***/

		/***Then***/
		assertNotEquals(boardDao, boardDaoSingleton);
		//같지 않음...즉 클래스로 비교하는 것이 아니라 각각 객체의 (default값)싱글톤으로 비교
		
	}

}
























