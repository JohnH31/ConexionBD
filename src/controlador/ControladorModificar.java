/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import vista.Frm_Actualizar;


/**
 *
 * @author John
 */
public class ControladorModificar implements ActionListener{

    Frm_Actualizar ac = new Frm_Actualizar();
    Empleado pvo = new Empleado();
    EmpleadoDAO pdao = new EmpleadoDAO();
    public ControladorModificar(Empleado pvo,EmpleadoDAO pdao, Frm_Actualizar ac) {
        this.pvo = pvo;
        this.pdao = pdao;
        this.ac = ac;

        ac.btnInsertar.addActionListener(this);
        ac.btnInsertarPos.addActionListener(this);
        ac.btnCancelar.addActionListener(this);

    }


    private void modi() {
        try{
        pvo.getDpi();
         pvo.setPrimer_nombre(ac.txtPNom.getText());
        pvo.setSegundo_nombre(ac.txtSNom.getText());
        pvo.setPrimer_apellido(ac.txtPApe.getText());
        pvo.setSegundo_apellido(ac.txtSApe.getText());
        pvo.setDireccion(ac.txtDir.getText());
        pvo.setTelefono_casa(ac.txtTCasa.getText());
        pvo.setTelefono_movil(ac.txtTmov.getText());
        pvo.setSalario_base(Double.parseDouble(ac.txtSalBase.getText()));
        pvo.setBonificacion(Double.parseDouble(ac.txtBon.getText()));
        pdao.actualizar(pvo);
        JOptionPane.showMessageDialog(null,"Registro Ingresado");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Debe ingresar Datos para guardar registro");
        }
    }

        private void modi2() {
        try{
        pvo.getDpi();
        pvo.setPrimer_nombre(ac.txtPNom.getText());
        pvo.setSegundo_nombre(ac.txtSNom.getText());
        pvo.setPrimer_apellido(ac.txtPApe.getText());
        pvo.setSegundo_apellido(ac.txtSApe.getText());
        pvo.setDireccion(ac.txtDir.getText());
        pvo.setTelefono_casa(ac.txtTCasa.getText());
        pvo.setTelefono_movil(ac.txtTmov.getText());
        pvo.setSalario_base(Double.parseDouble(ac.txtSalBase.getText()));
        pvo.setBonificacion(Double.parseDouble(ac.txtBon.getText()));
        pdao.actualizarPos(pvo);
        JOptionPane.showMessageDialog(null,"Registro Ingresado");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Debe ingresar Datos para guardar registro");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ac.btnInsertar){
            this.modi();
            ac.dispose();
        }
        if(e.getSource() == ac.btnCancelar){
            ac.dispose();
        }
                if(e.getSource() == ac.btnInsertarPos){
            this.modi2();
            ac.dispose();
        }
    }

}
