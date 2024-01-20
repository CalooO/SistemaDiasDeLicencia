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
import java.util.List;
import javax.swing.JOptionPane;
import sistemalicencias.entidades.DetalleLicencia;
import sistemalicencias.entidades.Empleado;
import sistemalicencias.entidades.Licencia;

/**
 *
 * @author calo_
 */
public class DetalleLicenciaData  {
    private Connection con=null;
    private EmpleadoData ed = new EmpleadoData();
    private Empleado empleado = new Empleado();
    private LicenciaData ld = new LicenciaData();
    private Licencia licencia = new Licencia();
    
    public DetalleLicenciaData() {
        con=conexion.getConexion();
    }  
    
    public void guardarDetalleLicencia(DetalleLicencia dl){
        String sql = "INSERT into detallelicencia (diasPedidos, inicioLicencia, finLicencia, dni) VALUES (?,?,?,?) ";
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dl.getDiasPedidos());
            java.util.Date fechaInicialUtil = dl.getFechaInicial();
            java.sql.Date fechaInicialSql = new java.sql.Date(fechaInicialUtil.getTime());
            ps.setDate(2, fechaInicialSql);

            java.util.Date fechaFinalUtil = dl.getFechaFinal();
            java.sql.Date fechaFinalSql = new java.sql.Date(fechaFinalUtil.getTime());
            ps.setDate(3, fechaFinalSql);
            
            ps.setString(4, dl.getDni());

            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                
            } else {
                
            }
            ps.close();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al acceder a la tabla de los empleados "+ex.getMessage());
        }
    }
    
    public ArrayList listarDetalles(String dni){
        String sql = "SELECT * FROM detallelicencia WHERE dni = ?";
        ArrayList<DetalleLicencia> detallel = new ArrayList<>();
        
        
    try {
        PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        dni = dni + "%";
        ps = con.prepareStatement(sql);
        ps.setString(1, dni);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            DetalleLicencia dl = new DetalleLicencia();
            dl.setDiasPedidos(rs.getInt("diasPedidos"));
            dl.setFechaInicial(rs.getDate("inicioLicencia"));
            dl.setFechaFinal(rs.getDate("FinLicencia"));
            dl.setDni(rs.getString("dni"));
            
            detallel.add(dl);
        }
        
        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de empleados " + ex.getMessage());
    }
    return detallel;
    }
    
    /*
    public List<DetalleLicenciaData> listarDetalleLicenciaPorDni(){
        
         String sql = "SELECT idLicencia, diasPedidos, inicioLicencia, finLicencia FROM detalleventa";

        
        ArrayList<DetalleLicenciaData> listaDetalleVenta = new ArrayList<>();
        
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                DetalleVenta detalleVenta = new DetalleVenta();
                
                detalleVenta.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                detalleVenta.setCantidad(rs.getInt("cantidad"));
                detalleVenta.setPrecioVenta(rs.getDouble("precioVenta"));
                for(Producto producto:prodData.listarProducto()){
                    
                    if(rs.getInt("idProducto") == producto.getIdProducto())
                        detalleVenta.setProducto(producto);
                }
                for(Venta venta:ventaData.listarVentas()){
                    
                    if(rs.getInt("idVenta") == venta.getIdVenta())
                        detalleVenta.setVenta(venta);
                }
                
                listaDetalleVenta.add(detalleVenta);
            }
            ps.close();
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Error al acceder a la "
                    + "tabla de detalles de venta " + ex.getMessage());
        }
        
        return listaDetalleVenta;
    }*/
    
    }

