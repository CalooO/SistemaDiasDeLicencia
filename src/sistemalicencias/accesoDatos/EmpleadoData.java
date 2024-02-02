/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemalicencias.accesoDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sistemalicencias.entidades.Empleado;

/**
 *
 * @author calo_
 */
public class EmpleadoData {
    private Connection con=null;

    public EmpleadoData() {
        con=conexion.getConexion();
    }
    
    public void guardarEmpleado(Empleado empleado){
        String sql="Insert into empleado (apellido, nombre, dni, telefono, fechaIngreso, diasMax, estado) "
                + "Values (?,?,?,?,?,?,1)";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, empleado.getApellido());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getDni());
            ps.setString(4, empleado.getTelefono());
            ps.setDate(5, new Date(empleado.getFechaIngreso().getTime()));
            ps.setInt(6, empleado.getDiasMax());
            //ps.setDate(4, empleado.getFechaIngreso());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                //cliente.setIdCliente(rs.getInt(1));
                 JOptionPane.showMessageDialog(null,"Empleado guardado.");
            } else {
                JOptionPane.showMessageDialog(null,"Empleado no guardado.");
            }
            ps.close();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al acceder a la tabla de los empleados "+ex.getMessage());
        }
    }
    
    public ArrayList<Empleado> listarEmpleado (){
        String sql="select * from empleado where estado = 1";
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
           while(rs.next()){
                Empleado empleado = new Empleado();
                empleado.setApellido(rs.getString("apellido"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setDni(rs.getString("dni"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setFechaIngreso(rs.getDate("fechaIngreso"));
                empleado.setDiasMax(rs.getInt("diasMax"));
                empleado.setEstado(rs.getInt("estado"));
                
                listaEmpleados.add(empleado);
           }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla de empleados "+ex.getMessage());
        }
        return listaEmpleados;
    }
    
    
    public ArrayList<Empleado> listarEmpleadoPorDni(String dni) {
    PreparedStatement ps = null;
    String sql = "SELECT * FROM empleado WHERE dni LIKE ?";
    ArrayList<Empleado> listaEmpleado = new ArrayList<>();

    try {
        dni = dni + "%";
        ps = con.prepareStatement(sql);
        ps.setString(1, dni);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Empleado empleado = new Empleado();
            empleado.setApellido(rs.getString("apellido"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setDni(rs.getString("dni"));
            empleado.setTelefono(rs.getString("telefono"));
            empleado.setFechaIngreso(rs.getDate("fechaIngreso"));
            empleado.setDiasMax(rs.getInt("diasMax"));
            empleado.setEstado(rs.getInt("estado"));
            listaEmpleado.add(empleado);
        }
        
        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de empleados " + ex.getMessage());
    }

    return listaEmpleado;
}
     
     public void actualizarDiasMax(String dni, int nuevosDiasMax) {
        String sql = "UPDATE empleado SET diasMax = ? WHERE dni = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, nuevosDiasMax);
            ps.setString(2, dni);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
            } else {
                JOptionPane.showMessageDialog(null, "Error, la licencia no fue generada.");
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al ingresas a la tabla de empleados: " + ex.getMessage());
        }
    }

    public void cambiarEstado(int estado, String dni){
        String sql = "UPDATE empleado SET estado = ? WHERE dni = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, estado);
            ps.setString(2, dni);
            
            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
            } else {
                JOptionPane.showMessageDialog(null, "Error, no fue posible cambiar el estado.");
            }
            
            ps.close();
        } catch (SQLException ex){
            System.out.println("Error al ingresas a la tabla de empleados: " + ex.getMessage());
        }
    }
     
    public ArrayList<Empleado> buscarEmpleadoExistente(String dni) {
    PreparedStatement ps = null;
    String sql = "SELECT * FROM empleado WHERE dni LIKE ?";
    ArrayList<Empleado> listaEmpleado = new ArrayList<>();

    try {
        ps = con.prepareStatement(sql);
        ps.setString(1, dni);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Empleado empleado = new Empleado();
            empleado.setApellido(rs.getString("apellido"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setDni(rs.getString("dni"));
            empleado.setTelefono(rs.getString("telefono"));
            empleado.setFechaIngreso(rs.getDate("fechaIngreso"));
            empleado.setDiasMax(rs.getInt("diasMax"));
            empleado.setEstado(rs.getInt("estado"));
            listaEmpleado.add(empleado);
        }
        
        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de empleados " + ex.getMessage());
    }

    return listaEmpleado;
}

    public void modificarEmpleado(Empleado empleado, String dni){
        String sql = "UPDATE empleado SET apellido=?, nombre=?, telefono=? WHERE dni LIKE ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, empleado.getApellido());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getTelefono());
            ps.setString(4, dni);
            
            int todoCorrecto = ps.executeUpdate();
            if(1==todoCorrecto){
                 JOptionPane.showMessageDialog(null,"Cliente modificado.");
            } else {
                JOptionPane.showMessageDialog(null,"Cliente no modificado.");
            }
            ps.close();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla de empleados");
        }
    }
    
    public Empleado buscarEmpleadoUnico(String dni) {
    String sql = "SELECT * FROM empleado WHERE dni LIKE ?";
    Empleado empleado = null;  

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, dni);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            empleado = new Empleado();
            empleado.setApellido(rs.getString("apellido"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setDni(rs.getString("dni"));
            empleado.setTelefono(rs.getString("telefono"));
            empleado.setFechaIngreso(rs.getDate("fechaIngreso"));
            empleado.setDiasMax(rs.getInt("diasMax"));
            empleado.setEstado(rs.getInt("estado"));
        }

        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de empleados " + ex.getMessage());
    }

    return empleado;
}
    
}

