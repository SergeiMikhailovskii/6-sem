package com.mikhailovskii.lab6;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.rmi.Remote;
import java.rmi.RemoteException;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface LabIF extends Remote {

    String searchSong(String searchParameter, String value) throws RemoteException;

    void filterSongsByGenre(String genre) throws RemoteException;

}
