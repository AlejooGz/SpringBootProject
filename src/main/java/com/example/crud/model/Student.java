package main.java.com.example.crud.model;

import javax.persistence.*;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

import lombok.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "Student")
public class Student {

	public Student() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "Name")
	private String name;
	@Column(name = "Lastname")
	private String lastName;
	@Column(name = "Age")
	private Integer age;
}
