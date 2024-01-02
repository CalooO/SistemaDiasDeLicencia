/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemalicencias.accesoDatos;

import java.sql.Connection;

/**
 *
 * @author calo_
 */
public class EmpleadoData {
    private Connection con=null;

    public EmpleadoData() {
        con=conexion.getConexion();
    }
    
    
    
}
