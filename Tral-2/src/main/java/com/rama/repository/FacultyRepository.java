package com.rama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rama.entity.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long>{

}
