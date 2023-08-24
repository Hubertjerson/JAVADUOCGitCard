/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Jerson
 */
public class Trabajador {
    private int rut;
    private String nombre;
    private char dv;

    public Trabajador() {
    }

    public Trabajador(int rut, String nombre, char dv) {
        this.rut = rut;
        this.nombre = nombre;
        this.dv = dv;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getDv() {
        return dv;
    }

    public void setDv(char dv) {
        this.dv = dv;
    }
    

    // METODO PARA LA CLAVE DE TRABAJADOR SEA LOS 4 DG DEL RUT
    public boolean validarClaveTrabajador(int clave) {
        // CONVIERTE EL RUT EN STRING
        String runDigits = String.valueOf(rut); 
        //OBTIENE LOS 4 DIGITOS DE RUT
        String claveEsperada = runDigits.substring(0, 4);
        
        String claveIngresada = String.valueOf(clave);
        
        return claveIngresada.equals(claveEsperada);
    }
    
    
}
