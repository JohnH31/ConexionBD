/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jona9
 */
public class Transaccion {
    private String operacion;
    private String base_datos;
    private String dpi;
    
    public Transaccion() {

    }

    public Transaccion(String operacion, String base_datos, String dpi) {
        this.operacion = operacion;
        this.base_datos = base_datos;
        this.dpi = dpi;
    }
    
    

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getBase_datos() {
        return base_datos;
    }

    public void setBase_datos(String base_datos) {
        this.base_datos = base_datos;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }
    
    
}
