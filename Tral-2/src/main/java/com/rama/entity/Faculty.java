package com.rama.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="facultys")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name", nullable = false)
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;

	@Column(name="dob")
    private String dob;
    
	@Column(name="gender")
    private String gender;
    
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
    private String phone;
    
	@Column(name="address")
    private String address;
    
	@Column(name="department")
    private String department;
    
	@Column(name="position")
    private String position;
	
	@Column(name="photo") 
	private String photo;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;

	public Faculty(String firstName, String middleName, String lastName, String dob, String gender, String email,
			String phone, String address, String department, String position, String photo, String userName,
			String password) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.department = department;
		this.position = position;
		this.photo = photo;
		this.userName = userName;
		this.password = password;
	}
    
}
