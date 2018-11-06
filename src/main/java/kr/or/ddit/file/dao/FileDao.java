package kr.or.ddit.file.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.config.db.SqlFactoryBuilder;
import kr.or.ddit.file.model.FileVo;

//spring bean으로 등록 : @Repository(이름을 안붙이면 class명에서 앞글자만 소문자로 변경한 것이 이름)
@Repository //fileDao
public class FileDao implements FileDaoInf{
	private SqlSessionFactory factory;
	
	public FileDao() {
		factory = SqlFactoryBuilder.getSqlSessionFactory();
	}
	
	/**
	* Method : insertFile
	* 작성자 : sohyoung
	* 변경이력 :
	* @param fileVo
	* @return
	* Method 설명 : 파일 정보 저장
	*/
	@Override
	public int insertFile(FileVo fileVo) {
		
		SqlSession session = factory.openSession();
		
		int insertCnt = session.insert("file.insertFile", fileVo);
		session.commit();
		session.close();
		
		return insertCnt;
	}
	
	
	
	

}




























