package app.liugch.dao.impl;

import app.liugch.dao.Inface.IPostsDao;
import app.liugch.dao.base.GenericDaoImpl;
import app.liugch.model.Posts;
import app.liugch.util.FinalStatic;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/2/19.
 */
@Repository(value = "postsDao")
public class PostsDaoImpl extends GenericDaoImpl<Posts, Long> implements IPostsDao<Posts> {


    @Override
    public List<Posts> getByMasterId(Long id) {
        String hql = "FROM Posts where user.id=:id";
        Query query = getSession().createQuery(hql).setParameter("id", id);
        if (query != null) {
            List<Posts> list = query.list();
            Hibernate.initialize(list);
            return list;
        }
        return null;
    }

    @Override
    public List<Posts> getListPageOrderbyTime(int currentPage) {
        Session session = getSession();
        int page = FinalStatic.pageSize;
        List<Posts> list = session.createQuery("from Posts order by crateTime desc ").setFirstResult((currentPage - 1) * page).setMaxResults(page).list();
        session.flush();

        return list;
    }


}
