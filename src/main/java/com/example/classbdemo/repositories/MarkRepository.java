package com.example.classbdemo.repositories;

import com.example.classbdemo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.classbdemo.model.Mark;

import java.util.Optional;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {

    boolean existsByScoredAndStudentAndCourse(int Scored, String student, String course);

    Optional<Course> findByScoredAndStudentAndCourse(int Scored, String student, String course);

}
