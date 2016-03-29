package id.sch.elib.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import id.sch.elib.model.Peminjaman;
import id.sch.elib.util.BaseServiceInterface;
import id.sch.elib.util.GrailsRestClient;
import id.sch.elib.util.Message;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rizky.aditya on 28/03/2016.
 */
public class PeminjamanService implements BaseServiceInterface {

    private final GrailsRestClient grc = new GrailsRestClient();
    private final Gson gson = new Gson();
    private final String endpoint = "peminjaman";

    @Override
    public Object listAll() {
        String json = grc.get(endpoint);
        Type type = new TypeToken<List<Peminjaman>>() {
        }.getType();
        List<Peminjaman> output = gson.fromJson(json, type);
        return output;
    }

    @Override
    public Object get(long id) {
        Peminjaman jo = gson.fromJson(grc.get(endpoint + "/" + id), Peminjaman.class);
        return jo;
    }

    @Override
    public Object save(Object obj) {
        String response = grc.add(endpoint, obj);
        Message jo = gson.fromJson(response, Message.class);
        System.out.println("RESPONSE");
        return jo;
    }

    @Override
    public Object update(Object obj) {
        Peminjaman cast = (Peminjaman) obj;
        Message jo = gson.fromJson(grc.put(endpoint + "/" + cast.getId(), cast), Message.class);
        return  jo;
    }

    @Override
    public Object delete(Object obj) {
        return null;
    }

    @Override
    public Object search(Object obj) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String response = grc.add(endpoint + "/search", obj);
        Type type = new TypeToken<List<Peminjaman>>() {
        }.getType();
        ArrayList<Peminjaman> list = gson.fromJson(response, type);
        return list;
    }
}
