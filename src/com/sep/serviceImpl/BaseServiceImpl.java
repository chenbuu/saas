package com.sep.serviceImpl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sep.dao.BaseDao;
import com.sep.dao.DicDao;
import com.sep.dao.FileInfoDao;
import com.sep.dao.PermInstanceDao;
import com.sep.dao.PermissionDao;
import com.sep.dao.RoleDao;
import com.sep.dao.TenantDao;
import com.sep.dao.UserDao;
import com.sep.service.BaseService;
import com.sep.util.Condition;
import com.sep.util.Pagination;

/**
 * 用来抽取和实现公共的业务逻辑操作
 * @author ChenTao
 * @date 2014年10月18日下午9:43:37
 */
@Service("baseService")
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	/**
	 * TODO(配置新Dao的资源，省略getset方法，这里需要手动添加，反射无法读取Spring注解)
	 */
	@Resource
	protected UserDao userDao;
	
	@Resource
	protected DicDao dicDao;
	
	@Resource
	protected FileInfoDao fileInfoDao;
	
	@Resource
	protected PermInstanceDao permInstanceDao;
	
	@Resource
	protected PermissionDao permissionDao;
	
	@Resource
	protected RoleDao roleDao;
	
	@Resource
	protected TenantDao tenantDao;
	
	
	/**
	 * TODO(以下代码无需修改)
	 */
	// 当前的T类型
	private Class<?> clazz = null;

	//@Resource // baseDao与BaseService一样都是泛型信息,不能被实例化
	protected BaseDao<T> baseDao;
	// 但是下面需要用baseDao的CRUD方法. baseDao里面的对象不是固定, 可能						
	// baseDao = userDao, tenantDao, roleDao
	
	/**
	 * 获取当前类型的父类型信息(包括父类型参数信息)
	 */
	public BaseServiceImpl() {
		/*System.out.println("当前子类对象:" + this);
		System.out.println("获取当前this对象相应的类型:" + this.getClass());
		System.out.println("获取当前类型的父类型信息(并不包括父类型参数信息):"
				+ this.getClass().getSuperclass());
		System.out.println("获取当前类型的父类型信息(包括父类型参数信息):"
				+ this.getClass().getGenericSuperclass());*/
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		clazz = (Class<?>) type.getActualTypeArguments()[0];
		//System.out.println(clazz);
	}

	/**
	 * 这个方法会在构造函数和spring以来注入之后执行
	 * 
	 * @Title: init
	 * @Description: (通过反射来实例化baseDao)
	 * @param @throws Exception 设定文件
	 * @return void 返回类型
	 */
	@PostConstruct
	public void init() throws Exception {
		//System.out.println("BaseServiceImpl.init()");
		// 根据相应的clazz,吧相应 ****Dao 赋值给BaseDao即可
		// 1: 获取当前clazz的类型,然后获取相应的类名称
		String clazzName = clazz.getSimpleName();
		//System.out.println(clazzName);
		// 2:User===>user===>user+Dao Role====>RoleDao
		String clazzDaoName = clazzName.substring(0, 1).toLowerCase()
				+ clazzName.substring(1) + "Dao";// toLowerCase首字母小写
		//System.out.println(clazzDaoName);
		// 3: 通过clazzDaoName获取相应 Field字段
		// this.getClass().getSuperclass():获取到相应BaseServiceImpl
		Field daoNameField = this.getClass().getSuperclass()
				.getDeclaredField(clazzDaoName);
		//System.out.println(daoNameField.getName());
		Object object = daoNameField.get(this);
		//System.out.println(object);
		// 4: 获取baseDao 字段
		Field baseDaoNameField = this.getClass().getSuperclass()
				.getDeclaredField("baseDao");
		baseDaoNameField.set(this, object);

	}

	@Override
    public T save(T entity) {
		return this.baseDao.save(entity);
	}
    
	@Override
    public List<T> saveAll(List<T> entities) {
		return this.baseDao.saveAll(entities);
	}
	
	@Override
    public T update(T entity){
		return this.baseDao.update(entity);
	}
    
	@Override
    public List<T> updateAll(List<T> entities) {
		return this.baseDao.updateAll(entities);
	}
	
	@Override
    public T saveOrUpdate(T entity) {
		return this.baseDao.saveOrUpdate(entity);
	}
    
	@Override
    public List<T> saveOrUpdateAll(List<T> entities) {
		return this.baseDao.saveOrUpdateAll(entities);
	}
    
	@Override
    public void delete(T entity) {
		this.baseDao.delete(entity);
	}

	@Override
    public void delete(final Long entityId) {
		this.baseDao.delete(entityId);
	}

	@Override
    public void deleteStatusById(final Long entityId) {
		this.baseDao.deleteStatusById(entityId);
	}
    
	@Override
    public T merge(T entity) {
		return this.baseDao.merge(entity);
	}
    
	@Override
    public void refresh(T entity) {
		this.baseDao.refresh(entity);
	}
    
	@Override
    public void flush() {
		this.baseDao.flush();
	}
    
	@Override
	public T findByName(String name) {
		return this.baseDao.findByName(name);
	}
	
	@Override
	public T findByName(String name, Long saasId) { //SaaS
		return this.baseDao.findByName(name, saasId);
	}
	
	@Override
	public List<T> listByName(String name) {
		return this.baseDao.listByName(name);
	}
	
	@Override
	public List<T> listByName(String name, Long saasId) { //SaaS
		return this.baseDao.listByName(name, saasId);
	}

	@Override
	public T findById(Long id) {
		return this.baseDao.findById(id);
	}

	@Override
	public List<T> listAndSort(Pagination pagination, List<Condition> conditions) {
		return this.baseDao.listAndSort(pagination, conditions);
	}
	
	@Override
	public List<T> listAndSort(Pagination pagination, List<Condition> conditions, Long saasId) { //SaaS
		return this.baseDao.listAndSort(pagination, conditions, saasId);
	}

	@Override
	public Long countTotalAmount(List<Condition> conditions) {
		return this.baseDao.countTotalAmount(conditions);
	}
	
	@Override
	public Long countTotalAmount(List<Condition> conditions, Long saasId) { //SaaS
		return this.baseDao.countTotalAmount(conditions, saasId);
	}

	@Override
    public Double sumByAttr(String attr, List<Condition> conditions) {
		return this.baseDao.sumByAttr(attr, conditions);
	}
	
	@Override
    public Double sumByAttr(String attr, List<Condition> conditions, Long saasId) { //SaaS
		return this.baseDao.sumByAttr(attr, conditions, saasId);
	}
    
}
