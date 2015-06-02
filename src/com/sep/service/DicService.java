package com.sep.service;

import java.util.List;

import com.sep.model.Dic;

/**
 * 
 * @author ChenTao
 * @date 2015年05月29日下午2:41:16
 */
public interface DicService extends BaseService<Dic> {

	/**
	 * 字典查找主要的依赖方法
	 * 
	 * @author ChenTao
	 * @date 2014年12月8日下午5:16:12
	 */
	public abstract List<Dic> findDic(String obj, String attr);

	/**
	 * 单例，根据数字返回描述
	 * 
	 * @author ChenTao
	 * @date 2014年12月8日下午5:34:16
	 */
	public abstract String toName(String obj, String attr, Integer dicValue);

	/**
	 * 单例，根据描述返回数字
	 * 
	 * @author ChenTao
	 * @date 2014年12月8日下午5:34:16
	 */
	public abstract Integer toValue(String obj, String attr, String dicName);

	/**
	 * 多例，根据数字返回描述
	 * 
	 * @author ChenTao
	 * @date 2014年12月8日下午5:34:16
	 */
	public abstract String toName4List(List<Dic> dics, Integer dicValue);

	/**
	 * 多例，根据描述返回数字
	 * 
	 * @author ChenTao
	 * @date 2014年12月8日下午5:34:16
	 */
	public abstract Integer toValue4List(List<Dic> dics, String dicName);

}