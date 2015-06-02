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

import com.sep.dao.DicDao;
import com.sep.model.Dic;

/**
 * 
 * @author ChenTao
 * @date 2014年10月8日下午4:28:34
 */
@Transactional
@Repository("dicDao")
public class DicDaoImpl extends BaseDaoImpl<Dic> implements DicDao {
	private static final Log log = LogFactory.getLog(DicDao.class);

	public DicDaoImpl() {
		super(Dic.class);
	}

	@SuppressWarnings("unchecked")
	public List<Dic> findDic(String obj, String attr) {
		final StringBuilder hql = new StringBuilder();
		try {
			hql.append(" from Dic ").append(" where 1 = 1 ");
			hql.append(" and obj = :obj ");
			hql.append(" and attr = :attr ");
			Session session = this.getSession();
			Query query = session.createQuery(hql.toString());
			query.setParameter("obj", obj);
			query.setParameter("attr", attr);
			return (List<Dic>) query.list();
		} catch (Exception e) {
			log.debug(e);
		}
		return null;
	}

}
