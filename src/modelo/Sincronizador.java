/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author jona9
 */
import java.util.*;
import java.util.stream.Collectors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sincronizador {

    // Ruta del archivo de transacciones
    private static final String RUTA_TRANSACCIONES = "transaccion.txt";

    // Método para sincronizar las bases de datos a partir del archivo de transacciones
    public void sincronizarBasesDeDatos() {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        Empleado emplea = new Empleado();
//        empleadoDAO.actualizarFechaM();
//        empleadoDAO.actualizarFechaP();
        ArrayList<Empleado> empleadosMySQL = empleadoDAO.consultarTabla(); // Desde MySQL
        ArrayList<Empleado> empleadosPostgres = empleadoDAO.consultarTablaPos(); // Desde PostgreSQL

        // Crear listas de DPI para realizar operaciones
        List<String> dpisMySQL = empleadosMySQL.stream()
            .map(Empleado::getDpi)
            .collect(Collectors.toList());
        List<String> dpisPostgres = empleadosPostgres.stream()
            .map(Empleado::getDpi)
            .collect(Collectors.toList());

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_TRANSACCIONES))) {
            String linea;
            
            for (Empleado empleadoMySQL : empleadosMySQL) {
        boolean encontrado = false;

        for (Empleado empleadoPostgres : empleadosPostgres) {
            // Comparar DPI para ver si el registro está en ambas bases de datos
            if (empleadoMySQL.getDpi().equals(empleadoPostgres.getDpi())) {
                encontrado = true;

                // Comparar solo horas y minutos de las fechas de modificación
                SimpleDateFormat formatoHoraMinuto = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                
                String fechaMySQLHoraMin = formatoHoraMinuto.format(empleadoMySQL.getFecha_modificacion());
                String fechaPostgresHoraMin = formatoHoraMinuto.format(empleadoPostgres.getFecha_modificacion());

//                System.out.println("Fecha MySQL (hora y minuto): " + fechaMySQLHoraMin);
//                System.out.println("Fecha PostgreSQL (hora y minuto): " + fechaPostgresHoraMin);

                // Si las fechas de modificación (en horas y minutos) son diferentes, sincronizar
                if (!fechaMySQLHoraMin.equals(fechaPostgresHoraMin)) {
                    if (empleadoMySQL.getFecha_modificacion().after(empleadoPostgres.getFecha_modificacion())) {
                        // Actualizar en PostgreSQL
                        empleadoDAO.actualizarPos(empleadoMySQL);
                        LoggerTransacciones.registrarTransaccion("Actualizar", "PostgreSQL", empleadoMySQL.getDpi());
                    } else {
                        // Actualizar en MySQL
                        empleadoDAO.actualizar(empleadoPostgres);
                        LoggerTransacciones.registrarTransaccion("Actualizar", "MySQL", empleadoPostgres.getDpi());
                    }
                }
                break; // Salimos del bucle ya que encontramos el registro
            }
        }
            }

            // Leer el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                // Supongamos que cada línea tiene el formato: "operacion,baseDatos,dpi"
                String[] valores = linea.split(",");

                if (valores.length == 3) {
                    String operacion = valores[0];  // 'Insertar', 'Eliminar' o 'Actualizar'
                    String baseDatos = valores[1];  // 'MySQL' o 'PostgreSQL'
                    String dpi = valores[2];        // DPI del empleado
                    emplea.setDpi(dpi);
                    // Usar un switch-case para manejar las operaciones
                    switch (operacion) {
                        case "Insertar":
                            if (baseDatos.equals("MySQL")) {
                                if (!empleadoDAO.existeEnPostgres(dpi)) {
                                    Empleado empleado = empleadoDAO.obtenerPorDpiMySQL(dpi);
                                    empleadoDAO.insertarPos(empleado);
                                    LoggerTransacciones1.eliminarRegistroPorDpi(dpi);
                                    LoggerTransacciones.registrarTransaccion("Insertar", "PostgreSQL", dpi);
                                    //System.out.println("Insertado en PostgreSQL: " + dpi);
                                } else {
                                    System.out.println("El empleado ya existe en PostgreSQL: " + dpi);
                                }
                            } else if (baseDatos.equals("PostgreSQL")) {
                                if (!empleadoDAO.existeEnMySQL(dpi)) {
                                    Empleado empleado = empleadoDAO.obtenerPorDpiPostgres(dpi);
                                    empleadoDAO.insertar(empleado);
                                    LoggerTransacciones1.eliminarRegistroPorDpi(dpi);
                                    LoggerTransacciones.registrarTransaccion("Insertar", "MySQL", dpi);
                                    //System.out.println("Insertado en MySQL: " + dpi);
                                } else {
                                    System.out.println("El empleado ya existe en MySQL: " + dpi);
                                }
                            }
                            break;

                        case "Eliminar":
                            if (baseDatos.equals("MySQL")) {
                                if (empleadoDAO.existeEnPostgres(dpi)) {
                                    
                                    empleadoDAO.eliminarP(dpi);
                                    LoggerTransacciones1.eliminarRegistroPorDpi(dpi);
                                    LoggerTransacciones.registrarTransaccion("Eliminar", "PostgreSQL", dpi);
                                    //System.out.println("Eliminado de PostgreSQL: " + dpi);
                                } else {
                                    System.out.println("El empleado no existe en PostgreSQL: " + dpi);
                                }
                            } else if (baseDatos.equals("PostgreSQL")) {
                                if (empleadoDAO.existeEnMySQL(dpi)) {
                                    empleadoDAO.eliminarM(emplea.getDpi());
                                    LoggerTransacciones1.eliminarRegistroPorDpi(dpi);
                                    LoggerTransacciones.registrarTransaccion("Eliminar", "MySQL", dpi);
                                    //System.out.println("Eliminado de MySQL: " + dpi);
                                } else {
                                    System.out.println("El empleado no existe en MySQL: " + dpi);
                                }
                            }
                            break;
                        default:
                            System.out.println("Operación desconocida: " + operacion);
                    }
                } else {
                    System.out.println("Formato de línea incorrecto: " + linea);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Verifica si una transacción ya fue procesada
    private boolean registroProcesado(List<Transaccion> transacciones, String dpi, String operacion, String baseDatos) {
        return transacciones.stream()
                .anyMatch(t -> t.getDpi().equals(dpi) && t.getOperacion().equals(operacion) && t.getBase_datos().equals(baseDatos));
    }
}

