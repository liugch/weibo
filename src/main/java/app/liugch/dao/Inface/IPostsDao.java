package app.liugch.dao.Inface;

import java.util.List;

/**
 * Created by Administrator on 2017/2/19.
 */
public interface IPostsDao<T> {

    public List<T> getByMasterId(Long id);


    public List<T> getListPageOrderbyTime(int currentPage);

}
