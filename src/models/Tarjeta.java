/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import models.Trabajador;
import java.util.Random;
/**
 *
 * @author Jerson
 */
public class Tarjeta {
    
    private long codigo;
    private int clave,monto;
    private Trabajador trabajador;
    private Date fecha;

    public Tarjeta() {
    }

    public Tarjeta(long codigo, int clave, int monto, Trabajador trabajador, Date fecha) {
        this.codigo = codigo;
        this.clave = clave;
        this.monto = monto;
        this.trabajador = trabajador;
        this.fecha = fecha;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    
    //METODO PARA GENERAR 16 NUMEROS PARA LA TARJETA
    public static long generarCodigoTarjeta(){
        long codigo =0;
        
        for (int i=0;i<16;i++){
            int digito = (int)(Math.random()*10);
            codigo = codigo*10+digito;
        }
        
        return codigo;
    }
    
    
    // METODO PARA QUE LA TARJETA SEA MENOR AL DEL SALDO DISPONIBLE
    public boolean validarMontoCompra(int compra){
        return monto >= compra;
    }
    
    // METODO PARA DESCONTAR EL PRECIO DE LA COMPRA A LA TARJETA
    public boolean descontarMontoCompra(int compra){
        if (validarMontoCompra(compra)){
            monto -=compra;
            System.out.println("Compra realizada.");
            System.out.println("Su saldo es:" + monto);
            return true;
        }else{
            return false;
        }
    }
    
    // MOSTRAR INFORMACION DE LA TARJETA
    public void informacionTarjeta(){
        SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-yyyy");
        System.out.println("Codigo: "+ this.codigo);
        System.out.println("*****************************");
        System.out.println("Clave: "+this.clave);
        System.out.println("Monto: " +this.monto);
        System.out.println("Trabajador: "+this.trabajador.getNombre());
        System.out.println("Vigencia: "+ formato.format(fecha));
    }
    
    // METODO DE VIGENCIA DE TARJETA
    public boolean validarVigencia(){
        Date fechaActual = new Date();
        return !fecha.before(fechaActual);
    }
    
}
