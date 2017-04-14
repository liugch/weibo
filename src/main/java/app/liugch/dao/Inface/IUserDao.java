package app.liugch.dao.Inface;

/**
 * Created by Administrator on 2017/2/19.
 */
public interface IUserDao<T> {

    public boolean isExit(T user);

    public T login(String mail, String pwd);
    public T getUserByEamil(String eamil);
}
