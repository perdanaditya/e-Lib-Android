package id.sch.elib.controller;

import java.sql.Timestamp;
import java.util.Date;

import id.sch.elib.model.User;
import id.sch.elib.service.UserService;
import id.sch.elib.util.BaseControllerInterface;
import id.sch.elib.util.DataLibrary;
import id.sch.elib.util.Message;

/**
 * Created by rizky.aditya on 27/04/2016.
 */
public class UserController implements BaseControllerInterface{

    private User user;
    private boolean editMode;
    private UserService userService = new UserService();
    private Timestamp now = new Timestamp(new Date().getTime());

    //GETTER-SETTER
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Timestamp getNow() {
        return now;
    }

    public void setNow(Timestamp now) {
        this.now = now;
    }
    //END OF GETTER-SETTER

    //OVERRIDING METHOD
    @Override
    public Object search(Object completeList, String param, String column) {
        return null;
    }

    @Override
    public Object fetchData() {
        return null;
    }

    @Override
    public String save() {
        return null;
    }
    //END OF OVERRIDING METHOD

    //CUSTOM METHOD
    public boolean login(String username, String password){
        user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user = (User) userService.login(user);
        if (user!=null) {
            DataLibrary.getInstance().setUser(user);
            user = new User();
            return true;
        }else{
            System.out.println("LOGIN MESSAGE: "+DataLibrary.getInstance().getMessage());
            return false;
        }
    }
    //END OF CUSTOM METHOD
}
