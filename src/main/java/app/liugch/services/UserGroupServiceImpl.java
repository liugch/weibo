package app.liugch.services;

import app.liugch.dao.impl.UserGroupDaoImpl;
import app.liugch.model.UserGroup;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/2/24.
 */
@Service
public class UserGroupServiceImpl {
    @Resource
    private UserGroupDaoImpl userGroupDao;

    public List<UserGroup> getAlllist() throws ServiceException{
        List<UserGroup> list = userGroupDao.getList();
        if(list!=null){
            return list;
        }else{
            throw new ServiceException("UserGroupServiceImpl: 获取所有分组时 异常!");
        }
    }

    @Transactional
    public void addGroup(UserGroup userGroup){
        userGroupDao.save(userGroup);
    }







}
