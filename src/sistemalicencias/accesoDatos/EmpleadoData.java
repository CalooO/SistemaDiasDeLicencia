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
    
    
    public ArrayList<Empleado> listarClientePorApellidoYdni (String dni, String ape){
        PreparedStatement ps=null;
        String sql=null;
        ArrayList<Empleado> listaEmpleado=new ArrayList<>();
        int opc =0;
        
        if(!dni.isEmpty() && !ape.isEmpty()){
            opc=3;                                                                                                          
        }else if(!ape.isEmpty()){
            opc=2;                                                                                                        
        }else if(!dni.isEmpty()){
            opc=1;                                                                                                   
        }
        try {
        switch(opc){
            case 1:
                sql="select * from empleado where dni LIKE ?";
                dni=dni+"%";
                ps=con.prepareStatement(sql);
                ps.setString(1, dni);break;
            case 2:
                sql="select * from empleado where apellido LIKE ?";
                ape=ape+"%";
                ps=con.prepareStatement(sql);
                ps.setString(1, ape);break;
            case 3:
                sql="select * from empleado where dni LIKE ? and apellido LIKE ?";
                dni=dni+"%";
                ape=ape+"%";
                ps=con.prepareStatement(sql);
                ps.setString(1, dni);
                ps.setString(2, ape);
                break;
                    }

                ResultSet rs=ps.executeQuery();
                
           while(rs.next()){
                Empleado empleado=new Empleado();
                empleado.setApellido(rs.getString("apellido"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setDni(rs.getString("dni")); //??
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setFechaIngreso(rs.getDate("fechaIngreso"));
                empleado.setDiasMax(rs.getInt("diasMax"));
                empleado.setEstado(rs.getInt("estado"));
                listaEmpleado.add(empleado);
           }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla de empleados "+ex.getMessage());
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
                
                JOptionPane.showMessageDialog(null, "La licencia fue generada exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error, la licencia no fue generada.");
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error al ingresas a la tabla de empleados: " + ex.getMessage());
        }
    }

    
}