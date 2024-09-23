package com.rama.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rama.entity.Faculty;
import com.rama.entity.Student;
import com.rama.repository.LoginRepository;
import com.rama.repository.LoginRepository2;
import com.rama.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	private LoginRepository loginRepository;

	public LoginServiceImpl(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	@Autowired
	private LoginRepository2 loginRepository2;

	@Override
	public Student Login(String username, String password) {
		return loginRepository.findByUserNameAndPassword(username, password);
	}

	@Override
	public Faculty Login2(String username, String password) {
		return loginRepository2.findByUserNameAndPassword(username, password);
	}
	
}
