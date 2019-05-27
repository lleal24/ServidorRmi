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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.concurrent.locks.StampedLock;
import javax.swing.JOptionPane;

public class ServidorRmi extends UnicastRemoteObject implements IOperacionesMath {

    private final int PUERTO = 5001;

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
    @Override
    public int eliminarCuenta(int numero) throws RemoteException {
        int estado;
        try {

            //conectar = Conexion.conectar();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "");

            CallableStatement prcProcedimientoAlmacenado = con.prepareCall("{call Borrar(?)}");
            prcProcedimientoAlmacenado.setInt(1, numero);
            prcProcedimientoAlmacenado.execute();
            estado = 5;
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            estado = 1;
        }
        return estado;
    }
    @Override
    public int agregarSaldo(int numero, int valor) throws RemoteException{
        int estado;
        try {

            //conectar = Conexion.conectar();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "");

            CallableStatement prcProcedimientoAlmacenado = con.prepareCall("{call Agregarsaldo(?,?)}");
            prcProcedimientoAlmacenado.setInt(1, numero);
            prcProcedimientoAlmacenado.setInt(2,valor);
            prcProcedimientoAlmacenado.executeQuery();
            //String sentencia = "UPDATE cuenta SET saldo=saldo'"+"''"+valor+"' WHERE numero_cuenta='"+numero+"';";
            //Statement st =(Statement)con.createStatement();
            //ResultSet rs = st.executeQuery(sentencia);
            estado = 5;
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            estado = 1;
        }
        return estado;
        
    }
    public int retirarSaldo(int numero, int valor) throws RemoteException{
        int estado;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "");

            CallableStatement prcProcedimientoAlmacenado = con.prepareCall("{call Retirarsaldo(?,?)}");
            prcProcedimientoAlmacenado.setInt(1, numero);
            prcProcedimientoAlmacenado.setInt(2,valor);
            prcProcedimientoAlmacenado.executeQuery();
            estado = 5;
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            estado = 1;
        }
        return estado; 
    }
    @Override
    public int modificarCuenta(int numero,String propietario) throws RemoteException {
        int estado;
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "");
            CallableStatement prcProcedimientoAlmacenado = con.prepareCall("{call Modificar(?,?)}");
            prcProcedimientoAlmacenado.setInt(1, numero);
            prcProcedimientoAlmacenado.setString(2, propietario);
            prcProcedimientoAlmacenado.execute();
            estado = 5;
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            estado = 1;
        }
        return estado;
    }
    public String consultar(int numero) throws RemoteException{
        int estado;
        int nsaldo = 0;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "");
            CallableStatement prcProcedimientoAlmacenado = con.prepareCall("{call Consultar(?)}");
            prcProcedimientoAlmacenado.setInt(1, numero);
            rs = prcProcedimientoAlmacenado.executeQuery();
            nsaldo = prcProcedimientoAlmacenado.getInt(3);
            estado = 5;
            con.close();
            
        }catch(Exception e){
            estado = 1;
            e.printStackTrace();
        }
        return ("El saldo es: "+ nsaldo);
    }

    @Override
    public double calcularPotencia(double numero1, double numero2) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calcularMinimo(double numero1, double numero2) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calcualrMaximo(double numero1, double numero2) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calcularSeno(double numero1) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calcularCoseno(double numero1) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calcularLogaritmo(double numero1) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calcularTangente(double numero1) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calcularAleatorio() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calcularAbsoluto(double numero1) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
