package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/ioc/application-context-collection.xml"})
public class CollectionInjectTest {

	@Resource(name="collectionBean")
	private CollectionBean collectionBean;
	
	/**
	* Method : collectionBeanTest
	* 작성자 : sohyoung
	* 변경이력 :
	* Method 설명 : 스프링 설정 파일을 통해 collection 객체를 주입이 정상적으로 이루어지는지 테스트
	*/
	@Test
	public void collectionBeanTest() {
		/***Given***/
		
		/***When***/
		List<String> list = collectionBean.getList();
		Set<String> set = collectionBean.getSet();
		Map<String, String> map = collectionBean.getMap();
		Properties properties = collectionBean.getProperty();
		
		/***Then***/
		assertNotNull(collectionBean); //spring 컨테이너에서 DL을 통해 받은 빈: 정상적으로 작동한다면 null이 아니다.
		// list 검증
		assertEquals(4, list.size());
		assertEquals("Miney", list.get(0));
		
		// set 검증
		assertEquals(4, set.size());
		
		// map 검증
		assertEquals("Miney", map.get("name"));
		assertEquals("100", map.get("age"));
		
		// properties 검증
		assertEquals("pc02", properties.get("db.userId"));
		assertEquals("java", properties.get("db.password"));
		
	}

}



















