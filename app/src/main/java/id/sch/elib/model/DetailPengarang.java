package id.sch.elib.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by rizky.aditya on 28/03/2016.
 */
public class DetailPengarang implements Serializable {

    private long id;
    private Pengarang pengarang;
    private Buku buku;
    private boolean newPengarang;
    private Boolean active;
    private String userInput;
    private Timestamp inputTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pengarang getPengarang() {
        return pengarang;
    }

    public void setPengarang(Pengarang pengarang) {
        this.pengarang = pengarang;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public boolean isNewPengarang() {
        return newPengarang;
    }

    public void setNewPengarang(boolean newPengarang) {
        this.newPengarang = newPengarang;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public Timestamp getInputTime() {
        return inputTime;
    }

    public void setInputTime(Timestamp inputTime) {
        this.inputTime = inputTime;
    }
}
