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
public class DetalleLicencia {
    private int idDetalleVenta, diasRestantes;
    private Licencia licencia;
    private int dias dias;
    
    public DetalleLicencia(){
        
    }

    public DetalleLicencia(int idDetalleVenta, int diasRestantes, Licencia licencia) {
        this.idDetalleVenta = idDetalleVenta;
        this.diasRestantes = diasRestantes;
        this.licencia = licencia;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getDiasRestantes() {
        return diasRestantes;
    }

    public void setDiasRestantes(int diasRestantes) {
        this.diasRestantes = diasRestantes;
    }

    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }
    
    
}
