package Client;

import Common.RMIInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;


public class ClientOperation {

    private static RMIInterface look_up;

    public static void main(String[] args)
            throws MalformedURLException, RemoteException, NotBoundException {

        look_up = (RMIInterface) Naming.lookup("//localhost/MyServer");

        while(true){
            String txt = JOptionPane.showInputDialog("What do you want to save? (type \"exit\" to leave)");
            if ( txt == null || txt.equals("exit")) return;
            String response = look_up.sendMsg(txt);
            JOptionPane.showMessageDialog(null, response);
        }
    }

}