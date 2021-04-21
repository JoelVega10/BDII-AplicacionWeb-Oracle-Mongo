package com.db.sm.Model;

public class Estudiante {

    private long id;
    private int cedula;
    private int carne;
    private String pin;
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String correo;
    private String direccion;
    private int telefono;

    public Estudiante(){ }
    public Estudiante(int cedula,int carne,String pin,String nombre,String primer_apellido,String segundo_apellido,String correo,String direccion,int telefono ) {
        this.cedula = cedula;
        this.carne = carne;
        this.pin = pin;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getCarne() {
        return carne;
    }

    public void setCarne(int carne) {
        this.carne = carne;
    }

    public String getPin(){return pin;}

    public void setPin(String pin){this.pin = pin;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Estudiante [estudiante_id=" + id + ", cedula=" + cedula + ", carne=" + carne + ", pin" + pin + ", nombre=" + nombre + ", primer_apellido=" + primer_apellido + ", segundo_apellido=" + segundo_apellido + ", correo=" + correo + ", direccion=" + direccion + ", telefono=" + telefono + "]";
    }

}
