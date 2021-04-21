package com.db.sm.Controller;

import com.db.sm.Model.Estudiante;
import com.db.sm.Model.EstudianteMongo;
import com.db.sm.Repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Optional;

@Controller
public class EstudianteMongoController {
    @Autowired
    EstudianteRepository estudianteRepository;

    @RequestMapping("/estudiantesMongo")
    public String product(Model model) {
        model.addAttribute("estudiantesMongo", estudianteRepository.findAll());
        return "/estudianteMongo/view-estudiantes-mongo";
    }

    @RequestMapping("/estudiantesMongo/create")
    public String create(Model model) {
        return "/estudianteMongo/new-estudiante-mongo-form";
    }

    @RequestMapping("/estudiantesMongo/save")
    public String save(@RequestParam String imagen,@RequestParam String fechaNacimiento, @RequestParam String carrera, @RequestParam Integer plan) {
        EstudianteMongo estudianteMongo = new EstudianteMongo();
        estudianteMongo.setImagen(imagen);
        estudianteMongo.setFechaNacimiento(fechaNacimiento);
        estudianteMongo.setCarrera(carrera);
        estudianteMongo.setPlan(plan);
        estudianteRepository.save(estudianteMongo);

        return "redirect:/estudiantesMongo/";
    }

    @RequestMapping("/estudiantesMongo/delete/{id}")
    public String delete(@PathVariable(name = "id") String id) {
        estudianteRepository.delete(estudianteRepository.findById(id).get());
        return "redirect:/estudiantesMongo/";
    }

    @RequestMapping("/estudiantesMongo/edit/{id}")
    public ModelAndView edit(@PathVariable String id, Model model) {
        ModelAndView modelAndView = new ModelAndView("/estudianteMongo/edit-estudiante-mongo-form");
        model.addAttribute("estudianteMongo", estudianteRepository.findById(id).get());
        return modelAndView;
    }

    @RequestMapping("/estudiantesMongo/update")
    public String update(@RequestParam String id, @RequestParam String imagen,@RequestParam String fechaNacimiento, @RequestParam String carrera, @RequestParam Integer plan) {
        Optional<EstudianteMongo> estudianteMongo = estudianteRepository.findById(id);
        estudianteMongo.get().setImagen(imagen);
        estudianteMongo.get().setFechaNacimiento(fechaNacimiento);
        estudianteMongo.get().setCarrera(carrera);
        estudianteMongo.get().setPlan(plan);
        estudianteRepository.save(estudianteMongo.get());

        return "redirect:/estudiantesMongo/";
    }
}
