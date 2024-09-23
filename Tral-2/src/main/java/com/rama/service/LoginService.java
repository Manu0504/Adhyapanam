package com.rama.service;

import com.rama.entity.Faculty;
import com.rama.entity.Student;

public interface LoginService {

	Student Login(String userName, String password);
	
	Faculty  Login2(String userName, String password);
	
}
