package com.mikhailovskii.lab6;

import javax.jws.WebService;
import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

@WebService(endpointInterface = "com.mikhailovskii.lab6.LabIF")
public class LabImpl implements LabIF {

    private ArrayList<Song> songs = new ArrayList<>();

    @Override
    public String searchSong(String searchParameter, String value) throws RemoteException {
        StringBuilder searchSongs = new StringBuilder();
        for (Song song : songs) {
            if (searchParameter.equalsIgnoreCase("singer")) {
                if (song.getSinger().equalsIgnoreCase(value)) {
                    searchSongs.append(song);
                }
            } else if (searchParameter.equalsIgnoreCase("album")) {
                if (song.getAlbum().equalsIgnoreCase(value)) {
                    searchSongs.append(song);
                }
            }
        }
        return searchSongs.toString();
    }

    @Override
    public void filterSongsByGenre(String genre) throws RemoteException {
        File file = new File("songs.txt");
        songs = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] arr = data.split(" ");
                Song song = new Song(arr[0], arr[1], arr[2], arr[3]);
                if (song.getGenre().equalsIgnoreCase(genre)) {
                    songs.add(song);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}