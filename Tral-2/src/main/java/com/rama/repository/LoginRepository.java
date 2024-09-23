package com.rama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rama.entity.Student;

@Repository
public interface LoginRepository extends JpaRepository<Student, Long>{

	Student findByUserNameAndPassword(String username, String password);
	
}
