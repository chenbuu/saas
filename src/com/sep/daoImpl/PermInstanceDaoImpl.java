/**
 * 
 */
package com.sep.daoImpl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sep.dao.PermInstanceDao;
import com.sep.model.PermInstance;

/**
 * 
 * @author ChenTao
 * @date 2014年10月8日下午4:28:34
 */
@Transactional
@Repository("permInstanceDao")
public class PermInstanceDaoImpl extends BaseDaoImpl<PermInstance> implements PermInstanceDao {
	private static final Log log = LogFactory.getLog(PermInstanceDao.class);

	public PermInstanceDaoImpl() {
		super(PermInstance.class);
	}

	/**
	 * 通过参数roleId查询权限
	 * 
	 * @author ChenTao
	 * @date 2014年12月18日下午9:48:04
	 */
	@SuppressWarnings("unchecked")
	public List<Long> findByRoleId(Long roleId) {
		final StringBuilder hql = new StringBuilder();
		try {
			hql.append("select p.permissionId from PermInstance p ").append(" where 1 = 1 ");
			hql.append(" and p.roleId = :roleId ");
			Session session = this.getSession();
			Query query = session.createQuery(hql.toString());
			query.setParameter("roleId", roleId);
			return (List<Long>) query.list();
		} catch (Exception e) {
			log.debug(e);
		}
		return null;
	}

}
