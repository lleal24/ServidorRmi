/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import interfacermi.IOperacionesMath;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dago9
 */
public class ClienteRmi extends javax.swing.JFrame {

    IOperacionesMath servidorRmi;

    public ClienteRmi() {

        String direccionServer = "localhost";
        int puertoServer = 5000;
        try {

            Registry registro = LocateRegistry.getRegistry(direccionServer, puertoServer);
            servidorRmi = (IOperacionesMath) (registro.lookup("operaciones"));

        } catch (RemoteException | NotBoundException e) {
            System.out.println("Error main cliente " + e);
        }

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnRaiz = new javax.swing.JButton();
        btnMaximo = new javax.swing.JButton();
        btnLogaritmo = new javax.swing.JButton();
        Potencia = new javax.swing.JButton();
        btnSeno = new javax.swing.JButton();
        btnRandom = new javax.swing.JButton();
        btnMinimo = new javax.swing.JButton();
        Coseno = new javax.swing.JButton();
        btnTangente = new javax.swing.JButton();
        btnAbsoluto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Menu");

        btnRaiz.setText("Raiz");
        btnRaiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaizActionPerformed(evt);
            }
        });

        btnMaximo.setText("Maximo");
        btnMaximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaximoActionPerformed(evt);
            }
        });

        btnLogaritmo.setText("Logaritmo");
        btnLogaritmo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogaritmoActionPerformed(evt);
            }
        });

        Potencia.setText("Potencia");
        Potencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PotenciaActionPerformed(evt);
            }
        });

        btnSeno.setText("Seno");
        btnSeno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSenoActionPerformed(evt);
            }
        });

        btnRandom.setText("Aleatorio");
        btnRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRandomActionPerformed(evt);
            }
        });

        btnMinimo.setText("Minimo");
        btnMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimoActionPerformed(evt);
            }
        });

        Coseno.setText("Coseno");
        Coseno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CosenoActionPerformed(evt);
            }
        });

        btnTangente.setText("Tangente");
        btnTangente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTangenteActionPerformed(evt);
            }
        });

        btnAbsoluto.setText("Absoluto");
        btnAbsoluto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbsolutoActionPerformed(evt);
            }
        });

        jLabel2.setText("Diego Mateo Sierra Torres");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMaximo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLogaritmo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRaiz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Potencia)
                                    .addComponent(btnSeno, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRandom))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTangente)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnMinimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Coseno, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAbsoluto)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(44, 44, 44))
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRaiz)
                    .addComponent(Potencia)
                    .addComponent(btnMinimo))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMaximo)
                    .addComponent(btnSeno)
                    .addComponent(Coseno))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogaritmo)
                    .addComponent(btnRandom)
                    .addComponent(btnTangente))
                .addGap(35, 35, 35)
                .addComponent(btnAbsoluto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRaizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaizActionPerformed
        // TODO add your handling code here:
        
          try {
            int numero_cuenta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de cuenta"));
            String propietario = JOptionPane.showInputDialog("Ingrese propietario");
            int saldo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el saldo"));
            int resultado = servidorRmi.insertarCuenta(numero_cuenta, propietario, saldo);
            JOptionPane.showMessageDialog(null, resultado + "");
        } catch (RemoteException ex) {
            System.out.println("Error en ingreso " + ex);
        }
        /*
            try {
            double numero = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el numero para calcular la raiz"));
            double resultado = servidorRmi.calcularRaiz(numero);
            JOptionPane.showMessageDialog(null, resultado + "");
        } catch (RemoteException ex) {
            System.out.println("Error en raiz " + ex);
        }
        */

    }//GEN-LAST:event_btnRaizActionPerformed

    private void PotenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PotenciaActionPerformed
        try {
            double numero1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el numero base"));
            double numero2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el numero exponente"));
            double resultado = servidorRmi.calcularPotencia(numero1, numero2);
            JOptionPane.showMessageDialog(null, resultado + "");
        } catch (RemoteException ex) {
            System.out.println("Error en potencia " + ex);
        }
    }//GEN-LAST:event_PotenciaActionPerformed

    private void btnMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimoActionPerformed
        try {
            double numero1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el numero 1"));
            double numero2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el numero 2"));
            double resultado = servidorRmi.calcularMinimo(numero1, numero2);
            JOptionPane.showMessageDialog(null, "Minimo: " + resultado);
        } catch (RemoteException ex) {
            System.out.println("Error en minimo " + ex);
        }
    }//GEN-LAST:event_btnMinimoActionPerformed

    private void btnMaximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaximoActionPerformed
        try {
            double numero1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el numero 1"));
            double numero2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el numero 2"));
            double resultado = servidorRmi.calcualrMaximo(numero1, numero2);
            JOptionPane.showMessageDialog(null, "Maximo: " + resultado);
        } catch (RemoteException ex) {
            System.out.println("Error en maximo " + ex);
        }
    }//GEN-LAST:event_btnMaximoActionPerformed

    private void btnSenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSenoActionPerformed
        try {
            double numero1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el numero  a calcular el seno"));
            double resultado = servidorRmi.calcularSeno(numero1);
            JOptionPane.showMessageDialog(null, "Seno: " + resultado);
        } catch (RemoteException ex) {
            System.out.println("Error en seno " + ex);
        }
    }//GEN-LAST:event_btnSenoActionPerformed

    private void CosenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CosenoActionPerformed
        try {
            double numero1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el numero  a calcular el coseno"));
            double resultado = servidorRmi.calcularCoseno(numero1);
            JOptionPane.showMessageDialog(null, "Coseno: " + resultado);
        } catch (RemoteException ex) {
            System.out.println("Error en coseno " + ex);
        }
    }//GEN-LAST:event_CosenoActionPerformed

    private void btnLogaritmoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogaritmoActionPerformed
        try {
            double numero1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el numero  a calcular el logaritmo"));
            double resultado = servidorRmi.calcularLogaritmo(numero1);
            JOptionPane.showMessageDialog(null, "Logaritmo: " + resultado);
        } catch (RemoteException ex) {
            System.out.println("Error en logaritmo " + ex);
        }
    }//GEN-LAST:event_btnLogaritmoActionPerformed

    private void btnRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRandomActionPerformed
        try {
            double resultado = servidorRmi.calcularAleatorio();
            JOptionPane.showMessageDialog(null, "Numero aleatorio: " + resultado + "");
        } catch (RemoteException ex) {
            System.out.println("Error en aleatorio " + ex);
        }
    }//GEN-LAST:event_btnRandomActionPerformed

    private void btnTangenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTangenteActionPerformed
        try {
            double numero1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el numero  a calcular el tangente"));
            double resultado = servidorRmi.calcularTangente(numero1);
            JOptionPane.showMessageDialog(null, "Tangente: " + resultado);
        } catch (RemoteException ex) {
            System.out.println("Error en tangente " + ex);
        }
    }//GEN-LAST:event_btnTangenteActionPerformed

    private void btnAbsolutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbsolutoActionPerformed
        try {
            double numero1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el numero  a calcular el absoluto"));
            double resultado = servidorRmi.calcularAbsoluto(numero1);
            JOptionPane.showMessageDialog(null, "Absoluto: " + resultado);
        } catch (RemoteException ex) {
            System.out.println("Error en absoluto " + ex);
        }
    }//GEN-LAST:event_btnAbsolutoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteRmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteRmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteRmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteRmi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteRmi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Coseno;
    private javax.swing.JButton Potencia;
    private javax.swing.JButton btnAbsoluto;
    private javax.swing.JButton btnLogaritmo;
    private javax.swing.JButton btnMaximo;
    private javax.swing.JButton btnMinimo;
    private javax.swing.JButton btnRaiz;
    private javax.swing.JButton btnRandom;
    private javax.swing.JButton btnSeno;
    private javax.swing.JButton btnTangente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
