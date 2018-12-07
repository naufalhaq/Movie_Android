package com.example.salsa.movie;

public class MovieModel {

    private String nama, durasi, videoRawId;

    public static final MovieModel[] film = {

            new MovieModel("Wonder Woman", "05:12", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"),
//            new MovieModel("Aquaman", "02:51", "aquaman"),
//            new MovieModel("Batman", "02:51", "batman"),
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
