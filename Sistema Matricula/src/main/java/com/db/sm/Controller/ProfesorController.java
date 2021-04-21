package com.db.sm.Controller;

import java.util.List;

import com.db.sm.DAO.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import com.db.sm.Model.Profesor;

@Controller
public class ProfesorController {

    @Autowired
    private ProfesorDAO profesorDAO;

    @RequestMapping("/profesores")
    public String viewProfesores(Model model) {
        List<Profesor> listProfesores = profesorDAO.listProfesores();
        model.addAttribute("listProfesores", listProfesores);
        return "/profesor/view-profesores";
    }

    @RequestMapping("/profesores/new")
    public String newProfesorForm(Model model) {
        Profesor profesor = new Profesor();
        model.addAttribute("profesor", profesor);

        return "/profesor/new-profesor-form";
    }

    @RequestMapping(value = "/profesores/save", method = RequestMethod.POST)
    public String saveProfesor (@ModelAttribute("profesor") Profesor profesor) {

        profesorDAO.saveProfesor(profesor);

        return "redirect:/profesores";
    }

    @RequestMapping("/profesores/edit/{id}")
    public ModelAndView editProfesorForm(@PathVariable(name = "id") int id) {

        ModelAndView modelAndView = new ModelAndView("/profesor/edit-profesor-form");
        Profesor profesor = profesorDAO.getProfesor(id);
        modelAndView.addObject("profesor", profesor);

        return modelAndView;
    }

    @RequestMapping(value = "/profesores/update", method = RequestMethod.POST)
    public String updateProfesor(@ModelAttribute("profesor") Profesor profesor) {
        profesorDAO.updateProfesor(profesor);

        return "redirect:/profesores";
    }

    @RequestMapping("/profesores/delete/{id}")
    public String deleteProfesor(@PathVariable(name = "id") int id) {

        profesorDAO.deleteProfesor(id);

        return "redirect:/profesores";
    }
}

