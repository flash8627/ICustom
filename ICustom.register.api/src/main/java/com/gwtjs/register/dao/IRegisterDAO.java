package com.gwtjs.register.dao;

import java.math.BigDecimal;
import java.util.List;

import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.register.entity.RegisterVO;

public interface IRegisterDAO extends BaseSqlMapper<RegisterVO> {

	int deleteByPrimaryKey(BigDecimal regId);

	int insert(RegisterVO record);

	int insertSelective(RegisterVO record);

	RegisterVO selectByPrimaryKey(BigDecimal regId);

	int updateByPrimaryKeySelective(RegisterVO record);

	int updateByPrimaryKey(RegisterVO record);

	List<RegisterVO> selectList();

	int selectListCount(RegisterVO record);

	int batchRemovePks(List<RegisterVO> records);

	int batchUpdate(List<RegisterVO> records);

	int batchInsert(List<RegisterVO> records);

}
