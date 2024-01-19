/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_eduardocastellon;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;


/**
 *
 * @author caste
 */
public class Lab1P2_EduardoCastellon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Scanner lea = new Scanner(System.in);
        
        ArrayList<Usuario> usuarios = new ArrayList();

        boolean seguir = true;
        while (seguir) {
            System.out.println("---Registro---");
            System.out.println("1. Ingresar usuario");
            System.out.println("2. Listar todo");
            System.out.println("3. Listar por dominio");
            System.out.println("presione [4] para salir");
            int opc = entrada.nextInt();

            switch (opc) {
                case 4: {
                    System.out.println("Saliendo del programa...");
                    seguir = false;
                    break;
                }
                case 1: {
                    System.out.println("Ingrese su usuario");
                    System.out.println("Nombre: ");
                    String nombre = lea.nextLine();
                    System.out.println("Apellido");
                    String apellido = lea.nextLine();
                    String contra = validarContra();
                    String correo = validarCorreo();
                    String dom = obtenerDom(correo);
                    break;
                }
                case 2:{
                    
                    break;
                }
            }
        }

    }

    public static String validarContra() {
        Scanner lea = new Scanner(System.in);
        
        Pattern simbolos = Pattern.compile("^[-.*_.*&.*$.*%]$");
        
        boolean validarContra = true;
        while(validarContra){
            
        }

        

        return contra;
    }

    public static String validarCorreo() {
        Scanner lea = new Scanner(System.in);
        String correo = "";

        boolean validarCorreo = true;
        while (validarCorreo) {
            System.out.println("Ingrese su correo:");
            correo = lea.nextLine();

            String dom = obtenerDom(correo);
            if (dom.equals("gmail.com")) {
                validarCorreo = false;
            }
            if (dom.equals("Outlook.com")) {
                validarCorreo = false;
            }
            if (dom.equals("Yahoo.com")) {
                validarCorreo = false;
            }
            if (dom.equals("iCloud.com")) {
                validarCorreo = false;
            }
            if (dom.equals("ProtonMail.com")) {
                validarCorreo = false;
            }
            if (dom.equals("FastMail.com")) {
                validarCorreo = false;
            }else{
                System.out.println("Ingrese un dominio valido");
                System.out.println("Dominions validos: ");
                System.out.println(
                        "-gmail \n"
                        + "-Outlook \n"
                        + "-Yahoo \n"
                        + "-iCloud \n"
                        + "-PortonMail \n"
                        + "-FastMail \n");
            }
        }
        return correo;
    }

    public static String obtenerDom(String correo) {
        String dom = "";
        String domArr[] = correo.split("@");
        dom = domArr[1];
        return dom;
    }

}
