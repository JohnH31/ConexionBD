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

/**
 *
 * @author John
 */
public class ControladorMostrar implements WindowListener,MouseListener {

    FrmMostrar vista = new FrmMostrar();
    
    Empleado pvo = new Empleado();
    EmpleadoDAO pdao = new EmpleadoDAO();
    
    public ControladorMostrar(FrmMostrar vista, Empleado pvo, EmpleadoDAO pdao) {
        this.vista = vista;
        this.pvo = pvo;
        this.pdao = pdao;

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
    
        private void eliminar() {

        int row = vista.tblMostrar.getSelectedRow();
        pvo.setDpi(vista.tblMostrar.getValueAt(row, 0).toString());
        int men = JOptionPane.showConfirmDialog(null, "Estas seguro que deceas eliminar el registro?", "pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (men == JOptionPane.YES_OPTION) {
            try {
                pdao.eliminar(pvo);
                pvo.setDpi(String.valueOf(row));
            } catch (Exception e) {
                System.out.println("Mensaje eliminar" + e.getMessage());
            }
        }
    }

//    private void datos() {
//        int row;
//        row = vista.tblMostrar.getSelectedRow();
//        pvo.setId(Integer.parseInt(vista.tblMostrar.getValueAt(row, 0).toString()));
//        ac.txtid.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 0)));
//        ac.txtNit.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 1)));
//        ac.txtNom.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 2)));
//        ac.txtApe.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 3)));
//        ac.txtDir.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 4)));
//        ac.txtTel.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 5)));
//        ac.txtFec.setText(String.valueOf(vista.tblMostrar.getValueAt(row, 6)));
//
//    }

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
        this.eliminar();
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
