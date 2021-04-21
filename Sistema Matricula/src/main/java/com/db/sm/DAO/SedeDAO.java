package com.db.sm.DAO;

import com.db.sm.Model.Sede;

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
public class SedeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Sede> listSedes() {

        String sql = "SELECT * FROM SEDE";

        List<Sede> listSedes = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Sede.class));

        return listSedes;
    }


    public void saveSede(Sede sede) {

        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("sede").usingColumns("nombre","direccion");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sede);
        insertActor.execute(param);
    }

    public Sede getSede(int id) {
        String sql = "SELECT * FROM sede WHERE id = ?";
        Object[] args = {id};
        Sede sede = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Sede.class));

        return sede;
    }

    public void updateSede(Sede sede) {

        String sql = "UPDATE sede SET nombre=:nombre, direccion=:direccion WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sede);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void deleteSede(int id) {
        String sql = "DELETE FROM sede WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
