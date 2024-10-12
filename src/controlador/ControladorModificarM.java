/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.FrmMostrar;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import vista.FrmModificarM;
import vista.Frm_Actualizar;

/**
 *
 * @author John
 */
public class ControladorModificarM implements WindowListener,MouseListener {

    FrmModificarM vista = new FrmModificarM();
    
    Empleado pvo = new Empleado();
    EmpleadoDAO pdao = new EmpleadoDAO();
    Frm_Actualizar ac = new Frm_Actualizar();
    
    public ControladorModificarM(FrmModificarM vista, Empleado pvo, EmpleadoDAO pdao,  Frm_Actualizar ac) {
        this.vista = vista;
        this.pvo = pvo;
        this.pdao = pdao;
        this.ac = ac;

        vista.addWindowListener(this);
        vista.tblMostrar.addMouseListener(this);
    }

    private void mostrar() {
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("dpi");
        m.addColumn("primer_nombre");
        m.addColumn("segundo_nombre");
        m.addColumn("primer_apellido");
        m.addColumn("segundo_apellido");
        m.addColumn("direccion");
        m.addColumn("telefono_casa");
        m.addColumn("telefono_movil");
        m.addColumn("salario_base");
        m.addColumn("bonificacion");

        for (Empleado pvo : pdao.consultarTabla()) {
            m.addRow(new Object[]{pvo.getDpi(),pvo.getPrimer_nombre(),pvo.getSegundo_nombre(),pvo.getPrimer_apellido(),pvo.getSegundo_apellido(),pvo.getDireccion(),pvo.getTelefono_casa(),pvo.getTelefono_movil(),pvo.getSalario_base(),pvo.getBonificacion()});
        }
        vista.tblMostrar.setModel(m);
    }
    

    private void datos() {
        int row;
        row = vista.tblMostrar.getSelectedRow();
        pvo.setDpi(vista.tblMostrar.getValueAt(row, 0).toString());
        ac.txtid.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 0)));
        ac.txtPNom.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 1)));
        ac.txtSNom.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 2)));
        ac.txtPApe.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 3)));
        ac.txtSApe.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 4)));
        ac.txtDir.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 5)));
        ac.txtTCasa.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 6)));
        ac.txtTmov.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 7)));
        ac.txtSalBase.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 8)));
        ac.txtBon.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 9)));

    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.mostrar();
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
        this.mostrar();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        datos();
        ac.setVisible(true); // Muestra el formulario de actualización
        ac.setLocationRelativeTo(null); // Centra el formulario en pantalla
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        ac.setVisible(true);
//        ac.setLocationRelativeTo(null);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
   
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
    }

    @Override
    public void mouseExited(MouseEvent e) {
    
    }

}
