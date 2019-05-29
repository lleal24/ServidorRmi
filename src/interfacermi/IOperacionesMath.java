
package interfacermi;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IOperacionesMath extends Remote{
    
    public int insertarCuenta(int numero_cuenta, String propietario, int saldo) throws RemoteException;
    public int eliminarCuenta (int numero_cuenta) throws RemoteException;
    public int modificarCuenta(int numero_cuenta, String propietario) throws RemoteException;
    public int agregarSaldo(int numero_cuenta, int valor) throws RemoteException;
    public int retirarSaldo(int numero_cuenta, int valor) throws RemoteException;
    public String consultar(String numero_cuenta) throws RemoteException;
    
}
