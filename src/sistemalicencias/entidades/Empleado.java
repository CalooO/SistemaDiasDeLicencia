/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemalicencias.entidades;

import java.time.LocalDate;

/**
 *
 * @author calo_
 */
public class Empleado {
    private String nombre;
    private String apellido;
    private String dni;
    private int idEmpleado;
    private String telefono;
    private LocalDate fechaIngreso;
    
    public Empleado(){
        
    }

    public Empleado(String nombre, String apellido, String dni, int idEmpleado, String telefono, LocalDate fechaIngreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.idEmpleado = idEmpleado;
        this.telefono = telefono;
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
  
}