package app.liugch.dao.base;

import app.liugch.util.FinalStatic;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


public abstract class GenericDaoImpl<T, PK extends Serializable> implements IGenericDao<T, PK> {

    @Resource
    private SessionFactory sessionFactory;

    private Class<T> entityClazz = null;

    public GenericDaoImpl() {
        System.out.println(this.getClass());
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.entityClazz = (Class<T>) type.getActualTypeArguments()[0];
    }

    @Override
    public PK save(T o) {
        return (PK) getSession().save(o);
    }

    @Override
    public void update(T o) {
        getSession().update(o);
    }

    @Override
    public void delete(T o) {
        getSession().delete(o);
    }

    @Override
    public void deleteByid(PK id) {
        getSession().update(get(id));
    }


    @Override
    public T get(PK id) {
        T t = getSession().get(entityClazz, id);
        Hibernate.initialize(t);
        return t;
    }

    @Override
    public int count() {
        String hql = "select count(*) from " + entityClazz.getSimpleName();
        int count = (int) getSession().createQuery(hql).uniqueResult();
        return count;
    }

    @Override
    public List<T> getList() {
        Session session = getSession();
        String hql = "from "+entityClazz.getSimpleName()+"where 1=1";
        List<T> list = session.createQuery(hql).list();
        session.flush();
        return list;
    }

    @Override
    public List<T> getListPage(int currentPage) {
        Session session = getSession();

        int page = FinalStatic.pageSize;

        List<T> list = session.createQuery("from "+entityClazz.getSimpleName()).setFirstResult((currentPage - 1) * page).setMaxResults(page).list();
        Hibernate.initialize(list);
        session.flush();
        return list;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
