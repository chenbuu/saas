package com.sep.dao;

import java.util.List;

import com.sep.model.Dic;

/**
 * 
 * @author ChenTao
 * @date 2014年10月4日下午7:48:27
 */
public interface DicDao extends BaseDao<Dic> {

	/**
	 * 字典查找主要的依赖方法
	 * 
	 * @author ChenTao
	 * @date 2014年12月8日下午5:07:14
	 */
	public List<Dic> findDic(String obj, String attr);

}
