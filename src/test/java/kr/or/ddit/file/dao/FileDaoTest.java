package kr.or.ddit.file.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.test.ServiceDaoTestConfig;

public class FileDaoTest extends ServiceDaoTestConfig{

	@Resource(name="fileDao")
	private FileDaoInf fileDao;
	
	/**
	* Method : insertFileTest
	* 작성자 : sohyoung 
	* 변경이력 :
	* Method 설명 : 파일정보 입력 테스트
	*/
	@Test(timeout=5000)  //5초 내에 작동해야 성공
	public void insertFileTest() {
		/***Given***/
		FileVo fileVo = new FileVo();
		fileVo.setFile_name("9279f3b9-721b-4e46-a228-43af55bce575.png");
		fileVo.setOrg_file_name("sally.png");
		fileVo.setFile_ext(".png");
		fileVo.setFile_path("D:\\A_TeachingMaterial\\6.JspSrpgin\\upload");

		/***When***/
		int insertCnt = fileDao.insertFile(fileVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}

}
