/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import models.Tarjeta;
import models.Trabajador;
import validacionClases.validacion;
/**
 *
 * @author Jerson
 */
public class MenuMain {
    
    
    public static void main(String[] args){
        
        //OPCION SWICHT
        int opcion;
        
        //TRABAJADOR
        int rut;
        String nombre;
        char dv;
        
        //TARJETA
        
        long codigo;
        int clave ,monto,montoCompra;
        String fechaStr;
        
        
        Scanner teclado = new Scanner(System.in);
        
        validacion validacion = new validacion();
        Trabajador trabajador = new Trabajador();
        Tarjeta tarjeta = new Tarjeta();
        
        do{
            System.out.println("******Menu*******");
            System.out.println("1. Crear trabajador");
            System.out.println("2. Crear tarjeta");
            System.out.println("3. Mostrar informacion de la tarjeta");
            System.out.println("4. Realizar Compra");
            System.out.println("5. Salir");
            opcion = teclado.nextInt();
            
            switch(opcion){
                
                // AGREGANDO DATOS TRABAJADOR
                case 1:
                    //BANDERAS PARA CADA CASO     
                    boolean flagRut = false;
                    boolean flagNombre = false;
                    //AGREGANDO O INSERTANDO DATOS DEL TRABAJADOR RUT Y DV 
                    do{
                        System.out.println("Ingrese el RUT del trabajador: ");
                        rut = teclado.nextInt();
                        System.out.println("Ingrese el dv del trabajador ");
                        dv = Character.toUpperCase(teclado.next().charAt(0));
                        teclado.nextLine();
                        if (validacion.validarRut(rut,dv)){
                            flagRut=true;
                        } else{
                            System.out.println("Rut o DV invalido. Intente nuevamente");
                        }
                    }while(!flagRut);
                    
                    
                    //AGREGANDO DATOS DEL TRABAJADOR NOMBRE
                    
                    do{
                        System.out.println("Ingrese el nombre del trabajador: ");
                        nombre = teclado.nextLine();
                        if(validacion.validarNombre(nombre)){
                            flagNombre = true;
                        }else{
                            System.out.println("Error ingrese nuevamente su nombre");
                        }
                    }while(!flagNombre);
                    
                    trabajador.setRut(rut);
                    trabajador.setDv(dv);
                    trabajador.setNombre(nombre);
                    System.out.println("Trabajador Creado Exitosamente");
                    System.out.println("----------------------------------------");
                    break;
                  
                //  AGREGANDO DATOS DE LA TARJETA
                case 2:
                    boolean flagClave = false;
                    boolean flagMonto = false;
                    boolean flagFecha = false;
                    System.out.println("Generando código de tarjeta...");
                    codigo = tarjeta.generarCodigoTarjeta();

                    do{
                        System.out.println("Ingrese la clave de la tarjeta (4 primeros dígitos del RUT): ");
                        clave = teclado.nextInt();
                        if(trabajador.validarClaveTrabajador(clave)){
                            flagClave = true;
                        }else{
                            System.out.println("Error ingrese nuevamente su clave");
                        }
                    }while(!flagClave);
                    
                    do{
                        System.out.println("Ingrese el monto de la tarjeta: ");
                        monto = teclado.nextInt();
                        if(validacion.validarMonto(monto)){
                            flagMonto = true;
                        }else{
                            System.out.println("El monto ingresado es menor a 0");
                        }
                    }while(!flagMonto);
        
                    // SALTO DE LINEA
                    teclado.nextLine();
        
                    Date fecha = null;
                    do {
                        System.out.println("Ingrese la fecha (dd/mm/yyyy): ");
                        fechaStr = teclado.nextLine();
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            
                        try {
                            fecha = formato.parse(fechaStr);
                            tarjeta.setCodigo(codigo);
                            tarjeta.setClave(clave);
                            tarjeta.setMonto(monto);
                            tarjeta.setTrabajador(trabajador);
                            tarjeta.setFecha(fecha);
                            if (tarjeta.validarVigencia()) {
                                flagFecha = true;
                                System.out.println("Tarjeta creada exitosamente");
                                System.out.println("----------------------------------------");
                            } else {
                                System.out.println("La tarjeta no está vigente");
                            }
                        } catch (ParseException e) {
                            System.out.println("Fecha inválida. Intente nuevamente.");
                        }
                    } while (!flagFecha);
                    break;

                case 3:
                    System.out.println("***************************");
                    System.out.println("Informacion de Su tarjeta ");
                    tarjeta.informacionTarjeta();
                    // SALTO DE LINEA
                    teclado.nextLine();
                    break;
                
                case 4:
                    boolean flagMontoCompra = false; 
                    do{
                        teclado.nextLine();
                        System.out.println("Ingrese el monto de la compra");
                        montoCompra = teclado.nextInt();
                        if(tarjeta.validarMontoCompra(montoCompra)){
                            tarjeta.descontarMontoCompra(montoCompra);
                            flagMontoCompra=true;
                        }else{
                            System.out.println("Salgo insuficiente en su tarjeta");
                        }
                    }while(!flagMontoCompra);
                    break;
                
                case 5:
                    System.out.println("Saliendo del programa...");
                    teclado.close();
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("Opcion invalida intentelo nuevamente");
            }
            
        }while(opcion!=5);
    }
}
