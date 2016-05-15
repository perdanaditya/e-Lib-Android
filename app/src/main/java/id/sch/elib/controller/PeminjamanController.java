package id.sch.elib.controller;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;

import id.sch.elib.model.Peminjaman;
import id.sch.elib.service.PeminjamanService;
import id.sch.elib.util.BaseControllerInterface;
import id.sch.elib.util.DataLibrary;

/**
 * Created by rizky.aditya on 14/05/2016.
 */
public class PeminjamanController implements BaseControllerInterface {

    private Peminjaman peminjaman;
    private boolean editMode;
    private PeminjamanService peminjamanService = new PeminjamanService();
    private Timestamp now = new Timestamp(new Date().getTime());

    //GETTER SETTER
    public Peminjaman getPeminjaman() {
        return peminjaman;
    }

    public void setPeminjaman(Peminjaman peminjaman) {
        this.peminjaman = peminjaman;
    }

    public boolean isEditMode() {
        return editMode;
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    public PeminjamanService getPeminjamanService() {
        return peminjamanService;
    }

    public void setPeminjamanService(PeminjamanService peminjamanService) {
        this.peminjamanService = peminjamanService;
    }

    public Timestamp getNow() {
        return now;
    }

    public void setNow(Timestamp now) {
        this.now = now;
    }
    //END OF GETTER SETTER

    //OVERRIDE METHOD
    @Override
    public Object search(Object completeList, String param, String column) {
        return null;
    }

    @Override
    public Object fetchData() {
        Peminjaman target = new Peminjaman();
        target = (Peminjaman) peminjamanService.fetchPeminjmanByUserId();
        DataLibrary.getInstance().setPeminjaman(target);
        try {
            if (target.getDetailPeminjaman().size() > 0) {
                return target.getDetailPeminjaman();
            }
        }catch (Exception e){
            System.out.println("fetchData PEMINJAMAN CTRL: "+e.getMessage());
        }
        return null;
    }

    @Override
    public String save() {
        return null;
    }
    //END OF OVERRIDE METHOD

}
