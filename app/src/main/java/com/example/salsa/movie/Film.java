package com.example.salsa.movie;

public class Film {
    private String nama_film;
    private String detail_film;
    private int gambar_;
    private String video;

    public static final Film[] filmfilm = {
            new Film("Black Panther", "Black Panther adalah film pahlawan super Amerika berdasarkan karakter Marvel Comics dengan nama sama. Diproduksi oleh Marvel Studios dan didistribusikan oleh Walt Disney Studios Motion Pictures, film ini merupakan film kedelapan belas dari Marvel Cinematic Universe.",R.drawable.black, "https://www.youtube.com/watch?v=VSB4wGIdDwo"),
            new Film("Captain America", "Captain America: The First Avenger merupakan sebuah film pahlawan super Amerika Serikat yang dirilis pada tahun 2011. Film yang disutradarai oleh Joe Johnston ini pemainnya antara lain oleh Chris Evans, Tommy Lee Jones dan masih banyak lagi.",R.drawable.captain, "https://www.youtube.com/watch?v=dKrVegVI0Us"),
            new Film("Deadpool", "Deadpool adalah sebuah film pahlawan super Amerika yang berdasarkan pada karakter Marvel Comics dengan nama yang sama. Film tersebut merupakan instalmen kedelapan dalam serial film X-Men.",R.drawable.deadpool, "https://www.youtube.com/watch?v=ONHBaC-pfsk"),
            new Film("Iron Man", "Iron Man adalah sebuah film yang berdasarkan tokoh Marvel Comics Iron Man. Film ini disutradarai oleh Jon Favreau dan dibintangi Robert Downey Jr., Gwyneth Paltrow, Terrence Howard, dan Jeff Bridges. Film ini dirilis pada 2 Mei 2008 di Amerika Serikat.",R.drawable.iron,"https://www.youtube.com/watch?v=Ke1Y3P9D0Bc"),
            new Film("Thor", "Thor adalah film pahlawan super Amerika 2011 berdasarkan karakter Marvel Comics dengan nama yang sama, diproduksi oleh Marvel Studios dan didistribusikan oleh Paramount Pictures. Ini adalah film keempat di Marvel Cinematic Universe.",R.drawable.thoro,"https://www.youtube.com/watch?v=ue80QwXMRHg"),
    };


    public Film(String nama, String detail, int gambar, String video){
        this.nama_film = nama;
        this.detail_film = detail;
        this.gambar_ = gambar;
        this.video = video;
    }

    public String getDetail_film(){
        return detail_film;
    }

    public String getNama_film() {
        return nama_film;
    }

    public int getGambar_() {
        return gambar_;
    }

    public String getVideo(){return video;}

    @Override
    public String toString() {
        return this.nama_film;
    }
}
