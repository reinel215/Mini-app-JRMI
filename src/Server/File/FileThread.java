package Server.File;

import Common.RMIInterface;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FileThread extends UnicastRemoteObject implements RMIInterface {

    private File file;

    public FileThread(String filePath) throws IOException, RemoteException {
        super();
        this.file = new File(filePath);
        this.file.createNewFile();
    }

    @Override
    public String sendMsg(String content) throws RemoteException{

        try {
            this.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Mensaje guardado con exito";
    }

    private void write(String text) throws IOException {

        if ( text == null || text.trim().isEmpty() ) throw new IOException("STRING CANNOT BE NULL");

        FileWriter writter = new FileWriter(file, true);
        writter.write(text + "\n" );
        writter.close();

    }

}
