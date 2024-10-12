/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

//import java.awt.List;
import java.sql.Date;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;// Para usar ArrayList
import java.util.stream.Collectors; // Para usar Collectors


/**
 *
 * @author jona9
 */
public class EmpleadoDAO implements ConsultarDAO{

    @Override
    public void insertar(Empleado p) {
        Conector c = new Conector();
    try {
        c.conectar();
        String consulta = "INSERT INTO empleados (dpi, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, "
                + "direccion, telefono_casa, telefono_movil, salario_base, bonificacion) VALUES ('" + p.getDpi() 
                + "','" + p.getPrimer_nombre() + "','" + p.getSegundo_nombre() + "','" + p.getPrimer_apellido() 
                + "','" + p.getSegundo_apellido() + "','" + p.getDireccion() + "'," + p.getTelefono_casa() 
                + "," + p.getTelefono_movil() + "," + p.getSalario_base() + "," + p.getBonificacion() + ");";
        c.consultas_multiples(consulta);
        LoggerTransacciones1.registrarTransaccion("Insertar", "MySQL", p.getDpi());
    } catch (Exception e) {
        System.out.println("Error al insertar en MySQL: " + e.getMessage());
    } finally {
        c.desconectar();
    }
    }

    @Override
    public void actualizar(Empleado p) {
       Conector c = new Conector();
    try {
        c.conectar();
        String consulta = "UPDATE empleados SET primer_nombre = '" + p.getPrimer_nombre() + "', "
                + "segundo_nombre = '" + p.getSegundo_nombre() + "', primer_apellido = '" + p.getPrimer_apellido() + "', "
                + "segundo_apellido = '" + p.getSegundo_apellido() + "', direccion = '" + p.getDireccion() + "', "
                + "telefono_casa = " + p.getTelefono_casa() + ", telefono_movil = " + p.getTelefono_movil() + ", "
                + "salario_base = " + p.getSalario_base() + ", bonificacion = " + p.getBonificacion() 
                + " WHERE dpi = '" + p.getDpi() + "';";
        c.consultas_multiples(consulta);
        //LoggerTransacciones1.registrarTransaccion("Actualizar", "MySQL", p.getDpi());
        
    } catch (Exception e) {
        System.out.println("Error al actualizar en MySQL: " + e.getMessage());
    } finally {
        c.desconectar();
    }
    }

    @Override
    public void eliminar(Empleado p) {
        Conector c = new Conector();
    try {
        c.conectar();
        String consulta = "DELETE FROM empleados WHERE dpi = '" + p.getDpi() + "';";
        c.consultas_multiples(consulta);
        LoggerTransacciones1.registrarTransaccion("Eliminar", "MySQL", p.getDpi());
    } catch (Exception e) {
        System.out.println("Error al eliminar en MySQL: " + e.getMessage());
    } finally {
        c.desconectar();
    }
    }

    @Override
    public ArrayList<Empleado> consultarTabla() {
         Conector c = new Conector();
        ArrayList<Empleado> info = new ArrayList<>();
        try {
            c.conectar();
            String consulta = "SELECT * FROM empleados ORDER BY primer_nombre;";
            ResultSet rs = c.consulta_datos(consulta);
            while (rs.next()) {
                Empleado cli = new Empleado();
                cli.setDpi(rs.getString(1));
                cli.setPrimer_nombre(rs.getString(2));
                cli.setSegundo_nombre(rs.getString(3));
                cli.setPrimer_apellido(rs.getString(4));
                cli.setSegundo_apellido(rs.getString(5));
                cli.setDireccion(rs.getString(6));
                cli.setTelefono_casa(rs.getString(7));
                cli.setTelefono_movil(rs.getString(8));
                cli.setSalario_base(rs.getDouble(9));
                cli.setBonificacion(rs.getDouble(10));
                cli.setFecha_modificacion(rs.getTimestamp(11));
                info.add(cli);
            }
            //c.desconectar();
        } catch (Exception e) {
            System.out.println("Mensaje Mostrar Datos " + e.getMessage());
        }
        return info;
    }

    @Override
    public ArrayList<Empleado> consultarTablaPos() {
        ConectorPos c = new ConectorPos();
        ArrayList<Empleado> info = new ArrayList<>();
        try {
            c.conectar();
            String consulta = "SELECT * FROM empleados ORDER BY primer_nombre;";
            ResultSet rs = c.consulta_datos(consulta);
            while (rs.next()) {
                Empleado cli = new Empleado();
                cli.setDpi(rs.getString(1));
                cli.setPrimer_nombre(rs.getString(2));
                cli.setSegundo_nombre(rs.getString(3));
                cli.setPrimer_apellido(rs.getString(4));
                cli.setSegundo_apellido(rs.getString(5));
                cli.setDireccion(rs.getString(6));
                cli.setTelefono_casa(rs.getString(7));
                cli.setTelefono_movil(rs.getString(8));
                cli.setSalario_base(rs.getDouble(9));
                cli.setBonificacion(rs.getDouble(10));
                cli.setFecha_modificacion(rs.getTimestamp(11));
                info.add(cli);
            }
            //c.desconectar();
        } catch (Exception e) {
            System.out.println("Mensaje Mostrar Datos " + e.getMessage());
        }
        return info;
    }

