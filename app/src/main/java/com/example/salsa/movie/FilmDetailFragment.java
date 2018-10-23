package com.example.salsa.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import static com.example.salsa.movie.Film.filmfilm;


public class FilmDetailFragment extends Fragment{

    private long filmId;

    public FilmDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_film_detail_fragment, container, false);


    }

    public void setFilm(long id){
        this.filmId = id;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView tittle = (TextView) view.findViewById(R.id.textJudul);
            final Film film = Film.filmfilm[(int) filmId];
            tittle.setText(film.getNama_film());
            TextView detail = (TextView) view.findViewById(R.id.textDetail);
            detail.setText(film.getDetail_film());
            final ImageView gambar = (ImageView) view.findViewById(R.id.gambar_film);
            gambar.setImageResource(film.getGambar_());
            final ImageView myImageView = (ImageView) view.findViewById(R.id.imgview2);
            Button btn = (Button) view.findViewById(R.id.proses);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Emojifier emoji = new Emojifier();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inMutable=true;

                    Bitmap myBitmap = BitmapFactory.decodeResource(v.getContext().getResources(),film.getGambar_(), options);
                    myImageView.setImageBitmap(emoji.detectFaces(v.getContext(), myBitmap));

                }
            });
        }
    }
}
