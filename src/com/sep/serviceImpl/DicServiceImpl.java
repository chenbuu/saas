package com.sep.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sep.model.Dic;
import com.sep.service.DicService;

/**
 * 
 * @author ChenTao
 * @date 2015年05月29日下午9:43:37
 */
@Service("dicService")
public class DicServiceImpl extends BaseServiceImpl<Dic> implements DicService {

	/**
	 * 字典查找主要的依赖方法实现
	 * 
	 * @author ChenTao
	 * @date 2014年12月8日下午5:14:55
	 */
	public List<Dic> findDic(String obj, String attr) {
		return this.dicDao.findDic(obj, attr);
	}

	/**
	 * 单例，根据数字返回描述
	 * 
	 * @author ChenTao
	 * @date 2014年12月8日下午5:34:16
	 */
	public String toName(String obj, String attr, Integer dicValue) {
		String dicName = "";
		try {
			List<Dic> dics = this.dicDao.findDic(obj, attr);
			if (dics != null) {
				for (Dic dic : dics) {
					if (dicValue == dic.getValue()) {
						dicName = dic.getName();
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dicName;
	}

	/**
	 * 单例，根据描述返回数字
	 * 
	 * @author ChenTao
	 * @date 2014年12月8日下午5:34:16
	 */
	public Integer toValue(String obj, String attr, String dicName) {
		Integer dicValue = 999;
		try {
			List<Dic> dics = this.dicDao.findDic(obj, attr);
			if (dics != null) {
				for (Dic dic : dics) {
					if (dicName.equals(dic.getName())) {
						dicValue = dic.getValue();
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dicValue;
	}

	/**
	 * 多例，根据数字返回描述
	 * 
	 * @author ChenTao
	 * @date 2014年12月8日下午5:34:16
	 */
	public String toName4List(List<Dic> dics, Integer dicValue) {
		String dicName = "";
		try {
			if (dics != null) {
				for (Dic dic : dics) {
					if (dicValue == dic.getValue()) {
						dicName = dic.getName();
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dicName;
	}

	/**
	 * 多例，根据描述返回数字
	 * 
	 * @author ChenTao
	 * @date 2014年12月8日下午5:34:16
	 */
	public Integer toValue4List(List<Dic> dics, String dicName) {
		Integer dicValue = 999;
		try {
			if (dics != null) {
				for (Dic dic : dics) {
					if (dicName.equals(dic.getName())) {
						dicValue = dic.getValue();
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dicValue;
	}

}