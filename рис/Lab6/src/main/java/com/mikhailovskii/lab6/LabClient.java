package com.mikhailovskii.lab6;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class LabClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String genre = "";

        try {
            URL url = new URL("http://localhost:8080/ws/hello?wsdl");
            QName qname = new QName("http://lab6.mikhailovskii.com/", "LabImplService");
            Service service = Service.create(url, qname);
            LabIF hello = service.getPort(LabIF.class);


            System.out.println("Enter the genre: ");
            genre = scanner.nextLine();
            hello.filterSongsByGenre(genre);

            while (true) {
                System.out.println("1 - search by singer");
                System.out.println("2 - search by album");
                System.out.println("3 - change genre");
                System.out.println("0 - exit");
                choice = scanner.nextInt();

                if (choice == 0) {
                    return;
                } else if (choice == 3) {
                    System.out.println("Enter the genre: ");
                    scanner.nextLine();
                    genre = scanner.nextLine();
                    hello.filterSongsByGenre(genre);
                    continue;
                }

                String searchParameter = "";
                String searchValue = "";

                if (choice == 1) {
                    searchParameter = "singer";
                } else {
                    searchParameter = "album";
                }

                System.out.println("Enter the " + searchParameter + ": ");
                scanner.nextLine();
                searchValue = scanner.nextLine();

                String songs = hello.searchSong(searchParameter, searchValue);

                System.out.println(songs);
            }


        } catch (MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }

}
