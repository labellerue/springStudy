package kr.or.ddit.prod.service;

import java.util.Map;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.util.model.PageVo;

public interface ProdServiceInf {
	
	/**
	* Method : getProdCnt
	* 작성자 : sohyoung
	* 변경이력 :
	* @return
	* Method 설명 : 전체 제품 수 구하기
	*/
	int getProdCnt();
	
	/**
	* Method : selectProdPageList
	* 작성자 : sohyoung
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 모든 제품 리스트 가져오기
	*/
	Map<String, Object> selectProdPageList(PageVo pageVo);
	
	/**
	* Method : selectProd
	* 작성자 : sohyoung
	* 변경이력 :
	* @param prod_id
	* @return
	* Method 설명 : 제품 정보 가져오기
	*/
	ProdVo selectProd(String prod_id);

}
