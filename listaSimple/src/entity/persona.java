/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author macbookair
 */
public class persona {
    //atributo 
    int id;// clave primaria - primary key (PK)
    String nombre;
    String apellido;
    String direccion;
    String telefono;
    float estatura;
    int edad;
    // puntero
    persona sig;
    
    //miembros método
    // Constructor
    //se encuentran sobre cargados, debido a que permiten diferentes tipos de llamado a la clase
    public persona() {    
    }

    public persona(int id, String nombre, String apellido, String direccion, String telefono, float estatura, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estatura = estatura;
        this.edad = edad;
    }

    public persona(int id, String nombre, String apellido, String direccion, String telefono, float estatura, int edad, persona sig) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estatura = estatura;
        this.edad = edad;
        this.sig = sig;
    }
    
    //Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public persona getSig() {
        return sig;
    }

    public void setSig(persona sig) {
        this.sig = sig;
    }

    
    
}
