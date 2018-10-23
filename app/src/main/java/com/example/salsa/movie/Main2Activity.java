package com.example.salsa.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements FilmListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void itemClicked(long id) {
        View fragmenDetail = findViewById(R.id.detailFrag);
        if(fragmenDetail!=null)
        {
            FilmDetailFragment deta = new FilmDetailFragment();

            FragmentTransaction fragTrans = getSupportFragmentManager().beginTransaction();
            deta.setFilm(id);
            fragTrans.replace(R.id.detailFrag,deta);
            fragTrans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragTrans.addToBackStack(null);
            fragTrans.commit();
        }

        else
        {
            Toast.makeText(this, "Item " + id + " was clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this.getApplicationContext(), DetailActivity.class);
            Bundle b = new Bundle();
            b.putLong("id",id);
            intent.putExtras(b);
            startActivity(intent);
        }
    }
}

