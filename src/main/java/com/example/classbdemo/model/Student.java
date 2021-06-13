package com.example.classbdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.classbdemo.enumerations.EGender;
import com.sun.istack.NotNull;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	private String names;
	
	private EGender gender;
	
	private String className;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public EGender getGender() {
		return gender;
	}

	public void setGender(EGender gender) {
		this.gender = gender;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
}
