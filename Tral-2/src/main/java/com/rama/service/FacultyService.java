package com.rama.service;

import java.util.List;

import com.rama.entity.Faculty;

public interface FacultyService {

	List<Faculty> getAllFacultys();
	
	Faculty saveFaculty(Faculty faculty);
	
	Faculty getFacultyById(Long id);
	
	Faculty updateFaculty(Faculty faculty);
	
	void deleteFacultyById(Long id);
	
}
