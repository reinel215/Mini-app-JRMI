package Server;

import Common.RMIInterface;
import Server.File.FileThread;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerOperation {




    public static void main(String[] args) throws IOException {
        String pathname = "LOG.txt";
        System.out.println("Servidor corriendo");
        Naming.rebind("//localhost/MyServer", new FileThread(pathname));
    }

}