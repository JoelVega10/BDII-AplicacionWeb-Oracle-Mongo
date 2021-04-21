package com.db.sm.Controller;

import java.util.List;

import com.db.sm.DAO.CursoDAO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import com.db.sm.Model.Curso;

@Controller
public class CursoController {

    @Autowired
    private CursoDAO cursoDAO;

    @RequestMapping("/cursos")
    public String viewCursos(Model model) {
        List<Curso> listCursos = cursoDAO.listCursos();
        model.addAttribute("listCursos", listCursos);
        return "/curso/view-cursos";
    }

    @RequestMapping("/cursos/new")
    public String newCursoForm(Model model) {
        Curso curso = new Curso();
        model.addAttribute("curso", curso);

        return "/curso/new-curso-form";
    }

    @RequestMapping(value = "/cursos/save", method = RequestMethod.POST)
    public String saveCurso (@ModelAttribute("curso") Curso curso) {

        cursoDAO.saveCurso(curso);

        return "redirect:/cursos";
    }

    @RequestMapping("/cursos/edit/{id}")
    public ModelAndView editCursoForm(@PathVariable(name = "id") int id) {

        ModelAndView modelAndView = new ModelAndView("/curso/edit-curso-form");
        Curso curso = cursoDAO.getCurso(id);
        modelAndView.addObject("curso", curso);

        return modelAndView;
    }

    @RequestMapping(value = "/cursos/update", method = RequestMethod.POST)
    public String updateCurso(@ModelAttribute("profesor") Curso curso) {
        cursoDAO.updateCurso(curso);

        return "redirect:/cursos";
    }

    @RequestMapping("/cursos/delete/{id}")
    public String deleteCurso(@PathVariable(name = "id") int id) {

        cursoDAO.deleteCurso(id);

        return "redirect:/cursos";
    }
}

