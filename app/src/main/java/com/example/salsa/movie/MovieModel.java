package com.example.salsa.movie;

public class MovieModel {

    private String nama, durasi, videoRawId;

    public static final MovieModel[] film = {

            new MovieModel("Black Panther", "05:12", "https://www.youtube.com/watch?v=VSB4wGIdDwo"),
            new MovieModel("Captain America", "02:51", "https://www.youtube.com/watch?v=dKrVegVI0Us"),
            new MovieModel("Deadpool", "02:51", "https://www.youtube.com/watch?v=ONHBaC-pfsk"),
            new MovieModel("Iron Man", "02:51", "https://www.youtube.com/watch?v=Ke1Y3P9D0Bc"),
            new MovieModel("Thor", "02:51", "https://www.youtube.com/watch?v=ue80QwXMRHg"),
    };

    //nama, deskripsi dan gambar
    private MovieModel(String nama, String durasi, String videoRawId){
        this.nama = nama;
        this.durasi = durasi;
        this.videoRawId = videoRawId;
    }

    public  String getNama(){
        return nama;
    }

    public  String getDurasi(){
        return durasi;
    }

    public  String getVideoRawId(){
        return videoRawId;
    }

    public String toString(){
        return this.nama;
    }
}
