
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Rafael
 * Data: 29/11/2018
 */
public class Servidor extends UnicastRemoteObject implements Servico{

    public Servidor() throws RemoteException{
        super();
    }
    
    public static void main(String[] args){
        try {
            Servidor servidor = new Servidor();
            String localizacao = "//localhost/servico";
            Naming.rebind(localizacao, servidor);
        } catch (RemoteException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public String getDataHora() throws RemoteException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(Calendar.getInstance().getTime());
    }

    @Override
    public String invertString(String texto) throws RemoteException {
        String retorno = null; 
        StringBuffer strb = new StringBuffer(texto);  
        retorno = strb.reverse().toString();
        return retorno;
    }
    
    
}
