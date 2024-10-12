/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author jona9
 */
public class LoggerTransacciones {

    private static final String RUTA_ARCHIVO = "transacciones.txt"; // Ruta del archivo de registro

    // Método para registrar una transacción en el archivo de texto
    public static void registrarTransaccion(String accion, String baseDatos, String dpi) {
        try (FileWriter writer = new FileWriter(RUTA_ARCHIVO, true)) {
            writer.write("Acción: " + accion + ", Base de Datos: " + baseDatos + ", DPI: " + dpi + "\n");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de transacciones: " + e.getMessage());
        }
    }
}

