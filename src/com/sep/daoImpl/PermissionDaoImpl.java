/**
 * 
 */
package com.sep.daoImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sep.dao.PermissionDao;
import com.sep.model.Permission;

/**
 * 
 * @author ChenTao
 * @date 2014年10月8日下午4:28:34
 */
@Transactional
@Repository("permissionDao")
public class PermissionDaoImpl extends BaseDaoImpl<Permission> implements PermissionDao {
	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(PermissionDao.class);

	public PermissionDaoImpl() {
		super(Permission.class);
	}

}
