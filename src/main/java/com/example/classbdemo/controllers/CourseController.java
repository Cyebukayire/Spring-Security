package com.example.classbdemo.controllers;

import com.example.classbdemo.model.Course;
import com.example.classbdemo.repositories.CourseRepository;
import com.example.classbdemo.repositories.MarkRepository;
import com.example.classbdemo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;


	private MarkRepository markRepository;
	private StudentRepository studentRepository;

//	getting all courses
	@GetMapping
	public List<Course> getAll() {
		
		return courseRepository.findAll();
	}
	
   //get course by id
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable(value="id") Long id) {
		Optional<Course> course = courseRepository.findById(id);
		if(course.isPresent()) {
			return ResponseEntity.ok(course.get()) ;
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Course());
	}

//	inserting a new course
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Course course){
	
		if(courseRepository.existsByNameAndCode(course.getName(), course.getCode())) {
			return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.findByNameAndCode(course.getName(), course.getCode()).get());
		}
		courseRepository.save(course);
		 
		return ResponseEntity.status(HttpStatus.CREATED).body(course);
	}

//	updating a course by id
  @PutMapping("/{id}")
  public ResponseEntity<Course> updateCourseById(@PathVariable Long id, @RequestBody Course course){
	Optional<Course> CourseData = courseRepository.findById(id);
	if(CourseData.isPresent()){
		Course _course = CourseData.get();
		_course.setId(course.getId());
		_course.setName(course.getName());
		_course.setCode(course.getCode());
		return new ResponseEntity<>(courseRepository.save(_course),HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

	//Delete course by ID
	@DeleteMapping("/{id}")
	public void deleteCourseById(@PathVariable Long id){
		courseRepository.deleteById(id);
	}





}
