package kr.or.ddit.rangers.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.rangers.model.RangerVo;

@Repository
public class RangersDao implements RangersDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	@Override
	public List<RangerVo> selectAllRangers() {
		List<RangerVo> rangersList = template.selectList("rangers.selectAllRangers");
		return rangersList;
	}

	@Override
	public int insertRanger(RangerVo ranger) {
		return template.insert("rangers.insertRanger",ranger);
	}
	

}
