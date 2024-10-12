/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbd;

import controlador.ControladorInsertar;
import controlador.ControladorMenu;
import controlador.ControladorModificar;
import controlador.ControladorModificarM;
import controlador.ControladorModificarP;
import controlador.ControladorMostrar;
import controlador.ControladorMostrarPos;
import modelo.Conector;
import modelo.ConectorPos;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import vista.FrmModificarM;
import vista.FrmModificarP;
import vista.FrmMostrar;
import vista.FrmMostrarPos;
import vista.Frm_Actualizar;
import vista.Frm_Insertar;
import vista.Frm_Menu;

/**
 *
 * @author jona9
 */
public class ConexionBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConectorPos conector1 = new ConectorPos();
        Conector   conector2 = new Conector();
        conector1.conectar();
        conector2.conectar();
        
        Frm_Menu me = new Frm_Menu();
        FrmMostrar mo = new FrmMostrar();
        FrmMostrarPos mop = new FrmMostrarPos();
        Frm_Insertar vIn = new Frm_Insertar();
        Frm_Actualizar ac = new Frm_Actualizar();
        FrmModificarM mom = new FrmModificarM();
        FrmModificarP mope = new FrmModificarP();
        
        Empleado pvo = new Empleado();
        EmpleadoDAO pdao = new EmpleadoDAO();
        
        ControladorMenu cm = new ControladorMenu(me, mo, mop, vIn,mom,mope);
        ControladorMostrar mos = new ControladorMostrar(mo, pvo, pdao,ac);
        ControladorMostrarPos mopo = new ControladorMostrarPos(mop, pvo, pdao);
        ControladorInsertar in = new ControladorInsertar(vIn, pvo, pdao);
        ControladorModificar moi = new ControladorModificar(pvo, pdao, ac);
        ControladorModificarM mmo = new ControladorModificarM(mom, pvo, pdao, ac);
        ControladorModificarP mmop = new ControladorModificarP(mope, pvo, pdao, ac);
        me.setVisible(true);
        me.setLocationRelativeTo(null);
    }
    
}
