package com.sep.daoImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sep.dao.BaseDao;
import com.sep.util.AbstractDao;
import com.sep.util.Condition;
import com.sep.util.Pagination;
import com.sep.util.TreeCondition;

/**
 * 范型化的BaseDao的实现，作为其他实际被Service层调用的Dao实现的基础。
 * 
 * @author ChenTao
 * @date 2014年10月12日下午2:44:10
 */
@Transactional
@Repository("baseDao")
public abstract class BaseDaoImpl<T> extends AbstractDao implements BaseDao<T> {

	private Class<T> entityClass;

	/**
	 * 数据操作语句的批处理大小设置为50
	 */
	protected static final int UpdateBatchSize = 50;

	@Override
	public String getSimpleName() {
		return this.entityClass.getSimpleName();
	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getentityClass() {
		return this.entityClass;
	}

	/**
	 * 默认构造函数，用于获取范型<code>T</code>的带有类型化信息的<code>Class</code>对象
	 */
	public BaseDaoImpl(Class<T> entityClass) {
		this.entityClass = Objects.requireNonNull(entityClass);
	}

	public Long generateUniqueIdentifier() {
		final String hql = "select S_CoypDataUnique.Nextval from dual";
		try {
			Session session = this.getSession();
			Query query = session.createQuery(hql.toString());
			BigDecimal bigDecimal = (BigDecimal) query.uniqueResult();
			return bigDecimal.longValue();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	@Override
	public List<T> listAndSort(Pagination pagination, List<Condition> conditions) {
		return this.listAndSort(this.getentityClass(), pagination, conditions);
	}

	@Override
	public List<T> listAndSort(Pagination pagination, List<Condition> conditions, Long saasId) { //SaaS
		return this.listAndSort(this.getentityClass(), pagination, conditions, saasId);
	}
	
	/**
	 * 标记实体类型。
	 */
	protected final String getType() {
		return this.getSimpleName().toLowerCase();
	}

	@Override
	public Long countTotalAmount(List<Condition> conditions) {
		StringBuilder hql = new StringBuilder()
				.append("select count(obj.id) from ")
				.append(BaseDaoImpl.this.getentityClass().getSimpleName())
				.append(" obj where 1 = 1 ");

		final List<Condition> conditionInfos;
		if (conditions == null) {
			conditionInfos = new ArrayList<Condition>();
		} else {
			conditionInfos = conditions;
		}

		// 设置查询条件
		this.appendConditions(hql, conditionInfos);

		try {
			Session session = this.getSession();
			Query query = session.createQuery(hql.toString());
			BaseDaoImpl.this.appendConditionValues(query, conditionInfos);
			return (Long) query.uniqueResult();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	@Override
	public Long countTotalAmount(List<Condition> conditions, Long saasId) { //SaaS
		StringBuilder hql = new StringBuilder()
				.append("select count(obj.id) from ")
				.append(BaseDaoImpl.this.getentityClass().getSimpleName())
				.append(" obj where 1 = 1 ")
				.append(" and saasId = " + saasId + " ");

		final List<Condition> conditionInfos;
		if (conditions == null) {
			conditionInfos = new ArrayList<Condition>();
		} else {
			conditionInfos = conditions;
		}

		// 设置查询条件
		this.appendConditions(hql, conditionInfos);

		try {
			Session session = this.getSession();
			Query query = session.createQuery(hql.toString());
			BaseDaoImpl.this.appendConditionValues(query, conditionInfos);
			return (Long) query.uniqueResult();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}
	
	protected Long countTotalAmountAsTree(List<Condition> conditions,
			TreeCondition treeCond) {
		StringBuilder hql = new StringBuilder()
				.append("select count(obj.id) from t_")
				.append(BaseDaoImpl.this.getentityClass().getSimpleName())
				.append(" obj where 1 = 1 ");

		final List<Condition> conditionInfos;
		if (conditions == null) {
			conditionInfos = new ArrayList<Condition>();
		} else {
			conditionInfos = conditions;
		}
		final boolean asTree = treeCond != null && treeCond.validate();
		// 设置查询条件
		this.appendConditions(hql, conditionInfos);

		// 如果是树形查询，添加树形查询特有的尾缀
		if (asTree) {
			this.appendTree(hql, treeCond);
		}

		try {
			Session session = this.getSession();
			Query query = session.createQuery(hql.toString());
			BaseDaoImpl.this.appendConditionValues(query, conditionInfos);
			return (Long) query.uniqueResult();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	protected Long countTotalAmountAsTree(List<Condition> conditions,
			TreeCondition treeCond, Long saasId) { //SaaS
		StringBuilder hql = new StringBuilder()
				.append("select count(obj.id) from t_")
				.append(BaseDaoImpl.this.getentityClass().getSimpleName())
				.append(" obj where 1 = 1 ")
				.append(" and saasId = " + saasId + " ");

		final List<Condition> conditionInfos;
		if (conditions == null) {
			conditionInfos = new ArrayList<Condition>();
		} else {
			conditionInfos = conditions;
		}
		final boolean asTree = treeCond != null && treeCond.validate();
		// 设置查询条件
		this.appendConditions(hql, conditionInfos);

		// 如果是树形查询，添加树形查询特有的尾缀
		if (asTree) {
			this.appendTree(hql, treeCond);
		}

		try {
			Session session = this.getSession();
			Query query = session.createQuery(hql.toString());
			BaseDaoImpl.this.appendConditionValues(query, conditionInfos);
			return (Long) query.uniqueResult();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}
	
	@Override
	public Double sumByAttr(String attr, List<Condition> conditions) {
		StringBuilder hql = new StringBuilder()
				.append("select sum(" + attr + ") from ")
				.append(BaseDaoImpl.this.getentityClass().getSimpleName())
				.append(" obj where 1 = 1 ");

		final List<Condition> conditionInfos;
		if (conditions == null) {
			conditionInfos = new ArrayList<Condition>();
		} else {
			conditionInfos = conditions;
		}

		// 设置查询条件
		this.appendConditions(hql, conditionInfos);

		try {
			Session session = this.getSession();
			Query query = session.createQuery(hql.toString());
			BaseDaoImpl.this.appendConditionValues(query, conditionInfos);
			return (Double) query.uniqueResult();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}
	
	@Override
	public Double sumByAttr(String attr, List<Condition> conditions, Long saasId) { //SaaS
		StringBuilder hql = new StringBuilder()
				.append("select sum(" + attr + ") from ")
				.append(BaseDaoImpl.this.getentityClass().getSimpleName())
				.append(" obj where 1 = 1 ")
				.append(" and saasId = " + saasId + " ");

		final List<Condition> conditionInfos;
		if (conditions == null) {
			conditionInfos = new ArrayList<Condition>();
		} else {
			conditionInfos = conditions;
		}

		// 设置查询条件
		this.appendConditions(hql, conditionInfos);

		try {
			Session session = this.getSession();
			Query query = session.createQuery(hql.toString());
			BaseDaoImpl.this.appendConditionValues(query, conditionInfos);
			return (Double) query.uniqueResult();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T findById(Long id) {
		Session session = this.getSession();
		return (T) session.get(this.getentityClass(), id);
	}
	
	@SuppressWarnings("unchecked")
    public T findByName(String name) {
        final StringBuilder hql = new StringBuilder();
        try {
            hql.append(" from ").append(entityClass.getSimpleName())
                    .append(" where 1 = 1 ");
            hql.append(" and name = :name ");
            Session session = this.getSession();
            Query query = session.createQuery(hql.toString());
            query.setParameter("name", name);
            return (T) query.list().get(0);
        } catch (Exception e) {
        	System.out.println(e.toString());
        }
        return null;
    }
	
	@SuppressWarnings("unchecked")
    public T findByName(String name, Long saasId) { //SaaS
        final StringBuilder hql = new StringBuilder();
        try {
            hql.append(" from ").append(entityClass.getSimpleName())
                    .append(" where 1 = 1 ")
                    .append(" and saasId = " + saasId + " ");
            hql.append(" and name = :name ");
            Session session = this.getSession();
            Query query = session.createQuery(hql.toString());
            query.setParameter("name", name);
            return (T) query.list().get(0);
        } catch (Exception e) {
        	System.out.println(e.toString());
        }
        return null;
    }
	
	@SuppressWarnings("unchecked")
    public List<T> listByName(String name) {
        final StringBuilder hql = new StringBuilder();
        try {
            hql.append(" from ").append(entityClass.getSimpleName())
                    .append(" where 1 = 1 ");
            hql.append(" and name = :name ");
            Session session = this.getSession();
            Query query = session.createQuery(hql.toString());
            query.setParameter("name", name);
            return (List<T>) query.list();
        } catch (Exception e) {
        	System.out.println(e.toString());
        }
        return null;
    }
	
	@SuppressWarnings("unchecked")
    public List<T> listByName(String name, Long saasId) { //SaaS
        final StringBuilder hql = new StringBuilder();
        try {
            hql.append(" from ").append(entityClass.getSimpleName())
                    .append(" where 1 = 1 ")
                    .append(" and saasId = " + saasId + " ");
            hql.append(" and name = :name ");
            Session session = this.getSession();
            Query query = session.createQuery(hql.toString());
            query.setParameter("name", name);
            return (List<T>) query.list();
        } catch (Exception e) {
        	System.out.println(e.toString());
        }
        return null;
    }
	
	public T save(T entity) {
		Session session = this.getSession();
		session.save(entity);
		return entity;
	}

	public List<T> saveAll(final List<T> entities) {
		try {
			Session session = this.getSession();
			T entity = null;
			for (int i = 0; i < entities.size(); i++) {
				entity = entities.get(i);
				session.save(entity);
				if (i % UpdateBatchSize == 0) {
					session.flush();
					session.clear();
				}
			}
			session.flush();
			session.clear();
			return entities;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public Collection<T> saveAll(final Collection<T> entities) {
		try {
			Session session = this.getSession();
			T entity = null;
			Iterator<T> iter = entities.iterator();
			int i = 0;
			while (iter.hasNext()) {
				entity = iter.next();
				session.save(entity);
				i++;
				if (i % UpdateBatchSize == 0) {
					session.flush();
					session.clear();
				}
			}
			session.flush();
			session.clear();
			return entities;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public T update(T entity) {
		Session session = this.getSession();
		session.update(entity);
		return entity;
	}

	public List<T> updateAll(final List<T> entities) {
		try {
			Session session = this.getSession();
			T entity = null;
			for (int i = 0; i < entities.size(); i++) {
				entity = entities.get(i);
				session.update(entity);
				if (i % UpdateBatchSize == 0) {
					session.flush();
					session.clear();
				}
			}
			session.flush();
			session.clear();
			return entities;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public Collection<T> updateAll(final Collection<T> entities) {
		try {
			Session session = this.getSession();
			T entity = null;
			Iterator<T> iter = entities.iterator();
			int i = 0;
			while (iter.hasNext()) {
				entity = iter.next();
				session.update(entity);
				i++;
				if (i % UpdateBatchSize == 0) {
					session.flush();
					session.clear();
				}
			}
			session.flush();
			session.clear();
			return entities;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public T saveOrUpdate(T entity) {
		Session session = this.getSession();
		session.saveOrUpdate(entity);
		return entity;
	}

	public List<T> saveOrUpdateAll(final List<T> entities) {
		try {
			Session session = this.getSession();
			T entity = null;
			for (int i = 0; i < entities.size(); i++) {
				entity = entities.get(i);
				session.saveOrUpdate(entity);
				if (i % UpdateBatchSize == 0) {
					session.flush();
					session.clear();
				}
			}
			session.flush();
			session.clear();
			return entities;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	public Collection<T> saveOrUpdateAll(final Collection<T> entities) {
		try {
			Session session = this.getSession();
			T entity = null;
			Iterator<T> iter = entities.iterator();
			int i = 0;
			while (iter.hasNext()) {
				entity = iter.next();
				session.saveOrUpdate(entity);
				i++;
				if (i % UpdateBatchSize == 0) {
					session.flush();
					session.clear();
				}
			}
			session.flush();
			session.clear();
			return entities;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	@Override
	public T merge(T entity) {
		Session session = this.getSession();
		session.merge(entity);
		return entity;
	}

	public void delete(T entity) {
		Session session = this.getSession();
		session.delete(entity);
	}

	public void delete(final Long entityId) {
		final String hql = "delete from " + this.getSimpleName()
				+ " where id = :entityId";
		try {
			Session session = this.getSession();
			Query query = session.createQuery(hql.toString());
			query.setParameter("entityId", entityId);
			query.uniqueResult();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void deleteStatusById(final Long entityId) {
		final String hql = "UPDATE " + this.getSimpleName()
				+ " SET status = 0 where id = :entityId ";
		try {
			Session session = this.getSession();
			Query query = session.createQuery(hql.toString());
			query.setParameter("entityId", entityId);
			query.uniqueResult();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void refresh(T entity) {
		Session session = this.getSession();
		session.refresh(entity);
	}

	public void flush() {
		Session session = this.getSession();
		session.flush();
	}

	/**
	 * 查询，并指定起始的纪录和最大的查询结果集大小以及需要排序的属性和排序的方向。
	 * 
	 * @param entityClass
	 *            要被查询的对象对应的<code>Class</code>。
	 * @param startPos
	 *            起始纪录的序号。
	 * @param amount
	 *            最大的查询结果集大小。
	 * @param conditions
	 *            一个以属性名为key，以属性值为value的<code>Map</code>
	 * @param sortableProperty
	 *            需要排序的属性。
	 * @param desc
	 *            排序的方向。
	 * @return 结果集。
	 */
	@SuppressWarnings("unchecked")
	protected List<T> listAndSort(Class<T> entityClass, Pagination pagination,
			List<Condition> conditions) {
		final Pagination pageInfo;
		if (pagination == null) {
			pageInfo = new Pagination(false, false);
		} else {
			pageInfo = pagination;
		}
		final List<Condition> conditionInfos;
		if (conditions == null) {
			conditionInfos = new ArrayList<Condition>();
		} else {
			conditionInfos = conditions;
		}

		StringBuilder hql = new StringBuilder().append("from ")
				.append(entityClass.getSimpleName())
				.append(" obj where 1 = 1 ");

		// 设置查询条件
		this.appendConditions(hql, conditionInfos);

		// 排序
		this.appendPagingCondition(hql, pageInfo);

		// 分页
		try {
			Session session = this.getSession();
			Query query = session.createQuery(hql.toString());
			BaseDaoImpl.this.appendConditionValues(query, conditionInfos);
			BaseDaoImpl.this.appendPagingValue(query, pageInfo);
			return (List<T>) query.list();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> listAndSort(Class<T> entityClass, Pagination pagination,
			List<Condition> conditions, Long saasId) { //SaaS
		final Pagination pageInfo;
		if (pagination == null) {
			pageInfo = new Pagination(false, false);
		} else {
			pageInfo = pagination;
		}
		final List<Condition> conditionInfos;
		if (conditions == null) {
			conditionInfos = new ArrayList<Condition>();
		} else {
			conditionInfos = conditions;
		}

		StringBuilder hql = new StringBuilder().append("from ")
				.append(entityClass.getSimpleName())
				.append(" obj where 1 = 1 ")
				.append(" and saasId = " + saasId + " ");

		// 设置查询条件
		this.appendConditions(hql, conditionInfos);

		// 排序
		this.appendPagingCondition(hql, pageInfo);

		// 分页
		try {
			Session session = this.getSession();
			Query query = session.createQuery(hql.toString());
			BaseDaoImpl.this.appendConditionValues(query, conditionInfos);
			BaseDaoImpl.this.appendPagingValue(query, pageInfo);
			return (List<T>) query.list();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	/**
	 * 查询，并指定起始的纪录和最大的查询结果集大小以及需要排序的属性和排序的方向。
	 * 
	 * @param entityClass
	 *            要被查询的对象对应的<code>Class</code>。
	 * @param startPos
	 *            起始纪录的序号。
	 * @param amount
	 *            最大的查询结果集大小。
	 * @param conditions
	 *            一个以属性名为key，以属性值为value的<code>Map</code>
	 * @param sortableProperty
	 *            需要排序的属性。
	 * @param desc
	 *            排序的方向。
	 * @return 结果集。
	 */
	@SuppressWarnings("unchecked")
	protected List<T> listAndSortAsTree(Class<T> entityClass,
			Pagination pagination, List<Condition> conditions,
			TreeCondition treeCond) {
		final Pagination pageInfo;
		if (pagination == null) {
			pageInfo = new Pagination(false, false);
		} else {
			pageInfo = pagination;
		}
		final List<Condition> conditionInfos;
		if (conditions == null) {
			conditionInfos = new ArrayList<Condition>();
		} else {
			conditionInfos = conditions;
		}
		final boolean asTree = treeCond != null && treeCond.validate();

		StringBuilder sql = new StringBuilder().append("select obj.* from ")
				.append("t_" + entityClass.getSimpleName())
				.append(" obj where 1 = 1 ");

		// 设置查询条件
		this.appendConditions(sql, conditionInfos);

		// 如果是树形查询，添加树形查询特有的尾缀
		if (asTree) {
			this.appendTree(sql, treeCond);
		}

		// 排序
		this.appendPagingCondition(sql, pageInfo);

		// 分页
		try {
			Session session = this.getSession();
			Query query = session.createSQLQuery(sql.toString()).addEntity(
					BaseDaoImpl.this.entityClass);
			BaseDaoImpl.this.appendConditionValues(query, conditionInfos);
			BaseDaoImpl.this.appendPagingValue(query, pageInfo);
			return (List<T>) query.list();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	protected List<T> listAndSortAsTree(Class<T> entityClass,
			Pagination pagination, List<Condition> conditions,
			TreeCondition treeCond, Long saasId) { //SaaS
		final Pagination pageInfo;
		if (pagination == null) {
			pageInfo = new Pagination(false, false);
		} else {
			pageInfo = pagination;
		}
		final List<Condition> conditionInfos;
		if (conditions == null) {
			conditionInfos = new ArrayList<Condition>();
		} else {
			conditionInfos = conditions;
		}
		final boolean asTree = treeCond != null && treeCond.validate();

		StringBuilder sql = new StringBuilder().append("select obj.* from ")
				.append("t_" + entityClass.getSimpleName())
				.append(" obj where 1 = 1 ")
				.append(" and saasId = " + saasId + " ");

		// 设置查询条件
		this.appendConditions(sql, conditionInfos);

		// 如果是树形查询，添加树形查询特有的尾缀
		if (asTree) {
			this.appendTree(sql, treeCond);
		}

		// 排序
		this.appendPagingCondition(sql, pageInfo);

		// 分页
		try {
			Session session = this.getSession();
			Query query = session.createSQLQuery(sql.toString()).addEntity(
					BaseDaoImpl.this.entityClass);
			BaseDaoImpl.this.appendConditionValues(query, conditionInfos);
			BaseDaoImpl.this.appendPagingValue(query, pageInfo);
			return (List<T>) query.list();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}
	
	protected String generateParamName(Condition condition) {
		String paramName = null;
		if (StringUtils.isBlank(condition.getParamName())) {
			String property = condition.getProperty();
			if (property.contains(".")) {
				paramName = property.substring(property.lastIndexOf(".") + 1,
						property.length()) + "Property";
			} else {
				paramName = property;
			}
		} else {
			paramName = condition.getParamName();
		}

		return paramName;
	}

	protected void appendConditions(StringBuilder hql,
			List<Condition> conditions) {
		if (conditions == null || conditions.isEmpty()) {
			return;
		}

		for (Condition condition : conditions) {
			this.appendCondition(hql, condition);
		}
	}

	protected void appendCondition(StringBuilder hql, Condition condition) {
		if ("specialField".equals(condition.getSignal())) {
			hql.append(condition.getValue());
		} else {
			if (condition.getIsDefaultAlias()) {
				appendCondition(hql, condition, "obj");
			} else {
				appendCondition(hql, condition, condition.getAlias());
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected void appendCondition(StringBuilder hql, Condition condition,
			String objAliasName) {
		if (!"noAnd".equals(condition.getType())) {
			hql.append(" and ");
		}
		if (condition.getSignal().trim().equalsIgnoreCase("patternIn")) {
			List<String> patterns = (List<String>) condition.getValue();
			hql.append(" ( ");
			for (int i = 0; i < patterns.size(); i++) {
				hql.append(objAliasName)
						.append(".")
						.append(condition.getProperty() + " like :"
								+ generateParamName(condition) + i);
				if (i < patterns.size() - 1) {
					hql.append(" or ");
				}
			}
			hql.append(" ) ");
		} else {
			hql.append(objAliasName).append(".")
					.append(condition.getProperty()).append(" ")
					.append(condition.getSignal());
			if (condition.getSignal().trim().equalsIgnoreCase("in")
					|| condition.getSignal().trim().equalsIgnoreCase("not in")) {
				hql.append(" ( :").append(this.generateParamName(condition))
						.append(" ) ");
			} else if (condition.getSignal().trim().equalsIgnoreCase("is")
					|| condition.getSignal().trim().equalsIgnoreCase("is not")) {
				if (StringUtils.isBlank((String) condition.getValue())) {
					hql.append(" null ");
				} else if ("null".equalsIgnoreCase(((String) condition
						.getValue()).trim())) {
					hql.append(" null ");
				} else if ("empty".equalsIgnoreCase(((String) condition
						.getValue()).trim())) {
					hql.append(" empty ");
				}
			} else {
				if (!StringUtils.isBlank(condition.getMethodName())
						&& !StringUtils.isBlank(condition.getDateFormat())) {
					hql.append(" ").append(condition.getMethodName())
							.append("(:")
							.append(this.generateParamName(condition))
							.append(", '").append(condition.getDateFormat())
							.append("')");
				} else {
					hql.append(" :").append(this.generateParamName(condition))
							.append(" ");
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected void appendConditionValues(Query query, List<Condition> conditions) {
		if (conditions == null || conditions.isEmpty()) {
			return;
		}
		for (Condition condition : conditions) {
			if (condition.getSignal().trim().equalsIgnoreCase("in")
					|| condition.getSignal().trim().equalsIgnoreCase("not in")) {
				query.setParameterList(
						BaseDaoImpl.this.generateParamName(condition),
						(List<?>) condition.getValue());
			} else if (condition.getSignal().trim().equalsIgnoreCase("is")
					|| condition.getSignal().trim().equalsIgnoreCase("is not")
					|| condition.getSignal().trim()
							.equalsIgnoreCase("specialField")) {
				// 什么都不需要做;
			} else if (condition.getSignal().trim()
					.equalsIgnoreCase("patternIn")) {
				List<String> patterns = (List<String>) condition.getValue();
				for (int i = 0; i < patterns.size(); i++) {
					String value = patterns.get(i);
					query.setParameter(generateParamName(condition) + i, value);
				}
			} else {
				query.setParameter(
						BaseDaoImpl.this.generateParamName(condition),
						condition.getValue());
			}
		}
	}

	protected void appendPagingCondition(StringBuilder hql, Pagination paging) {
		if (paging == null || !paging.isNeedsSort()) {
			return;
		}
		if (paging.isNeedsSort()) {
			hql.append(" order by ").append(" obj.")
					.append(paging.getSortProperty()).append(" ");
			if (paging.isAsc()) {
				hql.append("asc");
			} else {
				hql.append("desc");
			}
		}
	}

	protected void appendPagingCondition(StringBuilder hql, Pagination paging,
			String entityName) {
		if (paging == null || !paging.isNeedsSort()) {
			return;
		}
		if (paging.isNeedsSort()) {
			hql.append(" order by ").append(entityName).append(".")
					.append(paging.getSortProperty()).append(" ");
			if (paging.isAsc()) {
				hql.append("asc");
			} else {
				hql.append("desc");
			}
		}
	}

	protected void appendPagingSortCondition(StringBuilder hql,
			Pagination paging, String entityName) {
		if (paging == null || !paging.isNeedsSort()) {
			return;
		}
		if (paging.getSortPropertyMap() != null
				&& paging.getSortPropertyMap().size() > 0) {
			StringBuffer sortHql = new StringBuffer();
			sortHql.append(" order by ");
			for (Map.Entry<String, Boolean> entry : paging.getSortPropertyMap()
					.entrySet()) {
				sortHql.append(entityName).append(".").append(entry.getKey())
						.append(" ");
				if (entry.getValue()) {
					sortHql.append("asc");
				} else {
					sortHql.append("desc");
				}
				sortHql.append(",");
			}
			hql.append(sortHql.substring(0, sortHql.length() - 1));
		} else {
			if (paging.isNeedsSort()) {
				hql.append(" order by ").append(entityName).append(".")
						.append(paging.getSortProperty()).append(" ");
				if (paging.isAsc()) {
					hql.append("asc");
				} else {
					hql.append("desc");
				}
			}
		}
	}

	protected void appendPagingSortCondition(StringBuilder hql,
			Pagination paging) {
		if (paging == null || !paging.isNeedsSort()) {
			return;
		}
		if (paging.getSortPropertyMap() != null
				&& paging.getSortPropertyMap().size() > 0) {
			StringBuffer sortHql = new StringBuffer();
			sortHql.append(" order by ");
			for (Map.Entry<String, Boolean> entry : paging.getSortPropertyMap()
					.entrySet()) {
				sortHql.append(" obj.").append(entry.getKey()).append(" ");
				if (entry.getValue()) {
					sortHql.append("asc");
				} else {
					sortHql.append("desc");
				}
				sortHql.append(",");
			}
			hql.append(sortHql.substring(0, sortHql.length() - 1));
		} else {
			if (paging.isNeedsSort()) {
				hql.append(" order by ").append(" obj.")
						.append(paging.getSortProperty()).append(" ");
				if (paging.isAsc()) {
					hql.append("asc");
				} else {
					hql.append("desc");
				}
			}
		}
	}

	protected void appendTree(StringBuilder hql, TreeCondition treeCond) {
		hql.append("connect by prior ").append("obj.")
				.append(treeCond.getLeftProp()).append(" = ").append("obj.")
				.append(treeCond.getRightProp()).append(" start with ")
				.append("obj.").append(treeCond.getStartProp()).append(" = ")
				.append(treeCond.getStartValue());
	}

	protected void appendPagingValue(Query query, Pagination paging) {
		if (paging == null || !paging.isNeedsPaginate()) {
			return;
		}
		if (paging.isNeedsPaginate()) {
			query.setFirstResult(paging.getStartPos());
			query.setMaxResults(paging.getAmount());
		}
	}

	/**
	 * 获取对象表名，需要字典服务的对象实现此方法。<br>
	 * 
	 * @return
	 */
	public String getTableName() {
		return null;
	}

	/**
	 * 辅助方法，用来转换condition 2012-11-20 上午09:25:52 mxl添加此方法
	 * 
	 * @param conditions
	 * @return
	 */
	protected List<Condition> getConInfos(List<Condition> conditions) {
		if (conditions == null) {
			conditions = new ArrayList<Condition>();
		}
		return conditions;
	}

	/**
	 * 辅助方法，用来拼接其他关联表的condition 2012-11-20 上午09:25:52 mxl添加此方法
	 * 
	 * @param conditions
	 * @return
	 */
	protected void appendOtherCondition(String tableName, StringBuilder hql,
			Condition condition) {
		if ("specialField".equals(condition.getSignal())) {
			hql.append(condition.getValue());
		} else {
			if ("noAnd".equals(condition.getType())) {
				hql.append(" ").append(tableName).append(".");
			} else {
				hql.append("and ").append(tableName).append(".");
			}
			hql.append(condition.getProperty()).append(" ")
					.append(condition.getSignal());
			if (condition.getSignal().trim().equalsIgnoreCase("in")
					|| condition.getSignal().trim().equalsIgnoreCase("not in")) {
				hql.append(" ( :").append(this.generateParamName(condition))
						.append(" ) ");
			} else if (condition.getSignal().trim().equalsIgnoreCase("is")
					|| condition.getSignal().trim().equalsIgnoreCase("is not")) {
				if (StringUtils.isBlank((String) condition.getValue())) {
					hql.append(" null ");
				} else if ("null".equalsIgnoreCase(((String) condition
						.getValue()).trim())) {
					hql.append(" null ");
				} else if ("empty".equalsIgnoreCase(((String) condition
						.getValue()).trim())) {
					hql.append(" empty ");
				}
			} else {
				if (!StringUtils.isBlank(condition.getMethodName())
						&& !StringUtils.isBlank(condition.getDateFormat())) {
					hql.append(" ").append(condition.getMethodName())
							.append("(:")
							.append(this.generateParamName(condition))
							.append(", '").append(condition.getDateFormat())
							.append("')");
				} else {
					hql.append(" :").append(this.generateParamName(condition))
							.append(" ");
				}
			}
		}
	}
}
