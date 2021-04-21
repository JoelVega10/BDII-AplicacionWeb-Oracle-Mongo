package com.db.sm.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estudiante")
public class EstudianteMongo {
    @Id
    String id;
    String imagen;
    String fechaNacimiento;
    String carrera;
    Integer plan;


    public EstudianteMongo() {

    }
    public EstudianteMongo(String imagen,String fechaNacimiento, String carrera, Integer plan){
        this.imagen = imagen;
        this.fechaNacimiento = fechaNacimiento;
        this.carrera = carrera;
        this.plan = plan;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Integer getPlan() {
        return plan;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getId() {
        return id;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setPlan(Integer plan) {
        this.plan = plan;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
