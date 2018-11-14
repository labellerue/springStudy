package kr.or.ddit.rangers.dao;

import java.util.List;

import kr.or.ddit.rangers.model.RangerVo;

public interface RangersDaoInf {

	/**
	* Method : selectAllRangers
	* 작성자 : pc02test
	* 변경이력 :
	* @return List<RangerVo>
	* Method 설명 : 레인저스 전체 정보 조회
	*/
	List<RangerVo> selectAllRangers();

	/**
	* Method : insertRanger
	* 작성자 : pc02test
	* 변경이력 :
	* @param ranger
	* @return
	* Method 설명 : 레인저 입력
	*/
	int insertRanger(RangerVo ranger);

}
