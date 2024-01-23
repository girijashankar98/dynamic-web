package org.webapp.dynamicweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.webapp.dynamicweb.dto.FormDto;

@Controller
public class HomeController {

    @GetMapping("/sign-in")
    public String home() {
        return "signin";
    }

    @PostMapping("/submit")
    public ModelAndView submitHandler(FormDto dto){
        ModelAndView modelAndView = new ModelAndView();

        if(dto.getUsername().equals(dto.getPassword())) {
            modelAndView.setViewName("welcome");
            modelAndView.addObject("username",dto.getUsername());
            return modelAndView;
        }
        else {
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }
}
