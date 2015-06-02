package com.sep.dao;

import java.util.List;

import com.sep.model.PermInstance;

/**
 * 
 * @author ChenTao
 * @date 2014年10月4日下午7:48:27
 */
public interface PermInstanceDao extends BaseDao<PermInstance> {

	public List<Long> findByRoleId(Long roleId);
}
