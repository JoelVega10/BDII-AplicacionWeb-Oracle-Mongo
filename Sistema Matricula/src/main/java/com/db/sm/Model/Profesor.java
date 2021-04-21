package com.db.sm.Model;

public class Profesor {
    private long id;
    private int cedula;
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String correo;
    private String direccion;
    private int telefono;
    private long id_sede;

    public Profesor(){ }
    public Profesor(int cedula,int carne,String nombre,String primer_apellido,String segundo_apellido,String correo,String direccion,int telefono,long id_sede ) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.id_sede = id_sede;
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

    public long getId_sede(){return id_sede;}

    public void setId_sede(long id_sede) {this.id_sede = id_sede;}

    @Override
    public String toString() {
        return "Profesor [profesor_id=" + id + ", cedula=" + cedula +  ", nombre=" + nombre + ", primer_apellido=" + primer_apellido + ", segundo_apellido=" + segundo_apellido + ", correo=" + correo + ", direccion=" + direccion + ", telefono=" + telefono + ", id_sede" + id_sede + "]";
    }
}
