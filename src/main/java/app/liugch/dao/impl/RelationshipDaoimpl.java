package app.liugch.dao.impl;

import app.liugch.dao.Inface.IRelationshipDao;
import app.liugch.dao.base.GenericDaoImpl;
import app.liugch.model.Relationship;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository(value = "relationshipDao")
public class RelationshipDaoimpl extends GenericDaoImpl<Relationship, Long> implements IRelationshipDao<Relationship> {

    @Override
    public List<Relationship> getListByMasterId(Long id) {
        String hql ="select * FROM relationship where master_id=:id";
        Query query = getSession().createSQLQuery(hql).addEntity(Relationship.class).setParameter("id", id);
        if (query!=null){
            List<Relationship> list = (List<Relationship>) query.list();
            return list;
        }
        return null;
    }

    public List<Relationship> getListByForlowedId(Long id) {
        String hql ="select * FROM relationship where forlowed_id=:id";
        Query query = getSession().createSQLQuery(hql).addEntity(Relationship.class).setParameter("id", id);
        if(query!=null){
            List<Relationship> list = (List<Relationship>) query.list();
            return list;
        }
        return null;
    }
}
