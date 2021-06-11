package com.example.classbdemo.dto;

import com.sun.istack.NotNull;

public class CreateMarkDTO {

	@NotNull
	private int max;
	
	@NotNull
	private int scored;
	
	private long studentId;
	
	private long courseId;

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getScored() {
		return scored;
	}

	public void setScored(int scored) {
		this.scored = scored;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	
	
}
