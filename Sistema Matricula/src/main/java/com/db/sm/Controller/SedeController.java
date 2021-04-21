package com.db.sm.Controller;

import java.util.List;

import com.db.sm.DAO.SedeDAO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import com.db.sm.Model.Sede;

@Controller
public class SedeController {

    @Autowired
    private SedeDAO sedeDAO;

    @RequestMapping("/sedes")
    public String viewSedes(Model model) {
        List<Sede> listSedes = sedeDAO.listSedes();
        model.addAttribute("listSedes", listSedes);
        return "/sede/view-sedes";
    }

    @RequestMapping("/sedes/new")
    public String newSedeForm(Model model) {
        Sede sede = new Sede();
        model.addAttribute("sede", sede);

        return "/sede/new-sede-form";
    }

    @RequestMapping(value = "/sedes/save", method = RequestMethod.POST)
    public String saveSede (@ModelAttribute("sede") Sede sede) {

        sedeDAO.saveSede(sede);

        return "redirect:/sedes";
    }

    @RequestMapping("/sedes/edit/{id}")
    public ModelAndView editSedeForm(@PathVariable(name = "id") int id) {

        ModelAndView modelAndView = new ModelAndView("/sede/edit-sede-form");
        Sede sede = sedeDAO.getSede(id);
        modelAndView.addObject("sede", sede);

        return modelAndView;
    }

    @RequestMapping(value = "/sedes/update", method = RequestMethod.POST)
    public String updateSede(@ModelAttribute("sede") Sede sede) {
        sedeDAO.updateSede(sede);

        return "redirect:/sedes";
    }

    @RequestMapping("/sedes/delete/{id}")
    public String deleteSede(@PathVariable(name = "id") int id) {

        sedeDAO.deleteSede(id);

        return "redirect:/sedes";
    }
}