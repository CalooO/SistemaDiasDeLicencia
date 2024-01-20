/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemalicencias.entidades;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author calo_
 */
public class Licencia {
    private int idLicencia;
    private Empleado empleado;
    private LocalDate fechaLicencia;
    private String dni;
    
    public Licencia(){
        
    }

    public Licencia(int idLicencia, Empleado empleado, LocalDate fechaLicencia, String dni) {
        this.idLicencia = idLicencia;
        this.empleado = empleado;
        this.fechaLicencia = fechaLicencia;
        this.dni = dni;
       
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(int idLicencia) {
        this.idLicencia = idLicencia;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalDate getFechaLicencia() {
        return fechaLicencia;
    }

    public void setFechaLicencia(LocalDate fechaLicencia) {
        this.fechaLicencia = fechaLicencia;
    }
    
    
}
