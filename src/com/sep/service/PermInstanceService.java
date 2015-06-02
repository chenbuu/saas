package com.sep.service;

import java.util.List;

import com.sep.model.PermInstance;

/**
 * 
 * @author ChenTao
 * @date 2015年05月29日下午2:41:16
 */
public interface PermInstanceService extends BaseService<PermInstance> {

	public List<Long> findByRoleId(Long roleId);

}