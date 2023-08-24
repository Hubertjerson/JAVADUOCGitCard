/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validacionClases;


/**
 *
 * @author Jerson
 */
public class validacion {
    
    public validacion(){
    }
    
    // VALIDAR QUE EL NOMBRE DEL TRABAJADOR NO ESTE VACIO
    public static boolean validarNombre(String nombre){
        return !nombre.isEmpty();
    }
    
    //VALIDAR RUT y DV
    public static boolean validarRut(int rut, char dv) {
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        char calculatedDv = (char) (s != 0 ? s + 47 : 75);
        return Character.toUpperCase(dv) == calculatedDv || dv=='K' || dv=='k';
    }
    
    // VALIDACION QUE EL MONTO SEA MAYOR A 0
    public static boolean validarMonto(int monto){
        return monto>=0;
    }
}
