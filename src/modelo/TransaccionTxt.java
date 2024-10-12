/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jona9
 */


public class TransaccionTxt {
    
    public static List<Transaccion> leerTransaccionesTxt(String rutaArchivo) {
        List<Transaccion> transacciones = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            // Leer cada línea del archivo y procesarla
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(","); // Separar por comas
                if (partes.length == 3) {
                    String operacion = partes[0];
                    String base_datos = partes[1];
                    String dpi = partes[2];

                    // Crear una nueva transacción con los datos leídos
                    transacciones.add(new Transaccion(operacion, base_datos, dpi));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return transacciones;
    }
}

