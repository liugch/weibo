package app.liugch.dao.base;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T, PK extends Serializable> {
    //保存
    PK save(T newInstance);

    // 根据Id 获取
    T get(PK id);

    // 更新
    void update(T transientObject);

    //删除
    void delete(T persistentObject);

    // 根据主键删除
    void deleteByid(PK id);

    // 获取数量
    int count();

    // 获取所有
    List<T> getList();

    // 分页获取 所有
    List<T> getListPage(int currentPage);
}
