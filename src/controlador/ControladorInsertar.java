/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import vista.Frm_Insertar;

/**
 *
 * @author John
 */
public class ControladorInsertar implements ActionListener{

    Frm_Insertar vIn = new Frm_Insertar();
    Empleado pvo = new Empleado();
    EmpleadoDAO pdao = new EmpleadoDAO();
    
    public ControladorInsertar(Frm_Insertar vIn,Empleado pvo,EmpleadoDAO pdao){
        this.vIn = vIn;
        this.pvo = pvo;
        this.pdao = pdao;
        
        vIn.btnInsertar.addActionListener(this);
        vIn.btnInsertarPos.addActionListener(this);
        vIn.btnCancelar.addActionListener(this);
        
    }
    
    private void insetarEmpleado(){
        try{
        pvo.setDpi(vIn.txtDPI.getText());
        pvo.setPrimer_nombre(vIn.txtPNom.getText());
        pvo.setSegundo_nombre(vIn.txtSNom.getText());
        pvo.setPrimer_apellido(vIn.txtPApe.getText());
        pvo.setSegundo_apellido(vIn.txtSApe.getText());
        pvo.setDireccion(vIn.txtDir.getText());
        pvo.setTelefono_casa(vIn.txtTCasa.getText());
        pvo.setTelefono_movil(vIn.txtTmov.getText());
        pvo.setSalario_base(Double.parseDouble(vIn.txtSalBase.getText()));
        pvo.setBonificacion(Double.parseDouble(vIn.txtBon.getText()));
        pdao.insertar(pvo);
        JOptionPane.showMessageDialog(null,"Registro Ingresado");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Debe ingresar Datos para guardar registro");
        }
        
    }
    
        private void insetarEmpleadoPos(){
        try{
        pvo.setDpi(vIn.txtDPI.getText());
        pvo.setPrimer_nombre(vIn.txtPNom.getText());
        pvo.setSegundo_nombre(vIn.txtSNom.getText());
        pvo.setPrimer_apellido(vIn.txtPApe.getText());
        pvo.setSegundo_apellido(vIn.txtSApe.getText());
        pvo.setDireccion(vIn.txtDir.getText());
        pvo.setTelefono_casa(vIn.txtTCasa.getText());
        pvo.setTelefono_movil(vIn.txtTmov.getText());
        pvo.setSalario_base(Double.parseDouble(vIn.txtSalBase.getText()));
        pvo.setBonificacion(Double.parseDouble(vIn.txtBon.getText()));
        pdao.insertarPos(pvo);
        JOptionPane.showMessageDialog(null,"Registro Ingresado");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Debe ingresar Datos para guardar registro");
        }
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vIn.btnInsertar){
            this.insetarEmpleado();
            vIn.dispose();
        }
        if(e.getSource() == vIn.btnCancelar){
            vIn.dispose();
        }
                if(e.getSource() == vIn.btnInsertarPos){
            this.insetarEmpleadoPos();
            vIn.dispose();
        }
    }
    
}
