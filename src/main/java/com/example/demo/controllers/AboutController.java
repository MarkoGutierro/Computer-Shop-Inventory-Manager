package com.example.demo.controllers; //package containing controllers

//import necessary annotations
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//annotation to specify the class is a controller
@Controller
public class AboutController {

    //display about template
    @GetMapping("/about")
    public String showAbout() {
        return "about";
    }
}


