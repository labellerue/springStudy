package kr.or.ddit.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/root-context.xml",
								"classpath:kr/or/ddit/config/spring/transaction-context.xml",
								"classpath:kr/or/ddit/config/spring/datasource-test-context.xml",
								"classpath:kr/or/ddit/config/spring/batch-context.xml"})
public class ServiceDaoTestConfig {
	
	@Resource(name="datasource")
	private DataSource datasource;
	
	@Before
	public void rangerSetup() {
		// 데이터 초기화
		// 이전에는 junitTest에서 delete문을 실행하였으나 test용 sql문 
		// delete query 호출 --> sql 스크립트를 실행해주는 존재
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("/kr/or/ddit/config/db/dbInit.sql"));
		// 안전장치 1 : 테스트용 접속 생성(db-test.properties, datasource-test-context) 
		// 안전장치 2
		populator.setContinueOnError(false); //에러가 발생했을 때 다음 스크립트 실행 X
		DatabasePopulatorUtils.execute(populator, datasource); //(sql문, db 연결정보)
	
	}
	
	@Ignore
	@Test
	public void test() {
		assertFalse(!true);
	}
	

}

























