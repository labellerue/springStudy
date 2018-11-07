package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.test.ServiceDaoTestConfig;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.model.PageVo;

import org.junit.Before;
import org.junit.Test;

public class UserServiceTest extends ServiceDaoTestConfig {

	@Resource(name="userService")
	private UserServiceInf userService;
	private final String TEST_USER_ID = "test1";
	
	@Before
	public void before(){
		deleteUserTest(TEST_USER_ID);
		
	}
	
	@Test
	public void selectUserAllTest() {
		/***Given***/

		/***When***/
		List<UserVo> list = userService.selectUserAll();

		/***Then***/
//		assertEquals(5, list.size());
		
	}

	@Test
	public void selectUserTest() {
		/***Given***/

		/***When***/
		UserVo userVo = userService.selectUser("brown");

		/***Then***/
		assertNotNull(userVo);
		
	}

	@Test
	public void selectUserVoTest() {
		/***Given***/

		/***When***/
		UserVo userVo = userService.selectUser(userService.selectUser("brown"));

		/***Then***/
		assertNotNull(userVo);
		
	}
	
	@Test
	public void selectUserPageListTest(){
		/***Given***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(10);

		/***When***/
		Map<String, Object> pageMap = userService.selectUserPageList(pageVo);
		List<UserVo> pageList = (List<UserVo>)pageMap.get("pageList");
		
		int pageCnt = (Integer)pageMap.get("pageCnt");
		
		/***Then***/
		assertEquals(10, pageList.size());
		assertEquals(11, pageCnt);
	}
	
	@Test
	public void insertUserTest(){
		/***Given***/
		UserVo userVo = new UserVo();
		userVo.setUserId(TEST_USER_ID);
		userVo.setName("test1");
		userVo.setPass("test1");
		userVo.setAddr1("test1");
		userVo.setAddr2("test1");
		userVo.setZip("11111");
		String birth =  "2018-10-12";
		Date date= null;
		try {
			date = new SimpleDateFormat("yyyyy-MM-dd").parse(birth);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		userVo.setBirth(date);
		userVo.setEmail("test1");
		userVo.setTel("111111111");

		/***When***/
		int insertCnt = userService.insertUser(userVo);
		System.out.println(insertCnt);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	public void deleteUserTest(String testUserId){
		/***Given***/

		/***When***/
		int deleteCnt = userService.deleteUser(testUserId);
		
		/***Then***/
		//assertEquals(1, deleteCnt);
	}


}











