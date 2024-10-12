/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.EmpleadoDAO;
import modelo.Sincronizador;
import vista.FrmMostrar;
import vista.FrmMostrarPos;
import vista.Frm_Insertar;
import vista.Frm_Menu;

/**
 *
 * @author John
 */
public class ControladorMenu implements ActionListener {

    Frm_Menu vMe = new Frm_Menu();
    Frm_Insertar vIn = new Frm_Insertar();
    FrmMostrar vMo = new FrmMostrar();
    FrmMostrarPos vMop = new FrmMostrarPos();
    EmpleadoDAO em = new EmpleadoDAO();
    Sincronizador sin = new Sincronizador();

    public ControladorMenu(Frm_Menu vMe, FrmMostrar vMo,FrmMostrarPos vMop,Frm_Insertar vIn) {
        this.vMe = vMe;
        this.vMo = vMo;
        this.vMop = vMop;
        this.vIn = vIn;

        vMe.btnMysql.addActionListener(this);
        vMe.btnInsertarM.addActionListener(this);
        vMe.btnPostgres.addActionListener(this);
        vMe.btnSincronizar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vMe.btnMysql) {
            vMo.setVisible(true);
            vMo.setLocationRelativeTo(null);
        }
        if (e.getSource() == vMe.btnPostgres) {
            vMop.setVisible(true);
            vMop.setLocationRelativeTo(null);
        }
        if (e.getSource() == vMe.btnSincronizar) {
           sin.sincronizarBasesDeDatos();
           JOptionPane.showMessageDialog(null, "Sincronización completada.");
        }
        if (e.getSource() == vMe.btnInsertarM) {
            vIn.setVisible(true);
            vIn.setLocationRelativeTo(null);
        }
    }

}
