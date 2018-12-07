package com.example.salsa.movie;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements FilmListFragment.Listener {

    VideoView videoView;
    ListView listView;
    TextView textLoading;

    ArrayList<String> listVideo;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        videoView = (VideoView) findViewById(R.id.videoView);
        listView = (ListView) findViewById(R.id.listView);

//        textLoading = (TextView) findViewById(R.id.textLoading);
//        textLoading.setVisibility(VideoView.INVISIBLE);

        listVideo = new ArrayList<>();
        listVideo.add("Wonder Woman Official Trailer");
        listVideo.add("Aquaman Official Trailer");

        //mengambil data dari SinetronModel
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, MovieModel.film);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MovieModel movieModel = MovieModel.film[(int) id];
                Uri videoUri = dapatkanMedia(movieModel.getVideoRawId());
                buatPlayer(videoUri);

                //Menambah controller playback
                videoView.setMediaController(new MediaController(Main2Activity.this));
                videoView.requestFocus();
                videoView.start();
            }
        });
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

    private Uri dapatkanMedia(String namaMedia){
        if(URLUtil.isValidUrl(namaMedia)){
            //media nama dari external URL
            return Uri.parse(namaMedia);
        }   else {
            return Uri.parse("android.resource://" + getPackageName() + "/raw/" + namaMedia);
        }

    }

    private void  buatPlayer(Uri videoUri){

        //set resource video
        videoView.setVideoURI(videoUri);

        //text loading
        textLoading.setVisibility(VideoView.VISIBLE);

        //Menambah controller playback
//        videoView.setMediaController(new MediaController(MainActivity.this));
//        videoView.requestFocus();
//        videoView.start();

        //agar posisi controller melekat pada videoview
        MediaController mc = new MediaController(Main2Activity.this);
        videoView.setMediaController(mc);
        mc.setAnchorView(videoView);

        //listener untuk event onPrepared() event (dujalankan saat siap di mainkan)
        videoView.setOnPreparedListener(
                new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        //sembunyikan text loading
                        textLoading.setVisibility(VideoView.INVISIBLE);

                        //start mainkan video!
                        videoView.start();
                    }
                }
        );

        //listener untuk event onCompletion() (saat selesai di mainkan)
        videoView.setOnCompletionListener(
                new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(Main2Activity.this, "video tamat", Toast.LENGTH_SHORT).show();

                        //kembalikan ke posisi frame 0
                        videoView.seekTo(0);
                    }
                }
        );

    }
}

