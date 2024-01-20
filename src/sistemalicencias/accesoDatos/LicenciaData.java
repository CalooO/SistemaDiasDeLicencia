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
import sistemalicencias.entidades.*;
import sistemalicencias.accesoDatos.EmpleadoData;

/**
 *
 * @author calo_
 */
public class LicenciaData {
    private Connection con=null;
    private EmpleadoData ed = new EmpleadoData();

    public LicenciaData() {
        con=conexion.getConexion();
    }
    
    public void guardarLicencia(Licencia licencia){
        String sql = "INSERT INTO licencia (FechaLicencia, dni) VALUES (?, ?)";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             ps.setDate(1, Date.valueOf(licencia.getFechaLicencia()));
             ps.setString(2, licencia.getDni());
             ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                 JOptionPane.showMessageDialog(null,"Licencia registrada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null,"Error, no se pudo registrar la licencia.");
            }
            ps.close();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error, no se pudo registrar la licencia."+ex.getMessage());
        }
    }
    
    /*public ArrayList<Licencia> listarLicencias (int idEmpleado){
        String sql = "Select idCliente, fechaLicencia from licencia where idCliente=?";
        ArrayList<Licencia> listaL = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, listaL.get(idEmpleado).getIdLicencia());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Licencia licencia = new Licencia();
                licencia.setIdLicencia(rs.getInt("idLicencia"));
                licencia.setFechaLicencia(rs.getDate("fechaLicencia").toLocalDate());
                for (Licencia lista : licenciaData.listarLicencia()) {
                    if (rs.getInt("idCliente") == cliente.getIdCliente()) {
                        venta.setCliente(cliente);
                    }
                }

                listaL.add(licencia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de venta " + ex.getMessage());
        }
        return listaL;
    }*/
    
    public ArrayList<Licencia> listarLicencias(int idEmpleado) {
    String sql = "SELECT idLicencia, fechaLicencia FROM licencia WHERE dni=?";
    ArrayList<Licencia> listaL = new ArrayList<>();
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idEmpleado);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Licencia licencia = new Licencia();
            licencia.setIdLicencia(rs.getInt("idLicencia"));
            licencia.setFechaLicencia(rs.getDate("fechaLicencia").toLocalDate());
            
            Empleado empleado = new Empleado();
            empleado.setIdEmpleado(idEmpleado);
            
            licencia.setEmpleado(empleado);
            
            listaL.add(licencia);
        }
        
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de licencia " + ex.getMessage());
    }
    
    return listaL;
    }
    
    public ArrayList<Licencia> listarLicenciasPorDNI(String dniEmpleado) {
    String sql = "SELECT l.idLicencia, l.fechaLicencia FROM licencia l INNER JOIN empleado e ON l.idEmpleado = e.idEmpleado WHERE e.dni=?";
    ArrayList<Licencia> listaL = new ArrayList<>();
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, dniEmpleado);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Licencia licencia = new Licencia();
            licencia.setIdLicencia(rs.getInt("idLicencia"));
            licencia.setFechaLicencia(rs.getDate("fechaLicencia").toLocalDate());
            
            Empleado empleado = new Empleado();
            empleado.setDni(dniEmpleado);
            
            licencia.setEmpleado(empleado);
            
            listaL.add(licencia);
        }
        
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de licencia " + ex.getMessage());
    }
    
    return listaL;
}
}
