package genericdao.impl;

import genericdao.Inface.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Hibernate implementation of IGenericDao
 * A typesafe implementation of CRUD and finder methods based on Hibernate and Spring AOP
 * The finders are implemented through the executeFinder method. Normally called by the FinderIntroductionInterceptor
 */
@Repository(value = "gennericDao")
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

    @Resource
    private SessionFactory sessionFactory;


    @Override
    public void update(T o) {
        getSession().update(o);
    }

    @Override
    public void delete(T o) {
        getSession().delete(o);
    }

    @Override
    public PK create(T o) {
        return (PK) getSession().save(o);
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
