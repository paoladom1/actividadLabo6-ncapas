package com.uca.capas.controller;

import com.uca.capas.domain.Estudiante;
import com.uca.capas.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private EstudianteService estudianteService;

    @RequestMapping("/estudiante")
    public ModelAndView initMain() {
        ModelAndView mav = new ModelAndView();
        List<Estudiante> estudiantes = null;

        try {
            estudiantes = estudianteService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mav.addObject("estudiantes", estudiantes);
        mav.setViewName("main");
        return mav;
    }

    @RequestMapping(value = "/mostrarEstudiante", method = RequestMethod.POST)
    public ModelAndView findOne(@RequestParam(value = "codigo") int id) {
        ModelAndView mav = new ModelAndView();
        Estudiante estudiante = estudianteService.findOne(id);

        mav.addObject("estudiante", estudiante);
        mav.setViewName("estudiante");

        return mav;
    }

    @PostMapping("/save")
    public ModelAndView guardar(@Valid @ModelAttribute Estudiante estudiante, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        if (br.hasErrors()) {
            mav.setViewName("agregarEstudiante");
        } else {
            estudianteService.save(estudiante);
            List<Estudiante> estudiantes = estudianteService.findAll();


            mav.addObject("estudiantes", estudiantes);
            mav.setViewName("listaEstudiantes");
        }

        return mav;
    }

    @RequestMapping(value = "/borrarEstudiante", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam(value = "codigo") int id) {
        ModelAndView mav = new ModelAndView();
        estudianteService.delete(id);
        List<Estudiante> estudiantes = null;

        try {
            estudiantes = estudianteService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mav.addObject("estudiantes", estudiantes);
        mav.setViewName("listaEstudiantes");

        return mav;
    }

    @GetMapping("/insertarEstudiante")
    public ModelAndView inicio() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("estudiante", new Estudiante());
        mav.setViewName("agregarEstudiante");

        return mav;
    }

    @RequestMapping("/")
    public ModelAndView Main() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("main");
        return mav;
    }

}
