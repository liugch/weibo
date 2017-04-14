package genericdao.impl;

import app.liugch.model.User;
import genericdao.Inface.UserDao;

import java.util.List;

/**
 * Created by Administrator on 2017/2/19.
 */
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao<User> {


    @Override
    public List<User> getAll() {
        return null;
    }
}
