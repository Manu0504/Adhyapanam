package com.rama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rama.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	/*
	 * @Query("Select p from students p where" +
	 * " LOWER(p.first_name) LIKE LOWER(CONCAT('%', :Name, '%')) OR " +
	 * "LOWER(p.last_name) LIKE LOWER(CONCAT('%', :Name, '%')) OR  " +
	 * "LOWER(p.course) LIKE LOWER(CONCAT('%', :Name, '%')) OR" +
	 * "LOWER(p.gender) LIKE LOWER(CONCAT('%', :Name, '%'))") List<Student>
	 * searchStudent(String Name);
	 */
	
}
