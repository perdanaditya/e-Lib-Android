package id.sch.elib.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.elib.controller.PeminjamanController;
import id.sch.elib.model.DetailPeminjaman;
import id.sch.elib.model.Peminjaman;
import id.sch.elib.util.DataLibrary;

public class PeminjamanActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
//        TODO: implement this interface if you want to use navigation bar
//        implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<DetailPeminjaman> detailPeminjamenList;
    private PeminjamanController peminjamanController = new PeminjamanController();
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peminjaman);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get a handle to the list view
        ListView lv = (ListView) findViewById(R.id.listPinjam);

        // Get list from DataLibrary and set to ListView
        detailPeminjamenList = DataLibrary.getPeminjaman().getDetailPeminjaman();
        ArrayList<String> list=new ArrayList<>();
        try {
            for (int i=0; i<detailPeminjamenList.size(); i++){
                list.add(detailPeminjamenList.get(i).getBuku().getJudul());
            }
            lv.setAdapter(new ArrayAdapter<String>(PeminjamanActivity.this,
                    android.R.layout.simple_list_item_1, list));
        }catch (Exception e){
            System.out.println("onCreate PEMINJAMAN ACTIVITY: "+e.getMessage());
        }

        ListView listview = (ListView) findViewById(R.id.listPinjam);
        listview.setOnItemClickListener(this);

        //TODO: uncommnet this block if you want to use navigation bar
        //fetch drawer
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Log.i("HelloListView", "You clicked Item: " + id + " at position:" + position);
        // Then you start a new Activity via Intent
        Intent intent = new Intent();
        intent.setClass(this, DetailActivity.class);
        intent.putExtra("position", position);

        intent.putExtra("id", id);
        PeminjamanActivity.this.finish();
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.peminjaman, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            System.out.println("CLICKED");
            Intent i = new Intent(PeminjamanActivity.this, LoginActivity.class);
            PeminjamanActivity.this.startActivity(i);
            DataLibrary.setPeminjaman(null);
            DataLibrary.setUser(null);
            PeminjamanActivity.this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //TODO: uncommnet this block if you want to use navigation bar
//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }

    /**
     * Shows the progress UI and hides the form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }
}

//Asyncrhonus class for fetching or get data from backend
class FetchPeminjaman extends AsyncTask<Void, Void, ArrayList<DetailPeminjaman>>{

    private PeminjamanController peminjamanController = new PeminjamanController();
    private ArrayList<DetailPeminjaman> detailPeminjamenList = new ArrayList<>();

    @Override
    protected ArrayList<DetailPeminjaman> doInBackground(Void... params) {
        detailPeminjamenList = (ArrayList<DetailPeminjaman>) peminjamanController.fetchData();
        return detailPeminjamenList;
    }

    public ArrayList<DetailPeminjaman> getDetailPeminjamenList() {
        return detailPeminjamenList;
    }
}
