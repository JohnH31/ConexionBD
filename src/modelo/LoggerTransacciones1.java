/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jona9
 */
public class LoggerTransacciones1 {

    private static final String RUTA_ARCHIVO = "transaccion.txt"; // Ruta del archivo de registro

    // Método para registrar una transacción en el archivo de texto
    public static void registrarTransaccion(String accion, String baseDatos, String dpi) {
        try (FileWriter writer = new FileWriter(RUTA_ARCHIVO, true)) {
            writer.write(accion + "," + baseDatos + "," + dpi + "\n");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de transacciones: " + e.getMessage());
        }
    }
    
        // Método para eliminar un registro por DPI en el archivo de transacciones
    public static void eliminarRegistroPorDpi(String dpi) {
        File archivo = new File(RUTA_ARCHIVO);
        List<String> registrosRestantes = new ArrayList<>();

        // Leer todos los registros y filtrar el que no contiene el DPI que queremos eliminar
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Si la línea no contiene el DPI, la mantenemos
                if (!linea.contains(dpi)) {
                    registrosRestantes.add(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de transacciones: " + e.getMessage());
        }

        // Sobrescribir el archivo sin el registro eliminado
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String registro : registrosRestantes) {
                bw.write(registro);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de transacciones: " + e.getMessage());
        }
    }
}

