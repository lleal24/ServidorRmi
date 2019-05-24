package servidorrmi;

import java.rmi.server.UnicastRemoteObject;
import interfacermi.IOperacionesMath;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ServidorRmi extends UnicastRemoteObject implements IOperacionesMath {

    private final int PUERTO = 5000;

    public ServidorRmi() throws RemoteException {

    }

    public static void main(String[] args) throws Exception {
        (new ServidorRmi()).iniciarServidor();
    }

    @Override
    public double calcularRaiz(double numero) throws RemoteException {

        return Math.sqrt(numero);
    }

    public void iniciarServidor() {
        try {

            String dirIP = (InetAddress.getLocalHost().toString());
            System.out.println("Ip: " + dirIP + "Puerto " + PUERTO);
            Registry registro = LocateRegistry.createRegistry(PUERTO);
            registro.bind("operaciones", (IOperacionesMath) this);

        } catch (UnknownHostException | RemoteException | AlreadyBoundException e) {
            System.out.println("Error al iniciar Servidor " + e);
        }
    }

    @Override
    public int insertarCuenta(int numero, String propietario, int saldo) throws RemoteException {
        int estado;
        Connection conectar = null;

        try {
            //conectar = Conexion.conectar();

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "");
            //se realiza el llamado al procedimiento con los tres parametros de entada
            CallableStatement prcProcedimientoAlmacenado = con.prepareCall("{call Insertar(?,?,?)}");
            //cargar los parametros

            prcProcedimientoAlmacenado.setInt(1, numero);
            prcProcedimientoAlmacenado.setString(2, propietario);
            prcProcedimientoAlmacenado.setInt(3, saldo);

            //ejecucion del procedimiento
            prcProcedimientoAlmacenado.execute();
            estado = 5;
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            estado = 1;
        }
        return estado;

    }
    
    public int eliminarCuenta(int numero) throws RemoteException{
        Connection conectar = null;
        int estado;
        try{
            
            //conectar = Conexion.conectar();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "");
            
            CallableStatement prcProcedimientoAlmacenado = con.prepareCall("{call Borrar(?)}");
            prcProcedimientoAlmacenado.setInt(1, numero);
            prcProcedimientoAlmacenado.execute();
            estado = 5;
            con.close();
            
        }catch(Exception e){
            e.printStackTrace();
            estado = 1;
        }
        return estado;
    }

    @Override
    public double calcularPotencia(double numero1, double numero2) throws RemoteException {
        return Math.pow(numero1, numero2);
    }

    @Override
    public double calcularMinimo(double numero1, double numero2) throws RemoteException {
        return Math.min(numero2, numero1);
    }

    @Override
    public double calcualrMaximo(double numero1, double numero2) throws RemoteException {
        return Math.max(numero2, numero1);
    }

    @Override
    public double calcularSeno(double numero1) throws RemoteException {
        return Math.sin(numero1);
    }

    @Override
    public double calcularCoseno(double numero1) throws RemoteException {
        return Math.cos(numero1);
    }

    @Override
    public double calcularLogaritmo(double numero1) throws RemoteException {
        return Math.log(numero1);
    }

    @Override
    public double calcularTangente(double numero1) throws RemoteException {
        return Math.tan(numero1);
    }

    @Override
    public double calcularAleatorio() throws RemoteException {
        return Math.random();
    }

    @Override
    public double calcularAbsoluto(double numero1) throws RemoteException {
        return Math.abs(numero1);
    }

}