    @Override
    public void insertarPos(Empleado p) {
        ConectorPos c = new ConectorPos();  // Conector para PostgreSQL
    try {
        c.conectar();
        String consulta = "INSERT INTO empleados (dpi, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, "
                + "direccion, telefono_casa, telefono_movil, salario_base, bonificacion) VALUES ('" + p.getDpi() 
                + "','" + p.getPrimer_nombre() + "','" + p.getSegundo_nombre() + "','" + p.getPrimer_apellido() 
                + "','" + p.getSegundo_apellido() + "','" + p.getDireccion() + "'," + p.getTelefono_casa() 
                + "," + p.getTelefono_movil() + "," + p.getSalario_base() + "," + p.getBonificacion() + ");";
        c.consultas_multiples(consulta);
        LoggerTransacciones1.registrarTransaccion("Insertar", "PostgreSQL", p.getDpi());
    } catch (Exception e) {
        System.out.println("Error al insertar en PostgreSQL: " + e.getMessage());
    } finally {
        c.desconectar();
    }
    }

    @Override
    public void actualizarPos(Empleado p) {
        ConectorPos c = new ConectorPos();
    try {
        c.conectar();
        String consulta = "UPDATE empleados SET primer_nombre = '" + p.getPrimer_nombre() + "', "
                + "segundo_nombre = '" + p.getSegundo_nombre() + "', primer_apellido = '" + p.getPrimer_apellido() + "', "
                + "segundo_apellido = '" + p.getSegundo_apellido() + "', direccion = '" + p.getDireccion() + "', "
                + "telefono_casa = " + p.getTelefono_casa() + ", telefono_movil = " + p.getTelefono_movil() + ", "
                + "salario_base = " + p.getSalario_base() + ", bonificacion = " + p.getBonificacion() 
                + " WHERE dpi = '" + p.getDpi() + "';";
        c.consultas_multiples(consulta);
        //LoggerTransacciones1.registrarTransaccion("Actualizar", "PostgreSQL", p.getDpi());
    } catch (Exception e) {
        System.out.println("Error al actualizar en PostgreSQL: " + e.getMessage());
    } finally {
        c.desconectar();
    }
    }

