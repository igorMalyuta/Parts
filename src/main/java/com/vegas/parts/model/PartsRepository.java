package com.vegas.parts.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartsRepository extends JpaRepository<Part, Integer> {

    Page<Part> findPartsByNecessaryIsTrue(Pageable pageable);
    Page<Part> findPartsByNecessaryIsFalse(Pageable pageable);
    Part findByTitle(String title);

    @Override
    Page<Part> findAll(Pageable pageable);

    @Override
    List<Part> findAll();
}
