package kr.or.ddit.file.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.file.model.FileVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/root-context.xml"})
public class FileServiceTest {
	
	@Resource(name="fileService")
	private FileServiceInf fileService;

	@Test
	public void insertFiletest() {
		/***Given***/
		FileVo fileVo = new FileVo();
		fileVo.setFile_name("9279f3b9-721b-4e46-a228-43af55bce575.png");
		fileVo.setOrg_file_name("sally.png");
		fileVo.setFile_ext(".png");
		fileVo.setFile_path("D:\\A_TeachingMaterial\\6.JspSrpgin\\upload");

		/***When***/
		int insertCnt = fileService.insertFile(fileVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}

}
