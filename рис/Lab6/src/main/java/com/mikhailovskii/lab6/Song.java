package com.mikhailovskii.lab6;

class Song {

    private String name;
    private String album;
    private String singer;
    private String genre;

    Song(String name, String album, String singer, String genre) {
        this.name = name;
        this.album = album;
        this.singer = singer;
        this.genre = genre;
    }

    public String getAlbum() {
        return album;
    }

    public String getSinger() {
        return singer;
    }

    public String getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " " + album + " " + singer + " " + genre + "\n";
    }
}
