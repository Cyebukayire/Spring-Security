package com.example.classbdemo.services;

import com.example.classbdemo.dto.CreateMarkDTO;
import com.example.classbdemo.model.Course;
import com.example.classbdemo.model.Mark;
import com.example.classbdemo.model.Student;

public interface IMarkServices {

	 Mark save(CreateMarkDTO markDto,Student student,Course course);
}
