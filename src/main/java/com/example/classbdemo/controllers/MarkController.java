package com.example.classbdemo.controllers;

import com.example.classbdemo.dto.CreateMarkDTO;
import com.example.classbdemo.model.Course;
import com.example.classbdemo.model.Mark;
import com.example.classbdemo.model.Student;
import com.example.classbdemo.repositories.CourseRepository;
import com.example.classbdemo.repositories.MarkRepository;
import com.example.classbdemo.repositories.StudentRepository;
import com.example.classbdemo.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.classbdemo.services.IMarkServices;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marks")
public class MarkController{
	@Autowired
	private MarkRepository markRepository;

	@Autowired
	private StudentRepository StudentRepository;

	@Autowired
	private CourseRepository courseRepository;

	private IMarkServices markService;

//	get all courses
	@GetMapping
	public List<Mark> getAll() {
		
		return markRepository.findAll();
	}

//	get course by id
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable(value="id") Long id) {
		
		Optional<Mark> mark = markRepository.findById(id);
		if(mark.isPresent()) {
			return ResponseEntity.ok(mark.get()) ;
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Course());
		
	}

//	adding new marks
@PostMapping
public ResponseEntity<?> save(@Valid @RequestBody CreateMarkDTO dto){
	Optional<Course> course = courseRepository.findById(dto.getCourseId());
	if(!course.isPresent()) {
		ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new APIResponse("Course not found", false));
	}
	Optional<Student> student = StudentRepository.findById(dto.getStudentId());

	if(!student.isPresent()) {
		ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new APIResponse("Student not found", false));
	}

	return ResponseEntity.status(HttpStatus.CREATED).body(markService.save(dto, student.get(), course.get()));
}

// update MARKS by id
@PutMapping("{id}")
public ResponseEntity<Mark> updateMarkById(@PathVariable Long id, @RequestBody CreateMarkDTO markDTO){
	Optional<Mark> MarkData = markRepository.findById(id);
	Optional<Course> course = courseRepository.findById(markDTO.getCourseId());
	if(!course.isPresent()) {
		ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new APIResponse("Course not found", false));
	}
	Optional<Student> student = StudentRepository.findById(markDTO.getStudentId());

	if(!student.isPresent()) {
		ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new APIResponse("Student not found", false));
	}

	if(MarkData.isPresent()){
		Mark _mark = MarkData.get();
		_mark.setStudent(student.get());
		_mark.setCourse(course.get());
		_mark.setScored(markDTO.getScored());
		_mark.setMax(markDTO.getMax());

		return new ResponseEntity<>(markRepository.save(_mark),HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

//    delete marks by id
	@DeleteMapping("/{id}")
	public void deleteMarkById(@PathVariable Long id){
		courseRepository.deleteById(id);
	}

}
