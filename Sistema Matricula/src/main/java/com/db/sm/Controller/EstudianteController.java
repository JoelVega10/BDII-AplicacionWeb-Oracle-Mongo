package com.db.sm.Controller;
import java.sql.SQLException;
import java.util.List;

import com.db.sm.DAO.EstudianteDAO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import com.db.sm.Model.Estudiante;

@Controller
public class EstudianteController {

    @Autowired
    private EstudianteDAO estudianteDAO;

    @RequestMapping("/estudiantes")
    public String viewEstudiantes(Model model) {
        List<Estudiante> listEstudiantes = estudianteDAO.listEstudiantes();
        model.addAttribute("listEstudiantes", listEstudiantes);
        return "/estudiante/view-estudiantes";
    }

    @RequestMapping("/estudiantes/pin")
    public String viewEstudiantesPin(Model model) throws SQLException {
        List<Estudiante> listEstudiantesPin = estudianteDAO.listEstudiantesPin();
        model.addAttribute("listEstudiantesPin", listEstudiantesPin);
        return "/estudiante/view-estudiantes_pin";
    }

    @RequestMapping("/estudiantes/new")
    public String newEstudianteForm(Model model) {
        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante", estudiante);

        return "/estudiante/new-estudiante-form";
    }

    @RequestMapping(value = "/estudiantes/save", method = RequestMethod.POST)
    public String saveEstudiante (@ModelAttribute("estudiante") Estudiante estudiante) throws SQLException {

        estudianteDAO.saveEstudiante(estudiante);

        return "redirect:/estudiantes";
    }

    @RequestMapping("/estudiantes/edit/{id}")
    public ModelAndView editEstudianteForm(@PathVariable(name = "id") int id) {

        ModelAndView modelAndView = new ModelAndView("/estudiante/edit-estudiante-form");
        Estudiante estudiante = estudianteDAO.getEstudiante(id);
        modelAndView.addObject("estudiante", estudiante);

        return modelAndView;
    }

    @RequestMapping(value = "/estudiantes/update", method = RequestMethod.POST)
    public String updateEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        estudianteDAO.updateEstudiante(estudiante);

        return "redirect:/estudiantes";
    }

    @RequestMapping("/estudiantes/delete/{id}")
    public String deleteEstudiante(@PathVariable(name = "id") int id) {

        estudianteDAO.deleteEstudiante(id);

        return "redirect:/estudiantes";
    }
}

