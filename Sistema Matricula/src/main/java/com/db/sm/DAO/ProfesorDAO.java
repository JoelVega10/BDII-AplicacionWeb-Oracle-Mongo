package com.db.sm.DAO;

import com.db.sm.Model.Profesor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProfesorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Profesor> listProfesores() {

        String sql = "SELECT * FROM PROFESOR";

        List<Profesor> listProfesores = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Profesor.class));

        return listProfesores;
    }


    public void saveProfesor(Profesor profesor) {

        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("profesor").usingColumns("cedula","nombre","primer_apellido","segundo_apellido", "correo","direccion", "telefono","id_sede");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(profesor);
        insertActor.execute(param);
    }

    public Profesor getProfesor(int id) {
        String sql = "SELECT * FROM profesor WHERE id = ?";
        Object[] args = {id};
        Profesor profesor = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Profesor.class));

        return profesor;
    }

    public void updateProfesor(Profesor profesor) {

        String sql = "UPDATE profesor SET cedula=:cedula, nombre=:nombre,primer_apellido=:primer_apellido,segundo_apellido=:segundo_apellido,correo=:correo, direccion=:direccion, telefono=:telefono, id_sede=:id_sede WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(profesor);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void deleteProfesor(int id) {
        String sql = "DELETE FROM profesor WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
