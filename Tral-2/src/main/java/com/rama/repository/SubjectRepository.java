package com.rama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rama.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{

}
