package com.vegas.parts.controller;

import com.vegas.parts.model.ComputerBuilder;
import com.vegas.parts.model.Part;
import com.vegas.parts.model.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PartsController {

    @Autowired
    PartsRepository repository;

    @GetMapping("/")
    public String homePage(Model model,
         @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        Page<Part> partPage = repository.findAll(pageable);
        PageWrapper<Part> page = new PageWrapper<>(partPage, "/");
        model.addAttribute("parts", page.getContent());
        model.addAttribute("page", page);

        int minAssembly = ComputerBuilder.assemblyCount(repository.findAll());
        model.addAttribute("minAssembly", minAssembly);

        return "index";
    }

    @PostMapping("search")
    public String searchResult(@RequestParam(value = "title") String title, Model model) {
        if (title == null || title.isEmpty())
            return "search-fail";

        title = title.trim();
        model.addAttribute("title", title);

        Part part = repository.findByTitle(title);
        if (part != null)
            model.addAttribute("part", part);
        else
            return "search-fail";

        return "search";
    }

    @GetMapping("/add-part")
    public String addPart(Model model) {
        return "add-part";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Part part = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid part Id:" + id));

        model.addAttribute("part", part);
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String deletePart(@PathVariable("id") int id, Model model) {
        Part found = repository.findById(id).get();
        repository.delete(found);

        model.addAttribute("parts", repository.findAll());

        return "index";
    }
}
