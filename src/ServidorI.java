import java.awt.TextComponent;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JTextArea;

public interface ServidorI extends Remote {
    
    public boolean aceitarConexao(String nome) throws RemoteException;    
    public JTextArea broadcast(JTextArea tc, String nome, String msg) throws RemoteException;
    public boolean desconectar(String nome) throws RemoteException;
}
