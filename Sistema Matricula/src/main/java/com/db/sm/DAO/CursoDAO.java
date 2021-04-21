package com.db.sm.DAO;

import com.db.sm.Model.Curso;

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
public class CursoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Curso> listCursos() {

        String sql = "SELECT * FROM CURSO";

        List<Curso> listCursos = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Curso.class));

        return listCursos;
    }


    public void saveCurso(Curso curso) {

        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("curso").usingColumns("nombre","codigo","cupos", "grupo","horario","id_sede","id_profesor");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(curso);
        insertActor.execute(param);
    }

    public Curso getCurso(int id) {
        String sql = "SELECT * FROM curso WHERE id = ?";
        Object[] args = {id};
        Curso curso = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Curso.class));

        return curso;
    }

    public void updateCurso(Curso curso) {

        String sql = "UPDATE curso SET  nombre=:nombre,codigo=:codigo, cupos=:cupos,grupo=:grupo, horario=:horario, id_sede=:id_sede, id_profesor=:id_profesor WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(curso);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void deleteCurso(int id) {
        String sql = "DELETE FROM curso WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
