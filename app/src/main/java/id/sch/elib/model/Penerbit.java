package id.sch.elib.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by rizky.aditya on 28/03/2016.
 */
public class Penerbit implements Serializable {

    private long id;
    private String namaPenerbit;
    private String alamatPenerbit;
    private String kotaPenerbit;
    private String telponPenerbit;
    private boolean active;
    private String userInput;
    private Timestamp inputTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaPenerbit() {
        return namaPenerbit;
    }

    public void setNamaPenerbit(String namaPenerbit) {
        this.namaPenerbit = namaPenerbit;
    }

    public String getAlamatPenerbit() {
        return alamatPenerbit;
    }

    public void setAlamatPenerbit(String alamatPenerbit) {
        this.alamatPenerbit = alamatPenerbit;
    }

    public String getKotaPenerbit() {
        return kotaPenerbit;
    }

    public void setKotaPenerbit(String kotaPenerbit) {
        this.kotaPenerbit = kotaPenerbit;
    }

    public String getTelponPenerbit() {
        return telponPenerbit;
    }

    public void setTelponPenerbit(String telponPenerbit) {
        this.telponPenerbit = telponPenerbit;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
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
