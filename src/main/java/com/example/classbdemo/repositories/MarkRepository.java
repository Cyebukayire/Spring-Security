package com.example.classbdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.classbdemo.model.Mark;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {

}
