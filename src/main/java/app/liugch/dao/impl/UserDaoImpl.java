package app.liugch.dao.impl;

import app.liugch.dao.Inface.IUserDao;
import app.liugch.dao.base.GenericDaoImpl;
import app.liugch.model.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/2/19.
 */
@Repository(value = "userDao")
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements IUserDao<User> {

    @Override
    public boolean isExit(User user) {
        Session session = getSession();
        String hql = "from User where name=:name and mail=:mail";
        User u = (User) session.createQuery(hql)
                .setParameter("name", user.getName())
                .setParameter("mail", user.getMail()).uniqueResult();

        return u != null;
    }

    @Override
    public User login(String mail, String pwd) {
        Session session = getSession();
        User user = (User) session.createQuery("from User where mail =:mail and pwd =:pwd").setParameter("mail", mail).setParameter("pwd", pwd).uniqueResult();
        return user;
    }

    @Override
    public User getUserByEamil(String eamil){
        Session session = getSession();
        User user = (User) session.createQuery("from User where mail =:mail").setParameter("mail", eamil).uniqueResult();
        return user;
    }



}
