/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Timestamp;

/**
 *
 * @author jona9
 */
public class Empleado {
    String dpi;
    String primer_nombre;
    String segundo_nombre;
    String primer_apellido;
    String segundo_apellido;
    String direccion;
    String telefono_casa;
    String telefono_movil;
    double salario_base;
    double bonificacion;
    Timestamp fecha_modificacion;
    
    public Empleado(){
    }
    
    @Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Empleado empleado = (Empleado) obj;
    return dpi.equals(empleado.dpi) &&
            primer_nombre.equals(empleado.primer_nombre) &&
            segundo_nombre.equals(empleado.segundo_nombre) &&
            primer_apellido.equals(empleado.primer_apellido) &&
            segundo_apellido.equals(empleado.segundo_apellido) &&
            direccion.equals(empleado.direccion) &&
            telefono_casa.equals(empleado.telefono_casa) &&
            telefono_movil.equals(empleado.telefono_movil) &&
            salario_base == empleado.salario_base &&
            bonificacion == empleado.bonificacion &&
            fecha_modificacion.equals(empleado.getFecha_modificacion());
}

    public Empleado(String dpi, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido, String direccion, String telefono_casa, String telefono_movil, double salario_base, double bonificacion) {
        this.dpi = dpi;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.direccion = direccion;
        this.telefono_casa = telefono_casa;
        this.telefono_movil = telefono_movil;
        this.salario_base = salario_base;
        this.bonificacion = bonificacion;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono_casa() {
        return telefono_casa;
    }

    public void setTelefono_casa(String telefono_casa) {
        this.telefono_casa = telefono_casa;
    }

    public String getTelefono_movil() {
        return telefono_movil;
    }

    public void setTelefono_movil(String telefono_movil) {
        this.telefono_movil = telefono_movil;
    }

    public double getSalario_base() {
        return salario_base;
    }

    public void setSalario_base(double salario_base) {
        this.salario_base = salario_base;
    }

    public double getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(double bonificacion) {
        this.bonificacion = bonificacion;
    }

    public Timestamp getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Timestamp fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }
    
    
    
    
}
