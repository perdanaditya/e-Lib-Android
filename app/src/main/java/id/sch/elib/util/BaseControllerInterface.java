package id.sch.elib.util;

/**
 * Created by rizky.aditya on 28/03/2016.
 */
public interface BaseControllerInterface {

    public Object search(Object completeList, String param, String column);

    public Object fetchData(Object target, boolean init);

    /**
     * Action when user save the SAA
     * @return
     */
    public String save();
}
