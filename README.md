Kelompok 4

Muhammad Ilham Naufal Haq		19/1541180088

Salsabiela Cahyahaq			    21/1541180066


Judul Aplikasi	:	FILM


Deskripsi	:

Aplikasi Film ini merupakan sebuah aplikasi yang memuat berbagai film beserta dengan sinopsis singkat mengenai film tersebut. Pada saat pertama kali kita membuka aplikasi ini maka kita akan masuk pada halaman pertama aplikasi, dimana pada halaman tersebut terdapat button “start”. Setelah kita menekan tombol “start” tersebut, maka kita akan masuk pada halaman list film. Pada halaman tersebut apabila kita memilih salah satu dari judul film, maka kita akan masuk pada halaman film sesuai dengan judul yang telah kita pilih. Pada halaman film tersebut akan memuat sinopsis singkat mengenai film tersebut beserta gambar film tersebut. Pada halaman film itu juga memuat button “proses”, yang mana pada saat kita menekan button proses” tersebut maka gambar film tersebut akan diproses dengan face emoji sesuai dengan gambar film tersebut. Untuk halaman list film menggunakan fragment yang mana dapat membagi layar menjadi dua bagian, satu bagian untuk list film dan satu bagian lagi untuk detail film tersebut. Pada aplikasi ini akan memuat notifikasi yang akan masuk pada layar pemberitahuan kita. Saat kita menekan notifikasi tersebut maka kita akan masuk pada halaman awal aplikasi film.


Requirement	:

Aplikasi Film ini menggunakan min Android OS Kitkat Level 19.


List Class	:

-	DetailActivity.java
Class yang di dalamnya memuat detail dari setiap film dengan memparsing data dari listview.
-	Emojifier.java
Class yang berfungsi sebagai pendeteksi wajah dengan mengganti wajah sesuai dengan emojifier.
-	Film.java
Class untuk menampung data film yang nilainya akan ditampilkan.  
-	FilmDetailFragment.java
Pada class ini detail film ditampilkan sesuai dengan listview yang dipilih.
-	FilmListFragment.java
Class yang menghandle listview atau daftar dari film.
-	Main2Activity.java
Class yang menjalankan fragment berupa listview beserta detail yang dipilih.
-	MainActivity.java
Class pertama yang mengarah pada Main2Activity.java.
-	MyFirebaseMessaging.java
Class yang memuat method unuk mengirimkan pesan dan mendapatkan token serta fungsi onMessageReceive untuk menerima pesan.
-	MyNotificationManager.java
Class yang berfungsi membuat tampilan notifikasi pada fungsi onReceiveMessage.


Lisensi :

FILM License

Copyright © 2018 Google, Inc.


Permission is hereby granted, free of charge. You can freely use, modify, distribute and sell a software licensed without worrying about the use of software: personal, internal or commercial. This license explicitly grants rights to users that can be applied to both copyrights and patents. If you redistribute software with this software, you must include a copy of the license.

This software is provided "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied, including, without limitation, any warranties or conditions of TITLE, NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE. You are solely responsible for determining the appropriateness of using or redistributing the Work and assume any risks associated with Your exercise of permissions under this License.
