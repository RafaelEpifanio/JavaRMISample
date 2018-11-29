
import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * @author Rafael
 * Data: 29/11/2018
 */
public interface Servico extends Remote{
     public String getDataHora() throws RemoteException;
     
     public String invertString(String texto) throws RemoteException;
}
