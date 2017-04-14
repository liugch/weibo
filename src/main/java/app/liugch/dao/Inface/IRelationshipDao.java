package app.liugch.dao.Inface;

import java.util.List;

/**
 * Created by Administrator on 2017/2/19.
 */
public interface IRelationshipDao<T> {
    public List<T> getListByMasterId(Long id);

}
