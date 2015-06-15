package com.sep.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sep.service.DicService;
import com.sep.service.FileInfoService;
import com.sep.service.NewsService;
import com.sep.service.PermInstanceService;
import com.sep.service.PermissionService;
import com.sep.service.RoleService;
import com.sep.service.TenantService;
import com.sep.service.UserService;

/**
 * 基础Action,其他的Action继承他,可选saasId接口
 * 
 * @author ChenTao
 * @date 2014年10月5日下午3:03:38
 */
public class BaseAction<T> extends ActionSupport {

	/**
	 * TODO(配置新Service的资源，省略getset方法，这里需要手动添加，反射无法读取Spring注解)
	 */
	@Resource
	protected UserService userService;

	@Resource
	protected DicService dicService;

	@Resource
	protected FileInfoService fileInfoService;

	@Resource
	protected PermInstanceService permInstanceService;

	@Resource
	protected PermissionService permissionService;

	@Resource
	protected RoleService roleService;

	@Resource
	protected TenantService tenantService;
	
	@Resource
	protected NewsService newsService;

	/**
	 * TODO(以下代码无需修改)
	 */
	private static final long serialVersionUID = 1L;
	protected T model; // model 有可能为 user，student,teacher等等........
	protected InputStream inputStream = null;
	// 以下是页面必要参数
	protected Map<String, Object> dataMap;
	protected Map<String, Object> application;
	protected Map<String, Object> session;
	protected Map<String, Object> request;
	// 以下是session属性
	protected Long userId;
	protected Long roleId;
	protected Long saasId;
	// 以下四个属性是表格分页提供的参数
	protected Integer page;
	protected Integer rows;
	protected String sort;
	protected String order;
	// 以下是通用属性
	protected Integer searchType;
	protected String searchName;
	protected Long dataId;

	/**
	 * 通过反射动态的创建对象
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseAction() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		Class clazz = (Class) type.getActualTypeArguments()[0];
		try {
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		try {
			// 初始化Map对象
			dataMap = new HashMap<String, Object>();
			request = (Map<String, Object>) ActionContext.getContext().get("request");
			session = ActionContext.getContext().getSession();
			application = ActionContext.getContext().getApplication();
		} catch (Exception e) {

		}
		try {
			// 初始化session属性
			userId = (Long) session.get("userId");
			roleId = (Long) session.get("roleId");
			saasId = (Long) session.get("saasId");
		} catch (Exception e) {

		}
	}

	// Get方法
	public T getModel() {
		return model;
	}

	// Set方法
	public void setModel(T model) {
		this.model = model;
	}

	// Get方法
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	// Set方法
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	// Get方法
	public Map<String, Object> getApplication() {
		return application;
	}

	// Set方法
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	// Get方法
	public Map<String, Object> getSession() {
		return session;
	}

	// Set方法
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	// Get方法
	public InputStream getInputStream() {
		return inputStream;
	}

	// Set方法
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	// Get方法
	public Map<String, Object> getRequest() {
		return request;
	}

	// Set方法
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	// Get方法
	public Integer getPage() {
		return page;
	}

	// Set方法
	public void setPage(Integer page) {
		this.page = page;
	}

	// Get方法
	public Integer getRows() {
		return rows;
	}

	// Set方法
	public void setRows(Integer rows) {
		this.rows = rows;
	}

	// Get方法
	public String getSort() {
		return sort;
	}

	// Set方法
	public void setSort(String sort) {
		this.sort = sort;
	}

	// Get方法
	public String getOrder() {
		return order;
	}

	// Set方法
	public void setOrder(String order) {
		this.order = order;
	}

	// Get方法
	public Integer getSearchType() {
		return searchType;
	}

	// Set方法
	public void setSearchType(Integer searchType) {
		this.searchType = searchType;
	}

	// Get方法
	public String getSearchName() {
		return searchName;
	}

	// Set方法
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	// Get方法
	public Long getDataId() {
		return dataId;
	}

	// Set方法
	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}

	// Get方法
	public Long getUserId() {
		return userId;
	}

	// Set方法
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	// Get方法
	public Long getRoleId() {
		return roleId;
	}

	// Set方法
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	// Get方法
	public Long getSaasId() {
		return saasId;
	}

	// Set方法
	public void setSaasId(Long saasId) {
		this.saasId = saasId;
	}

}
