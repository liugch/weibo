package app.liugch.services;

import app.liugch.dao.impl.RelationshipDaoimpl;
import app.liugch.model.Relationship;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/2/7.
 */
@Service(value = "relationshipService")
public class RelationshipServiceImpl {
    @Resource
    private RelationshipDaoimpl relationshipDao;

    @Transactional
    public List<Relationship> getListByMasterId(int id){
        return relationshipDao.getListByMasterId(new Long(id));
    }
    @Transactional
    public List<Relationship> getListByForlowedId(int id){
        return relationshipDao.getListByForlowedId(new Long(id));
    }




}
