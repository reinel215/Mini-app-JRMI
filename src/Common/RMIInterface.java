package Common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {

    public String sendMsg(String name) throws RemoteException;

}
