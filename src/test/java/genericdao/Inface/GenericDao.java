package genericdao.Inface;

import java.io.Serializable;

/**
 * The basic IGenericDao interface with CRUD methods
 * Finders are added with interface inheritance and AOP introductions for concrete implementations
 * <p>
 * Extended interfaces may declare methods starting with find... list... iterate... or scroll...
 * They will execute a preconfigured query that is looked up based on the rest of the method name
 */
public interface GenericDao<T, PK extends Serializable> {

    PK create(T newInstance);

   // T read(PK id);

    void update(T transientObject);

    void delete(T persistentObject);

}
