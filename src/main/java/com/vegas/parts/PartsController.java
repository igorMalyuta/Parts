package com.vegas.parts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PartsController {

    @GetMapping("/")
    public String homePage(Model model) {
        return "index";
    }
}
