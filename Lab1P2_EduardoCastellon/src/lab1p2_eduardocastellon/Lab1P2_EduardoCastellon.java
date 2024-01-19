/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_eduardocastellon;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;

/**
 *
 * @author caste
 */
public class Lab1P2_EduardoCastellon {

    public static ArrayList<Usuario> usuarios = new ArrayList();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Scanner lea = new Scanner(System.in);

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
                    System.out.println(contra);
                    String correo = validarCorreo();
                    String dom = obtenerDom(correo);

                    break;
                }
                case 2: {

                    break;
                }
            }
        }

    }

    public static String validarContra() {
        Scanner lea = new Scanner(System.in);
        String contra = "";

        boolean validarContra = true;
        while (validarContra) {
            System.out.println("Ingrese una contraseña, \n"
                    + "debe tener almenos uno de estos caracteres (“!“, “?”,  “<”, “>”, “$” y “%”): ");
            contra = lea.nextLine();

            if (contra.length() >= 8) {
                boolean contraPerm = regexContra(contra);
                if (contraPerm) {
                    validarContra = false;
                } else {
                    System.out.println("Ha ingresado incorrectamente la contrase");
                }
            } else {
                System.out.println("debe tener almenos 8 carcateres");
            }
        }
        return contra;
    }

    public static boolean regexContra(String contra) {
        String regex = "^[a-zA-Z0-9._%&$+-?<>!]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contra);
        return matcher.matches();
    }

    public static String validarCorreo() {
        Scanner lea = new Scanner(System.in);
        String correo = "";

        boolean validarCorreo = true;
        while (validarCorreo) {
            System.out.println("Ingrese su correo:");
            correo = lea.nextLine();

            boolean leerCorreos = buscarCorreo(correo);
            if (leerCorreos) {
                boolean verificarCorr = regexCorre(correo);
                if (verificarCorr) {
                    String dom = obtenerDom(correo);
                    if (dom.equals("gmail.com")) {
                        validarCorreo = false;
                    } else if (dom.equals("Outlook.com")) {
                        validarCorreo = false;
                    } else if (dom.equals("Yahoo.com")) {
                        validarCorreo = false;
                    } else if (dom.equals("iCloud.com")) {
                        validarCorreo = false;
                    } else if (dom.equals("ProtonMail.com")) {
                        validarCorreo = false;
                    } else if (dom.equals("FastMail.com")) {
                        validarCorreo = false;
                    } else {
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
                } else {
                    System.out.println("Tiene algun caracter no permitido");
                }
            } else {
                System.out.println("Ya hay un correo en existencia");
            }

        }
        return correo;
    }

    public static boolean buscarCorreo(String correo) {
        boolean correoEncon = false;
        String correoArr[] = correo.split("@");
        for (Usuario persona : usuarios) {
            if (correoArr[1].equals(persona.getDominio())) {
                if (correo.equals(persona.getCorreo())) {
                    correoEncon = true;
                }
            }
        }
        if (correoEncon) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean regexCorre(String correo) {
        String regex = "^[a-zA-Z0-9._%&$+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    public static String obtenerDom(String correo) {
        String dom = "";
        String domArr[] = correo.split("@");
        dom = domArr[1];
        return dom;
    }

}