    @Override
    public void eliminarPos(Empleado p) {
        ConectorPos c = new ConectorPos();
    try {
        c.conectar();
        String consulta = "DELETE FROM empleados WHERE dpi = '" + p.getDpi() + "';";
        c.consultas_multiples(consulta);
        LoggerTransacciones1.registrarTransaccion("Eliminar", "PostgreSQL", p.getDpi());
    } catch (Exception e) {
        System.out.println("Error al eliminar en PostgreSQL: " + e.getMessage());
    } finally {
        c.desconectar();
    }
    }

//public void sincronizarBasesDeDatos() {
//    // Obtener los datos de ambas bases de datos
//    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
//    //empleadoDAO.actualizarFechaM();
//    //empleadoDAO.actualizarFechaP();
//    ArrayList<Empleado> empleadosMySQL = empleadoDAO.consultarTabla(); // Desde MySQL
//    ArrayList<Empleado> empleadosPostgres = empleadoDAO.consultarTablaPos(); // Desde PostgreSQL
//
//    // Crear listas de DPI para realizar operaciones
//    List<String> dpisMySQL = empleadosMySQL.stream()
//            .map(Empleado::getDpi)
//            .collect(Collectors.toList());
//    List<String> dpisPostgres = empleadosPostgres.stream()
//            .map(Empleado::getDpi)
//            .collect(Collectors.toList());
//    
//    System.out.println(dpisMySQL);
//    System.out.println(dpisPostgres);
//
//    // Sincronización de MySQL a PostgreSQL (Insertar o Actualizar)
//    for (Empleado empleadoMySQL : empleadosMySQL) {
//        boolean encontrado = false;
//
//        for (Empleado empleadoPostgres : empleadosPostgres) {
//            // Comparar DPI para ver si el registro está en ambas bases de datos
//            if (empleadoMySQL.getDpi().equals(empleadoPostgres.getDpi())) {
//                encontrado = true;
//
//                // Si las fechas de modificación son diferentes, sincronizar según la fecha más reciente
//                if (!empleadoMySQL.getFecha_modificacion().equals(empleadoPostgres.getFecha_modificacion())) {
//                    System.out.println(empleadoMySQL.getFecha_modificacion());
//                    System.out.println(empleadoPostgres.getFecha_modificacion());
//                    if (empleadoMySQL.getFecha_modificacion().after(empleadoPostgres.getFecha_modificacion())) {
//                        empleadoDAO.actualizarPos(empleadoMySQL);// Actualizar PostgreSQL con los datos de MySQL
//                        LoggerTransacciones.registrarTransaccion("Actualizar", "PostgreSQL", empleadoMySQL.getDpi());
//                    } else {
//                        empleadoDAO.actualizar(empleadoPostgres); // Actualizar MySQL con los datos de PostgreSQL
//                        LoggerTransacciones.registrarTransaccion("Actualizar", "MySQL", empleadoPostgres.getDpi());
//                    }
//                }
//                break; // Salimos del bucle ya que encontramos el registro
//            }
//        }
//
//        // Si no se encontró el registro en PostgreSQL, ver si fue eliminado manualmente
//        if (!encontrado) {
//            if (dpisPostgres.contains(empleadoMySQL.getDpi())) {
//                // El registro está en MySQL pero no en PostgreSQL, fue eliminado en PostgreSQL
//                empleadoDAO.eliminar(empleadoMySQL); // Eliminar en MySQL también
//                LoggerTransacciones.registrarTransaccion("Eliminar", "MySQL", empleadoMySQL.getDpi());
//            } else {
//                // El registro no está en PostgreSQL, insertarlo en PostgreSQL
//                empleadoDAO.insertarPos(empleadoMySQL);
//                LoggerTransacciones.registrarTransaccion("Insertar", "PostgreSQL", empleadoMySQL.getDpi());
//            }
//        } else {
//            // Si se encontró el registro, eliminarlo de la lista de DPI de PostgreSQL
//            dpisPostgres.remove(empleadoMySQL.getDpi());
//        }
//    }
//
//    // Verificar si algún registro en PostgreSQL debe ser eliminado de MySQL
//    for (Empleado empleadoPostgres : empleadosPostgres) {
//        if (!dpisMySQL.contains(empleadoPostgres.getDpi())) {
//            // El registro está en PostgreSQL pero no en MySQL, eliminarlo de PostgreSQL
//            empleadoDAO.eliminarPos(empleadoPostgres);
//            LoggerTransacciones.registrarTransaccion("Eliminar", "PostgreSQL", empleadoPostgres.getDpi());
//        }
//    }
//}
////ESTE ES EL CORRECTO
//public void sincronizarBasesDeDatos() {
//    // Obtener los datos de ambas bases de datos
//    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
//    ArrayList<Empleado> empleadosMySQL = empleadoDAO.consultarTabla(); // Desde MySQL
//    ArrayList<Empleado> empleadosPostgres = empleadoDAO.consultarTablaPos(); // Desde PostgreSQL
//
//    // Crear listas de DPI para realizar operaciones
//    List<String> dpisMySQL = empleadosMySQL.stream()
//            .map(Empleado::getDpi)
//            .collect(Collectors.toList());
//    List<String> dpisPostgres = empleadosPostgres.stream()
//            .map(Empleado::getDpi)
//            .collect(Collectors.toList());
//
//    // Sincronización de MySQL a PostgreSQL (Insertar o Actualizar)
//    for (Empleado empleadoMySQL : empleadosMySQL) {
//        boolean encontrado = false;
//
//        for (Empleado empleadoPostgres : empleadosPostgres) {
//            // Comparar DPI para ver si el registro está en ambas bases de datos
//            if (empleadoMySQL.getDpi().equals(empleadoPostgres.getDpi())) {
//                encontrado = true;
//
//                // Comparar solo horas y minutos de las fechas de modificación
//                SimpleDateFormat formatoHoraMinuto = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//                
//                String fechaMySQLHoraMin = formatoHoraMinuto.format(empleadoMySQL.getFecha_modificacion());
//                String fechaPostgresHoraMin = formatoHoraMinuto.format(empleadoPostgres.getFecha_modificacion());
//
//                System.out.println("Fecha MySQL (hora y minuto): " + fechaMySQLHoraMin);
//                System.out.println("Fecha PostgreSQL (hora y minuto): " + fechaPostgresHoraMin);
//
//                // Si las fechas de modificación (en horas y minutos) son diferentes, sincronizar
//                if (!fechaMySQLHoraMin.equals(fechaPostgresHoraMin)) {
//                    if (empleadoMySQL.getFecha_modificacion().after(empleadoPostgres.getFecha_modificacion())) {
//                        // Actualizar en PostgreSQL
//                        empleadoDAO.actualizarPos(empleadoMySQL);
//                        LoggerTransacciones.registrarTransaccion("Actualizar", "PostgreSQL", empleadoMySQL.getDpi());
//                    } else {
//                        // Actualizar en MySQL
//                        empleadoDAO.actualizar(empleadoPostgres);
//                        LoggerTransacciones.registrarTransaccion("Actualizar", "MySQL", empleadoPostgres.getDpi());
//                    }
//                }
//                break; // Salimos del bucle ya que encontramos el registro
//            }
//        }
//
//        // Si no se encontró el registro en PostgreSQL, ver si fue eliminado manualmente
//        if (!encontrado) {
//            if (dpisPostgres.contains(empleadoMySQL.getDpi())) {
//                // El registro está en MySQL pero no en PostgreSQL, fue eliminado en PostgreSQL
//                empleadoDAO.eliminar(empleadoMySQL); // Eliminar en MySQL también
//                LoggerTransacciones.registrarTransaccion("Eliminar", "MySQL", empleadoMySQL.getDpi());
//            } else {
//                // El registro no está en PostgreSQL, insertarlo en PostgreSQL
//                empleadoDAO.insertarPos(empleadoMySQL);
//                LoggerTransacciones.registrarTransaccion("Insertar", "PostgreSQL", empleadoMySQL.getDpi());
//            }
//        } else {
//            // Si se encontró el registro, eliminarlo de la lista de DPI de PostgreSQL
//            dpisPostgres.remove(empleadoMySQL.getDpi());
//        }
//    }
//
//    // Verificar si algún registro en PostgreSQL debe ser eliminado de MySQL
//    for (Empleado empleadoPostgres : empleadosPostgres) {
//        if (!dpisMySQL.contains(empleadoPostgres.getDpi())) {
//            // El registro está en PostgreSQL pero no en MySQL, eliminarlo de PostgreSQL
//            empleadoDAO.eliminarPos(empleadoPostgres);
//            LoggerTransacciones.registrarTransaccion("Eliminar", "PostgreSQL", empleadoPostgres.getDpi());
//        }
//    }
//}

