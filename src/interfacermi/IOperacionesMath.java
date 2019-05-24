
package interfacermi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOperacionesMath extends Remote{
    
    public int insertarCuenta(int numero_cuenta, String propietario, int saldo) throws RemoteException;
    public int eliminarCuenta (int numero_cuenta) throws RemoteException;
    
    public double calcularRaiz(double numero)
            throws RemoteException;
    
    public double calcularPotencia(double numero1, double numero2)
            throws RemoteException;
    
    public double calcularMinimo(double numero1, double numero2)
            throws RemoteException;
    
    public double calcualrMaximo(double numero1, double numero2)
            throws RemoteException;
    
    public double calcularSeno(double numero1)
            throws RemoteException;
    
    public double calcularCoseno(double numero1)
            throws RemoteException;
    
    public double calcularLogaritmo(double numero1)
            throws RemoteException;
    
    public double calcularTangente(double numero1)
            throws RemoteException;
    
    public double calcularAleatorio()
            throws RemoteException;
    
    public double calcularAbsoluto(double numero1)
            throws RemoteException;
    
}
