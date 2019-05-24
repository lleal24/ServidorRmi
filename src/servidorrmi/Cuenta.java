/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorrmi;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Cuenta implements Serializable{

    private int numero_cuenta;
    private String propietario;
    private int saldo;
    public Cuenta (int numero_cuenta,String propietario,int saldo){
        this.numero_cuenta=numero_cuenta;
        this.propietario=propietario;
        this.saldo=saldo;
        
    }

    public int getNumero_cuenta() {
        return numero_cuenta;
    }

    public String getPropietario() {
        return propietario;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setNumero_cuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

}
