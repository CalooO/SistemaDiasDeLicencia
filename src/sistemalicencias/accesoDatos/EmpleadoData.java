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
        String sql="Insert into empleado (apellido, nombre, dni, telefono, fechaIngreso, estado) "
                + "Values (?,?,?,?,?,1)";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, empleado.getApellido());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getDni());
            ps.setString(4, empleado.getTelefono());
            ps.setDate(5, new Date(empleado.getFechaIngreso().getTime()));
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
    
}
