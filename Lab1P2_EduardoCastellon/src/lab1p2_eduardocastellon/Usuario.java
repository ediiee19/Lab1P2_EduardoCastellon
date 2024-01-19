/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1p2_eduardocastellon;

/**
 *
 * @author caste
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private int edad;
    private String correo;
    private String contra;
    private String dominio;

    public Usuario(String nombre, String apellido, int edad, String correo, String dominio, String contra) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.dominio = dominio;
        this.contra = contra;
    }

    public Usuario() {
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    public String censurarContra(){
        String contrac = "";
        
        for (int i = 0; i < contrac.length(); i++) {
            contrac = contrac + "*";
        }
        
        return contrac;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", edad=").append(edad);
        sb.append(", correo=").append(correo);
        sb.append(", contra=").append(censurarContra());
        sb.append(", dominio=").append(dominio);
        sb.append('}');
        return sb.toString();
    }
    
}
