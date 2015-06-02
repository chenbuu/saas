/**
 * 
 */
package com.sep.daoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sep.dao.RoleDao;
import com.sep.model.Role;

/**
 * 
 * @author ChenTao
 * @date 2014年10月8日下午4:28:34
 */
@Transactional
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(RoleDao.class);

	public RoleDaoImpl() {
		super(Role.class);
	}

}
