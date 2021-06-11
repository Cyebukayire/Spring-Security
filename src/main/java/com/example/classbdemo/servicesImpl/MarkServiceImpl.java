package com.example.classbdemo.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.classbdemo.dto.CreateMarkDTO;
import com.example.classbdemo.model.Course;
import com.example.classbdemo.model.Mark;
import com.example.classbdemo.model.Student;
import com.example.classbdemo.repositories.MarkRepository;
import com.example.classbdemo.services.IMarkServices;

public class MarkServiceImpl implements IMarkServices {

	
	@Autowired
	private MarkRepository markRepository;
	
	@Override
	public Mark save(CreateMarkDTO markDto, Student student, Course course) {
		Mark mark = new Mark();
		
		mark.setCourse(course);
		mark.setMax(markDto.getMax());
		mark.setScored(markDto.getScored());
		mark.setStudent(student);
		
		return markRepository.save(mark);
	}
	
}
