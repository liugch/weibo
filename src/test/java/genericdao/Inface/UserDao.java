package genericdao.Inface;

import java.util.List;

/**
 * Created by Administrator on 2017/2/19.
 */
public interface UserDao<T> {
    public List<T> getAll();
}
