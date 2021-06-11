package com.example.classbdemo.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.classbdemo.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	boolean existsByNameAndCode(String name, String code);

	Optional<Course> findByNameAndCode(String name, String code);

}
