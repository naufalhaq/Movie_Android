package com.example.salsa.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

public class ListFilm extends AppCompatActivity {

    VideoView videoView;
    ListView listView;
    TextView textLoading;

    ArrayList<String> listVideo;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_film);
    }
}
