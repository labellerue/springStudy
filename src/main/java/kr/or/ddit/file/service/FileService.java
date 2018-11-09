package kr.or.ddit.file.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.file.dao.FileDaoInf;
import kr.or.ddit.file.model.FileVo;

@Service
public class FileService implements FileServiceInf {
	@Resource(name="fileDao")
	private FileDaoInf fileDao;
	
	@Override
	public int insertFile(FileVo fileVo) {
		int insertCnt = fileDao.insertFile(fileVo);
		
//		if(1==1)
//			throw new RuntimeException(); //임의의 예외 발생!
		
		return insertCnt;
	}

}
