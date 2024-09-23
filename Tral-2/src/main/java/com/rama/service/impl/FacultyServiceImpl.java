package com.rama.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rama.entity.Faculty;
import com.rama.repository.FacultyRepository;
import com.rama.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {

	private FacultyRepository facultyRepository;
	
	public FacultyServiceImpl(FacultyRepository facultyRepository) {
		this.facultyRepository = facultyRepository;
	}

	@Override
	public List<Faculty> getAllFacultys() {
		return facultyRepository.findAll();
	}

	@Override
	public Faculty saveFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	@Override
	public Faculty getFacultyById(Long id) {
		return facultyRepository.findById(id).get();
	}

	@Override
	public Faculty updateFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	@Override
	public void deleteFacultyById(Long id) {
		facultyRepository.deleteById(id);
	}

}