    @Override
    public void actualizarFechaM() {
         Conector c = new Conector();
    try {
        c.conectar();
        String consulta = "UPDATE empleados SET fecha_modificacion = NOW();";
        c.consultas_multiples(consulta);
    } catch (Exception e) {
        System.out.println("Error al actualizar en MySQL: " + e.getMessage());
    } finally {
        c.desconectar();
    }
    }

    @Override
    public void actualizarFechaP() {
       ConectorPos c = new ConectorPos();
    try {
        c.conectar();
        String consulta = "UPDATE empleados SET fecha_modificacion = NOW();";
        c.consultas_multiples(consulta);
    } catch (Exception e) {
        System.out.println("Error al actualizar en PostgreSQL: " + e.getMessage());
    } finally {
        c.desconectar();
    }
    }

    @Override
    public boolean existeEnMySQL(String dpi) {
            ArrayList<Empleado> empleados = consultarTabla(); // Obtiene todos los empleados de MySQL
    for (Empleado e : empleados) {
        if (e.getDpi().equals(dpi)) {
            return true;
        }
    }
    return false;
    }

    @Override
    public boolean existeEnPostgres(String dpi) {
         ArrayList<Empleado> empleados = consultarTablaPos(); // Obtiene todos los empleados de PostgreSQL
    for (Empleado e : empleados) {
        if (e.getDpi().equals(dpi)) {
            return true;
        }
    }
    return false;
    }

    @Override
    public Empleado obtenerPorDpiMySQL(String dpi) {
        ArrayList<Empleado> empleados = consultarTabla(); // Obtiene todos los empleados de MySQL
    for (Empleado e : empleados) {
        if (e.getDpi().equals(dpi)) {
            return e;
        }
    }
    return null; // Retorna null si no lo encuentra
    }

    @Override
    public Empleado obtenerPorDpiPostgres(String dpi) {
         ArrayList<Empleado> empleados = consultarTablaPos(); // Obtiene todos los empleados de PostgreSQL
    for (Empleado e : empleados) {
        if (e.getDpi().equals(dpi)) {
            return e;
        }
    }
    return null; // Retorna null si no lo encuentra
    }

    @Override
    public void eliminarM(String dpi) {
                Conector c = new Conector();
    try {
        c.conectar();
        String consulta = "DELETE FROM empleados WHERE dpi = '" + dpi + "';";
        c.consultas_multiples(consulta);
    } catch (Exception e) {
        System.out.println("Error al eliminar en MySQL: " + e.getMessage());
    } finally {
        c.desconectar();
    }
    }

    @Override
    public void eliminarP(String dpi) {
                ConectorPos c = new ConectorPos();
    try {
        c.conectar();
        String consulta = "DELETE FROM empleados WHERE dpi = '" + dpi + "';";
        c.consultas_multiples(consulta);
    } catch (Exception e) {
        System.out.println("Error al eliminar en PostgreSQL: " + e.getMessage());
    } finally {
        c.desconectar();
    }
    }

   
    
}
