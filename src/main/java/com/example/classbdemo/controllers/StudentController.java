package com.example.classbdemo.controllers;

import com.example.classbdemo.model.Course;
import com.example.classbdemo.model.Student;
import com.example.classbdemo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;


//  get all student
    @GetMapping()
    public List<Student> getAll() {

        return studentRepository.findAll();
    }

// get student by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value="id") Long id) {

        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()) {
            return ResponseEntity.ok(student.get()) ;
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Course());

    }

//    save new student

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Student student){

        if(studentRepository.findById(student.getId())!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(studentRepository.findById(student.getId()));
        }
        studentRepository.save(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    //Update student by id
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable Long id, @RequestBody Student student){
        Optional<Student> StudentData = studentRepository.findById(id);

        if(StudentData.isPresent()){
            Student _student = StudentData.get();
            _student.setId(student.getId());
            _student.setClassName(student.getClassName());
            _student.setGender(student.getGender());
            _student.setNames(student.getNames());

            return new ResponseEntity<>(studentRepository.save(_student),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Delete student by ID
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id){
        studentRepository.deleteById(id);
    }





}
