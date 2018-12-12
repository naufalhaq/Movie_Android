package com.example.salsa.movie;

import android.app.Notification;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.webkit.URLUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;
import android.widget.VideoView;

import static com.example.salsa.movie.Film.filmfilm;


public class FilmDetailFragment extends Fragment{

    VideoView videoView;
    TextView textLoading;


    private long filmId;

    public FilmDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragmentreturn inflater.inflate(R.layout.activity_film_detail_fragment, container, false);
        return inflater.inflate(R.layout.activity_film_detail_fragment, container, false);

    }

    public void setFilm(long id){
        this.filmId = id;
    }



    @Override
    public void onStart() {

        super.onStart();
        final View view = getView();
        if (view != null) {
            TextView tittle = (TextView) view.findViewById(R.id.textJudul);
            final Film film = Film.filmfilm[(int) filmId];
            tittle.setText(film.getNama_film());
            TextView detail = (TextView) view.findViewById(R.id.textDetail);
            detail.setText(film.getDetail_film());
            videoView = (VideoView) view.findViewById(R.id.videoView);
//            video.setVideoURI(film.getVideo());
            TextView loadingText = (TextView) view.findViewById(R.id.textLoading);
            loadingText.setVisibility(View.INVISIBLE);
            final ImageView gambar = (ImageView) view.findViewById(R.id.gambar_film);
            gambar.setImageResource(film.getGambar_());
            final ImageView myImageView = (ImageView) view.findViewById(R.id.imgview2);
            getMediaPlayer(getVideoFile(film.getVideo()));

//            Button btn = (Button) view.findViewById(R.id.proses);
//            btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Emojifier emoji = new Emojifier();
//                    BitmapFactory.Options options = new BitmapFactory.Options();
//                    options.inMutable=true;
//
//                    Bitmap myBitmap = BitmapFactory.decodeResource(v.getContext().getResources(),film.getGambar_(), options);
//                    myImageView.setImageBitmap(emoji.detectFaces(v.getContext(), myBitmap));
//
//                }
//            });
//            Button button = (Button) view.findViewById(R.id.trailer);
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent i = new Intent(view.getContext(),ListFilm.class);
//                    startActivity(i);
//                }
//            });
        }

    }

    private Uri getVideoFile(String videoName)
    {
        if (URLUtil.isValidUrl(videoName))
        {
            Log.d("VIDEO",videoName);
            return Uri.parse(videoName);
        }
        else {
            Log.d("VIDEO","android.resource://" + getActivity().getPackageName() +"/raw/" + videoName);
            return Uri.parse("android.resource://" + getActivity().getPackageName() + "/raw/" + videoName);
        }
    }

    private void getMediaPlayer(Uri uri) {
//        loadingText.setVisibility(View.VISIBLE);
        videoView.setVideoURI(uri);
        videoView.requestFocus();

        MediaController mc = new MediaController(getContext());
        videoView.setMediaController(mc);
        mc.setAnchorView(videoView);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
//                loadingText.setVisibility(View.INVISIBLE);
                videoView.start();
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
//                Toast.makeText(FilmDetailFragment.this, "The End", Toast.LENGTH_SHORT).show();
//                finish();
                videoView.seekTo(0);
            }
        });
    }
}
