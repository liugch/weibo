package app.liugch.services;

import app.liugch.dao.impl.EmailDaoImpl;
import app.liugch.dao.impl.UserDaoImpl;
import app.liugch.model.User;
import app.liugch.util.MD5Util;
import org.hibernate.Hibernate;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */
@Service(value = "userServiceImpl")
@Transactional
public class UserServiceImpl {
    @Resource
    private UserDaoImpl userDao;

    @Resource
    private EmailDaoImpl emailDao;

    @Transactional
    public void processRegist(User u) throws ServiceException {
        boolean isexit = userDao.isExit(u);
        if (isexit) {
            throw new ServiceException("注册的用户已经存在了!");
        } else {
            u.setToux("https://secure.gravatar.com/avatar/81464a18af5480e64e56989887d118e8?s=50");
            u.setCrateTime(new Date());
            u.setStatus(0);

            String validateCode = MD5Util.encode2hex(u.getMail());
            u.setValidateCode(validateCode);

            //保存到数据库中
            userDao.save(u);

            //邮件内容
            StringBuffer sb = new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
            sb.append("<a href=\"http://localhost:8080/upregist?action=activate&email=");
            sb.append(u.getMail());
            sb.append("&validateCode=");
            sb.append(validateCode);
            sb.append("\">http://localhost:8080/upregist?action=activate&email=");
            sb.append(u.getMail());
            sb.append("&validateCode=");
            sb.append(validateCode);
            sb.append("\"</a>");


/*


            StringBuffer sb=new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
            sb.append("<a href=\"http://"+ip+":8080/user/activate?email=");
            sb.append(postUser.getEmail());
            sb.append("&validateCode=");
            sb.append(postUser.getCdkey());
            sb.append("\">http://"+ip+":8080/user/activate?email=");
            sb.append(postUser.getEmail());
            sb.append("&validateCode=");
            sb.append(postUser.getCdkey());
            sb.append("</a>");
*/


            //发送邮件
            emailDao.sendMail(u.getMail(), sb.toString());
        }

    }


    @Transactional
    public void activateRegist(String eamil, String validateCode) throws ServiceException {
        User user = userDao.getUserByEamil(eamil);
        if (user != null) {
            if (user.getStatus() == 0) {
                Date now = new Date(System.currentTimeMillis());
                Date get = user.getCrateTime();
                //得到天数
                int count = (int) ((now.getTime() - get.getTime()) / (1000 * 3600 * 24));
                if (get.before(now) && count < 2) {
                    if (user.getValidateCode().equals(validateCode)) {
                        user.setStatus(1);
                        userDao.update(user);
                    } else {
                        throw new ServiceException("激活码不正确！");
                    }
                } else {
                    throw new ServiceException("激活码已过期！");
                }
            } else {
                throw new ServiceException("邮箱已激活，请登录！");
            }

        } else {
            throw new ServiceException("该邮箱未注册（邮箱地址不存在）！");
        }
    }


    @Transactional
    public User login(String mail, String pwd) {
        User user = userDao.login(mail, pwd);
        Hibernate.initialize(user.getRelationships());
        Hibernate.initialize(user.getRelationships2());
        Hibernate.initialize(user.getPostss());
        return user;
    }

    public List<User> getListPage(int currentPage) {
        if (currentPage <= 0) {
            currentPage = 0;
        }
        List<User> users = userDao.getListPage(currentPage);
        return users;
    }

    public User getUserByid(int id) {
        User user = userDao.get(new Long(id));
        return user;
    }

    public User getUserByEamil(String eamil) {
        User user = userDao.getUserByEamil(eamil);
        Hibernate.initialize(user);
        Hibernate.initialize(user.getRelationships());
        Hibernate.initialize(user.getRelationships2());
        Hibernate.initialize(user.getPostss());
        return user;
    }

}
