package com.vegas.parts.controller;

import com.vegas.parts.model.*;
import com.vegas.parts.model.dao.PartsRepository;
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

    private String show = "all";
    private Integer partID = 0;

    @GetMapping("/")
    public String homePage(@RequestParam(name = "filter", required = false) String filter, Model model,
             @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        Page<Part> page = null;

        if(filter != null && !filter.isEmpty())
            show = filter;

        switch (show) {
            case "all":
                page = repository.findAll(pageable);
                break;

            case "nes":
                page = repository.findNecessary(pageable);
                break;

            case "opt":
                page = repository.findOptional(pageable);
        }

        model.addAttribute("parts", page.getContent());
        model.addAttribute("page", page);

        int minAssembly = ComputerBuilder.assemblyCount(repository.findAll());
        model.addAttribute("minAssembly", minAssembly);

        return "index";
    }

    @PostMapping("search")
    public String searchResult(@ModelAttribute("title") String title, Model model) {
        if (title == null || title.isEmpty())
            return "search-fail";

        title = title.trim();

        Part part = repository.findByTitle(title);
        if (part != null)
            model.addAttribute("part", part);
        else
            return "search-fail";

        return "search";
    }

    @ModelAttribute("partTypes")
    public PartType[] getPartTypes() {
        return PartType.values();
    }

    @GetMapping("/add-part")
    public String addForm(Model model) {
        model.addAttribute("part", new Part());

        return "add-part";
    }

    @PostMapping("add")
    public String addSubmit(@ModelAttribute("part") Part part) {
        repository.save(part);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Part editPart = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid part Id:" + id));

        partID = id;
        model.addAttribute("editPart", editPart);
        return "update";
    }

    @PostMapping("update")
    public String updateSubmit(@ModelAttribute("editPart") Part editPart, Model model,
                               @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        Part part = repository.findById(partID).get();
        part.setTitle(editPart.getTitle());
        part.setType(editPart.getType());
        part.setQuantity(editPart.getQuantity());

        repository.save(part);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePart(@PathVariable("id") int id, Model model) {
        Part found = repository.findById(id).get();
        repository.delete(found);

        model.addAttribute("parts", repository.findAll());

        return "redirect:/";
    }
}
