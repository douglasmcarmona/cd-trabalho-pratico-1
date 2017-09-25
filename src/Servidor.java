import java.awt.Container;
import java.awt.TextComponent;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class Servidor extends UnicastRemoteObject implements ServidorI {
    
    private ArrayList<String> usuarios;
    
    public Servidor() throws RemoteException {
        super();
        usuarios = new ArrayList<>();
    }

    @Override
    public synchronized boolean aceitarConexao(String nome) throws RemoteException {
        if(!usuarios.contains(nome)) {            
            usuarios.add(nome);            
        }
        else return false;
        return true;
    }
    
    private String receberMensagem(String nome, String msg) throws RemoteException {
        return (nome + ": " + msg);
    }

    @Override
    public synchronized JTextArea broadcast(JTextArea tc, String nome, String msg) throws RemoteException {
        for(String usuario : usuarios) {
            tc.setText(tc.getText() + "\n" + receberMensagem(nome, msg));
        }
        return tc;
    }

    @Override
    public boolean desconectar(String nome) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
