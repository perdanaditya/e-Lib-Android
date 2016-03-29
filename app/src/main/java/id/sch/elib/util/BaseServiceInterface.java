package id.sch.elib.util;

/**
 * Created by rizky.aditya on 28/03/2016.
 */
public interface BaseServiceInterface {

    public Object listAll();
    public Object get(long id);
    public Object save(Object obj);
    public Object update(Object obj);
    public Object delete(Object obj);
    public Object search(Object obj);

}
