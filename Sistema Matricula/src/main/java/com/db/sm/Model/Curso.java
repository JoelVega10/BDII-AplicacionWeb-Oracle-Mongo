package com.db.sm.Model;

public class Curso {
    private long id;
    private String codigo;
    private String nombre;
    private int cupos;
    private String grupo;
    private String horario;
    private long id_sede;
    private long id_profesor;

    public Curso(){

    }
    Curso(String codigo, String nombre, int cupos, String grupo, String horario, long id_sede, long id_profesor){
        this.codigo = codigo;
        this.nombre = nombre;
        this.cupos = cupos;
        this.grupo = grupo;
        this.horario = horario;
        this.id_sede = id_sede;
        this.id_profesor = id_profesor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCupos() {
        return cupos;
    }

    public long getId() {
        return id;
    }

    public String getGrupo() {
        return grupo;
    }

    public String getHorario() {
        return horario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getId_profesor() {
        return id_profesor;
    }

    public long getId_sede() {
        return id_sede;
    }

    public void setId_profesor(long id_profesor) {
        this.id_profesor = id_profesor;
    }

    public void setId_sede(long id_sede) {
        this.id_sede = id_sede;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cupos=" + cupos +
                ", grupo='" + grupo + '\'' +
                ", horario=" + horario +
                ", id_sede=" + id_sede +
                ", id_profesor=" + id_profesor +
                '}';
    }
}
