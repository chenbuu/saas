package com.sep.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sep.model.Dic;
import com.sep.util.ComboBox;
import com.sep.util.Condition;
import com.sep.util.Pagination;

/**
 * 字典
 * 
 * @author ChenTao
 * @date 2015年05月30日下午3:03:38
 */
@Controller("dicAction")
@Scope("prototype")
@RequestMapping("/dicAction")
public class DicAction extends BaseAction<Dic> {

	private static final long serialVersionUID = 3292975514185597795L;

	private static final Log log = LogFactory.getLog(DicAction.class);

	// 以下是业务属性
	private Dic dic;

	/**
	 * 查询下拉框字典
	 * 
	 * @author ChenTao
	 * @date 2015年5月30日下午3:43:53
	 */
	public String dic4Box() {
		try {
			// 不判断用户权限为了提高性能
			if (dic == null || dic.getObj() == null || dic.getAttr() == null) {
				throw new Exception("参数不足导致无法查询字典");
			}
			List<Condition> conditions = new ArrayList<Condition>();
			Pagination pagination = new Pagination();// 不分页不排序
			conditions.add(new Condition("obj", "=", dic.getObj()));
			conditions.add(new Condition("attr", "=", dic.getAttr()));
			// 查询
			List<Dic> dics = this.dicService.listAndSort(pagination, conditions);
			List<ComboBox> ComboBoxs = new ArrayList<ComboBox>();
			for (Dic dic : dics) {
				ComboBoxs.add(new ComboBox(dic.getValue().longValue(), dic.getName()));
			}
			dataMap.put("box", ComboBoxs);
			dataMap.put("success", true);
		} catch (Exception e) {
			dataMap.put("message", "参数不足导致无法查询字典");
			dataMap.put("success", false);
			log.debug(e);
		}
		return SUCCESS;
	}

	// Get方法
	public Dic getDic() {
		return dic;
	}

	// Set方法
	public void setDic(Dic dic) {
		this.dic = dic;
	}

}