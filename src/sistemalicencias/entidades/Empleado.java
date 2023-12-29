/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemalicencias.entidades;

/**
 *
 * @author calo_
 */
public class Empleado {
    private String nombre;
    private String apellido;
    private String dni;
    private int maxDias;
    private int idEmpleado;
    private String telefono;
    
    public Empleado(){
        
    }

    public Empleado(String nombre, String apellido, String dni, int maxDias, int idEmpleado, int telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.maxDias = maxDias;
        this.idEmpleado = idEmpleado;
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

    public int getMaxDias() {
        return maxDias;
    }

    public void setMaxDias(int maxDias) {
        this.maxDias = maxDias;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
  
}
