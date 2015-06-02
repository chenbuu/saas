/**
 * 
 */
package com.sep.util;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 
 * @author ChenTao
 * @date 2014年10月12日下午2:44:41
 */
public class AbstractDao {
	@Resource(name = "sessionFactory")
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

}
