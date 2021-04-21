package com.db.sm.DAO;

import com.db.sm.Model.Estudiante;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Repository
@Transactional
public class EstudianteDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Estudiante> listEstudiantes() {

        String sql = "SELECT * FROM ESTUDIANTE";

        List<Estudiante> listEstudiantes = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Estudiante.class));
        System.out.println(listEstudiantes);
        return listEstudiantes;
    }

    public List<Estudiante> listEstudiantesPin() throws SQLException {

        String sql = "SELECT * FROM ESTUDIANTE";

        List<Estudiante> listEstudiantesPin = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Estudiante.class));
        System.out.println(listEstudiantesPin);
        for(Estudiante estudiante:
             listEstudiantesPin) {
            estudiante.setPin(decriptPin(estudiante.getCarne()));
        }
        System.out.println(listEstudiantesPin);
        return listEstudiantesPin;
    }


    public void saveEstudiante(Estudiante estudiante) throws SQLException {

        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        estudiante.setPin(encriptPin());
        insertActor.withTableName("estudiante").usingColumns("cedula","carne","pin","nombre","primer_apellido","segundo_apellido", "correo","direccion", "telefono");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(estudiante);
        insertActor.execute(param);
    }

    public Estudiante getEstudiante(int id) {
        String sql = "SELECT * FROM estudiante WHERE id = ?";
        Object[] args = {id};
        Estudiante estudiante = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Estudiante.class));

        return estudiante;
    }

    public void updateEstudiante(Estudiante estudiante) {

        String sql = "UPDATE estudiante SET cedula=:cedula, carne=:carne, nombre=:nombre,primer_apellido=:primer_apellido,segundo_apellido=:segundo_apellido,correo=:correo, direccion=:direccion, telefono=:telefono WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(estudiante);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void deleteEstudiante(int id) {
        String sql = "DELETE FROM estudiante WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public String encriptPin() throws SQLException {
        String sql = "select encriptar(trunc(dbms_random.value(10000,1000))) from dual";
        DataSource dataSource = jdbcTemplate.getDataSource();
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String pin = "";
        while (rs.next()) {
            pin = rs.getString("ENCRIPTAR(TRUNC(DBMS_RANDOM.VALUE(10000,1000)))");
            System.out.println(pin);
        }
        return pin;
    }

    public String decriptPin(int carne) throws SQLException {
        String sql = "select desencriptar(" + carne + ") from dual";
        DataSource dataSource = jdbcTemplate.getDataSource();
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String pin = " ";
        while (rs.next()) {
            pin = rs.getString("DESENCRIPTAR("+carne+")");
        }
        return pin;
    }
}
