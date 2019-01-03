package com.vegas.parts.model;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PartsRepository extends JpaRepository<Part, Integer> {

//    List<Part> findPartsByNecessaryIsTrue();
    Part findByTitle(String title);
    List<Part> findAll();
}
