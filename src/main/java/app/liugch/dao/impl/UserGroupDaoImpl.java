package app.liugch.dao.impl;

import app.liugch.dao.Inface.IUserGroupDao;
import app.liugch.dao.base.GenericDaoImpl;
import app.liugch.model.UserGroup;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/2/24.
 */
@Repository(value = "userGroupDao")
public class UserGroupDaoImpl extends GenericDaoImpl<UserGroup,Long> implements IUserGroupDao {

}
