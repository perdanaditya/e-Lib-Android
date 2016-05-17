package id.sch.elib.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.elib.model.DetailPeminjaman;
import id.sch.elib.util.DataLibrary;

public class DetailActivity extends AppCompatActivity{

//    implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        // Here we turn string.xml in an array
        ArrayList<DetailPeminjaman> myKeys = DataLibrary.getPeminjaman().getDetailPeminjaman();

        TextView judulTv = (TextView) findViewById(R.id.textView);
        TextView isbnTv = (TextView) findViewById(R.id.isbn);
        TextView penerbitTv = (TextView) findViewById(R.id.penerbit);
        TextView tahunTerbitTv = (TextView) findViewById(R.id.tahun);
        TextView kategoriTv = (TextView) findViewById(R.id.kategori);

        judulTv.setText(myKeys.get(position).getBuku().getJudul());
        isbnTv.setText(myKeys.get(position).getBuku().getIsbn());
        penerbitTv.setText(myKeys.get(position).getBuku().getPenerbit().getNamaPenerbit());
        tahunTerbitTv.setText(myKeys.get(position).getBuku().getTahunTerbit());
        kategoriTv.setText(myKeys.get(position).getBuku().getRakBuku().getNamaJenis());
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
    public void onBackPressed() {
//        System.out.println("ON BACK PRESSED");
        Intent i = new Intent(DetailActivity.this, PeminjamanActivity.class);
        DetailActivity.this.startActivity(i);
        DetailActivity.this.finish();
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail, menu);
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
            Intent i = new Intent(DetailActivity.this, LoginActivity.class);
            DetailActivity.this.startActivity(i);
            DataLibrary.setPeminjaman(null);
            DataLibrary.setUser(null);
            DetailActivity.this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

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
}
