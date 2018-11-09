package kr.or.ddit.user.dao;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements UserDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	/**
	* Method : selectUserAll
	* 작성자 : pc02
	* 변경이력 :
	* @return 테이블 전체 list
	* Method 설명 : 테이블 데이터 전체 조회
	 */
	@Override
	public List<UserVo> selectUserAll(){
		
		//selectOne : 데이터가 한 건일 때
		//selectList : 여러건의 데이터를 조회할 때
		//메소드 인자: 문자열 = 네임스페이스(모듈명).쿼리아이디
		List<UserVo> userList = template.selectList("jspuser.selectUserAll");
		
		return userList;
	}
	
	// 회원정보 조회 
	@Override
	public UserVo selectUser(String userId){
		
		UserVo userVo = template.selectOne("jspuser.selectUser", userId);
		
		return userVo;
	}
	
	@Override
	public UserVo selectUser(UserVo userVo){
		
		UserVo userVoResult = template.selectOne("jspuser.selectUserByVo", userVo);
		
		return userVoResult;
	}
		

	@Override
	public List<UserVo> selectUserPageList(PageVo pageVo) {
		
		List<UserVo> userList = template.selectList("jspuser.selectUserPageList", pageVo);

		return userList;
	}

	/**
	* Method : getUserCnt
	* 작성자 : sohyoung
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 건수 조회
	*/
	@Override
	public int getUserCnt() {
		
		int totalUserCnt = template.selectOne("jspuser.getUserCnt");
		
		return totalUserCnt;
	}

	/**
	* Method : insertUser
	* 작성자 : sohyoung
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 등록
	*/
	@Override
	public int insertUser(UserVo userVo) {
		
		int insertCnt = template.insert("jspuser.insertUser", userVo);
		
		return insertCnt;
	}

	/**
	* Method : insertUser
	* 작성자 : sohyoung
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 삭제
	*/
	@Override
	public int deleteUser(String userId) {
		
		int deleteCnt = template.delete("jspuser.deleteUser", userId);
		
		return deleteCnt;
	}

	@Override
	public int updateUser(UserVo userVo) {
		
		int updateCnt = template.update("jspuser.updateUser", userVo);
		
		return updateCnt;
	}
	
	
	
	
}











