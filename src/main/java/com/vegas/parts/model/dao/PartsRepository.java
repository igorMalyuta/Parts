package com.vegas.parts.model.dao;

import com.vegas.parts.model.Part;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

public interface PartsRepository extends JpaRepository<Part, Integer> {
    Part findByTitle(String title);

    @Override
    Page<Part> findAll(Pageable pageable);

    @Query(value =
     "SELECT * FROM test.parts WHERE type='CPU' OR type='RAM' OR type='HDD' OR type='MOTHERBOARD' OR type='CASE'",
    nativeQuery = true)
    Page<Part> findNecessary(Pageable pageable);


    @Query(value =
     "SELECT * FROM test.parts WHERE type='SSD' OR type='GPU' OR type='SOUND_CARD'",
    nativeQuery = true)
    Page<Part> findOptional(Pageable pageable);
}
