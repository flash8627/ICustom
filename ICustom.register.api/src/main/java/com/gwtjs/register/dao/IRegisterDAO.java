package com.gwtjs.register.dao;

import java.util.List;

import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.register.entity.RegisterVO;

public interface IRegisterDAO extends BaseSqlMapper<RegisterVO> {

	int deleteByPrimaryKey(Long regId);

	int insert(RegisterVO record);

	int insertSelective(RegisterVO record);

	RegisterVO selectByPrimaryKey(Long regId);

	int updateByPrimaryKeySelective(RegisterVO record);

	int updateByPrimaryKey(RegisterVO record);

	List<RegisterVO> selectList(RegisterVO record,PagerVO page);

	int selectListCount(RegisterVO record);

	int batchRemovePks(List<RegisterVO> records);

	int batchUpdate(List<RegisterVO> records);

	int batchInsert(List<RegisterVO> records);

}
