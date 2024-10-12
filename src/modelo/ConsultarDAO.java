/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author jona9
 */
public interface ConsultarDAO {
        public void insertar(Empleado p);
        public void insertarPos(Empleado p);
    public void actualizar(Empleado p);
    public void actualizarPos(Empleado p);
    public void eliminar(Empleado p);
    public void eliminarPos(Empleado p);
        public void eliminarM(String dpi);
    public void eliminarP(String dpi);
    public boolean existeEnMySQL(String dpi);
    public boolean existeEnPostgres(String dpi);
    public Empleado obtenerPorDpiMySQL(String dpi);
    public Empleado obtenerPorDpiPostgres(String dpi);
    public ArrayList<Empleado> consultarTabla();
    public ArrayList<Empleado> consultarTablaPos();
    public void actualizarFechaM();
    public void actualizarFechaP();
}
