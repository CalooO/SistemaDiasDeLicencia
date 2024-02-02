/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemalicencias.entidades;

import java.util.Date;

/**
 *
 * @author calo_
 */
public class DetalleLicencia {
    private int idDetalleVenta, diasPedidos, idLicencia;
    private Date fechaLicencia;
    private Date fechaInicial;
    private Date fechaFinal;
    private String dni;


    public DetalleLicencia(){
        
    }

    public DetalleLicencia(int idDetalleVenta, int diasPedidos, Date fechaLicencia, Date fechaInicial, Date fechaFinal, int idLicencia, String dni) {
        this.idDetalleVenta = idDetalleVenta;
        this.diasPedidos = diasPedidos;
        this.fechaLicencia = fechaLicencia;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.idLicencia = idLicencia;
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

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getDiasPedidos() {
        return diasPedidos;
    }

    public void setDiasPedidos(int diasPedidos) {
        this.diasPedidos = diasPedidos;
    }

    public Date getFechaLicencia() {
        return fechaLicencia;
    }

    public void setFechaLicencia(Date fechaLicencia) {
        this.fechaLicencia = fechaLicencia;
    }


    
    
}
