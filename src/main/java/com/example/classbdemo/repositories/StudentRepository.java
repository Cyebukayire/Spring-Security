package com.example.classbdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.classbdemo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
