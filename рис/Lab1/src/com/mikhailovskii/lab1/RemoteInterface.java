package com.mikhailovskii.lab1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {

    String replaceAllVowelsWithStars(String str) throws RemoteException;

}
