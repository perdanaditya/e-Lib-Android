package id.sch.elib.util;

import id.sch.elib.model.Peminjaman;
import id.sch.elib.model.User;

/**
 * Created by rizky.aditya on 27/04/2016.
 */
public class DataLibrary {

    private static User user;
    private static Peminjaman peminjaman;
    private String message;

    private static DataLibrary dataLibrary;

    private DataLibrary() {
    }

    public static DataLibrary getInstance(){
        if (dataLibrary == null) {
            dataLibrary = new DataLibrary();
        }
        return dataLibrary;
    }

    //GETTER-SETTER

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        DataLibrary.user = user;
    }

    public static Peminjaman getPeminjaman() {
        return peminjaman;
    }

    public static void setPeminjaman(Peminjaman peminjaman) {
        DataLibrary.peminjaman = peminjaman;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
//END OF GETTER-SETTER

    //OVERRIDE METHOD

    //END OF OVERRIDE METHOD

    //CUSTOM METHOD

    //END OF CUSTOM METHOD
}
