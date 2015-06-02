package com.sep.dao;

import java.util.Collection;
import java.util.List;

import com.sep.util.Condition;
import com.sep.util.Pagination;


/**
 * 公共泛型Dao类,可选saasId接口
 * @author ChenTao
 * @date 2014年10月8日下午4:34:04
 */
public interface BaseDao<T> {  
       
    /**
     * 获取当前持久化对象的简单名称
     */
    public String getSimpleName();

    /**
     * 查询，并指定起始的纪录和最大的查询结果集大小以及需要排序的属性和排序的方向。
     * @param startPos 起始纪录的序号。
     * @param amount 最大的查询结果集大小。
     * @param conditions 一个以属性名为key，以属性值为value的<code>Map</code>
     * @param sortableProperty 需要排序的属性。
     * @param desc 排序的方向。
     * @return 结果集。
     */
    public List<T> listAndSort(Pagination pagination, List<Condition> conditions);
    public List<T> listAndSort(Pagination pagination, List<Condition> conditions, Long saasId); //SaaS
    
    /**
     * 根据指定的条件统计当前的总纪录数.
     */
    public Long countTotalAmount(List<Condition> conditions);
    public Long countTotalAmount(List<Condition> conditions, Long saasId); //SaaS

	/**
	 * 根据对象ID来查询对象。
	 * @param id 对象ID。
	 * @return 如果找到对应的对象，则返回该对象。如果不能找到，则返回null。
	 */
	public T findById(Long id);
    
	/**
	 * 根据对象名称来查询对象。(要求name不重复)
	 * @author ChenTao
	 * @date 2014年10月9日下午10:04:32
	 */
	public T findByName(String name);
	public T findByName(String name, Long saasId); //SaaS
	public List<T> listByName(String name);
	public List<T> listByName(String name, Long saasId); //SaaS
		
    /**
     * 持久化指定的对象。
     * @param entity 将要持久化的对象。
     * @return 持久化以后的对象。
     */
    public T save(T entity);
    
    /**
     * 批量持久化给定的对象列表。要求其中所有的对象必须在数据库中都不存在。
     * @param entities 待持久化的对象列表。
     * @return 持久化后的对象列表
     */
    public List<T> saveAll(List<T> entities);
    
    /**
     * 在数据库中删除指定的对象。该对象必须具有对象ID。(不推荐使用)
     * @param entity 将要被删除的对象。
     */
    public void delete(T entity);

    /**
     * 根据指定的对象ID在数据库中删除对象。(不推荐使用)
     * @param entityId 将要被删除的对象的ID。
     */
    public void delete(final Long entityId);
    
    /**
     * 只是更新status的状态为0来达到假删除的目的
     * @author ChenTao
     * @date 2014年10月10日下午9:15:08
     */
    public void deleteStatusById(final Long entityId);
    
    /**
     * 更新给定的对象。
     * @param entity 含有将要被更新内容的对象。
     * @return 更新后的对象。
     */
    public T update(T entity);
    
    /**
     * 批量更新给定的对象列表。要求列表中的对象都已经存在。
     * @param entities 待更新的对象列表。
     * @return 持久化后的对象列表
     */
    public List<T> updateAll(List<T> entities);

    /**
     * 批量更新给定的对象列表。要求列表中的对象都已经存在。
     * @param entities 待更新的对象列表。
     * @return 持久化后的对象列表
     */
    public Collection<T> updateAll(Collection<T> entities);
    
    /**
     * 保存或更新给定的对象。
     * @param entity 含有将要被保存或更新内容的对象。
     * @return 更新后的对象。
     */
    public T saveOrUpdate(T entity);
    
    /**
     * 保存或更新给定的对象列表。
     * @param entity 含有将要被保存或更新内容的对象列表。
     * @return 更新后的对象列表。
     */
    public List<T> saveOrUpdateAll(List<T> entities);
    
    /**
     * 保存或更新给定的对象列表。
     * @param entity 含有将要被保存或更新内容的对象列表。
     * @return 更新后的对象列表。
     */
    public Collection<T> saveOrUpdateAll(Collection<T> entities);
    
    /**
     * 更新给定的对象。
     * @param entity 含有将要被更新内容的对象。
     * @return 更新后的对象。
     */
    public T merge(T entity);
    
    /**
     * 立即刷新对象的状态
     * @param entity
     */
    public void refresh(T entity);
    
    /**
     * 立即刷对象到数据库
     * @param entity
     */
    public void flush();

	/**
	 * 加总和
	 * @author ChenTao
	 * @date 2015年3月5日上午9:29:54
	 */
    public Double sumByAttr(String attr, List<Condition> conditions);
    public Double sumByAttr(String attr, List<Condition> conditions, Long saasId); //SaaS
    
}
