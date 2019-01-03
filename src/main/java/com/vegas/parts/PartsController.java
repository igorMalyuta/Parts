package com.vegas.parts;

import com.vegas.parts.model.Part;
import com.vegas.parts.model.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PartsController {

    @Autowired
    PartsRepository repository;

    @GetMapping("/")
    public String homePage(Model model) {
        System.out.println("size of repo is  " + repository.findAll().size());
        model.addAttribute("parts", repository.findAll());

        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Part part = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid part Id:" + id));

        model.addAttribute("part", part);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updatePart(@PathVariable("id") int id, @Valid Part part,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            part.setId(id);
            return "update";
        }

        repository.save(part);
        model.addAttribute("parts", repository.findAll());
        return "index";
    }
}
