package com.gwtjs.register.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.core.mapper.BaseSqlMapper;
import com.gwtjs.register.entity.RegisterVO;
import com.gwtjs.register.entity.RegisterTreeVO;

/**
 * 数据字典
 * @author aGuang
 *
 */
public interface IRegisterDAO extends BaseSqlMapper<RegisterVO> {
	
	//
	RegisterVO getByPathRegister(RegisterVO reg);
	
	//
	RegisterVO findItem(@Param("regId")Integer regId);
	
	//
	List<RegisterTreeVO> findRegisterList(RegisterVO record);
	
	//
	List<RegisterVO> selectList(RegisterVO record,PagerVO page);
	
	//
	List<RegisterTreeVO> findItems(RegisterTreeVO record);

	//
	int selectListCount(RegisterVO record,PagerVO page);
	
	//
	int batchRemovePks(List<RegisterVO> records);

	//
	int batchUpdate(List<RegisterVO> records);

	//
	int batchInsert(List<RegisterVO> records);

}
