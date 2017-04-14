package app.liugch.services;

import app.liugch.dao.impl.PostsDaoImpl;
import app.liugch.model.Posts;
import org.hibernate.Hibernate;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */
@Service(value = "postsService")
@Transactional
public class PostsServiceImpl {
    @Resource
    private PostsDaoImpl postsDao;

    public List<Posts> getByMasterId(int id) {
        List<Posts> list = postsDao.getByMasterId(new Long(id));
        Hibernate.initialize(list);
        return list;
    }

    //保存微博
    public void save(Posts posts){
        postsDao.save(posts);
    }

    public List<Posts> getListPage(int currentPage) throws ServiceException{
        if (currentPage <= 0) {
            currentPage = 0;
        }
        List<Posts> list = postsDao.getListPage(currentPage);
        if(list==null){
            throw  new ServiceException("PostsServiceImpl: 分页获取 所有的 微博异常");
        }
        return list;
    }


    public List<Posts> getListPageOrderbyTime(int currentPage) throws ServiceException{
        if (currentPage <= 0) {
            currentPage = 0;
        }
        List<Posts> list = postsDao.getListPageOrderbyTime(currentPage);
        Hibernate.initialize(list);
        if(list==null){
            throw  new ServiceException("PostsServiceImpl: 分页获取 所有的 微博异常");
        }
        return list;
    }

}
