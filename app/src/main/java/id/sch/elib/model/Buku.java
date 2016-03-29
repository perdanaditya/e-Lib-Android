package id.sch.elib.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by rizky.aditya on 28/03/2016.
 */
public class Buku implements Serializable {

    private long id;
    private String isbn;
    private Penerbit penerbit;
    private String judul;
    private Integer stock;
    private String tahunTerbit;
    private Byte[] cover;
    private RakBuku rakBuku;
    private Integer masaPinjam;
    private Boolean active;
    private String userInput;
    private Timestamp inputTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Penerbit getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(Penerbit penerbit) {
        this.penerbit = penerbit;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public Byte[] getCover() {
        return cover;
    }

    public void setCover(Byte[] cover) {
        this.cover = cover;
    }

    public RakBuku getRakBuku() {
        return rakBuku;
    }

    public void setRakBuku(RakBuku rakBuku) {
        this.rakBuku = rakBuku;
    }

    public Integer getMasaPinjam() {
        return masaPinjam;
    }

    public void setMasaPinjam(Integer masaPinjam) {
        this.masaPinjam = masaPinjam;
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
