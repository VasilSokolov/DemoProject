package com.java.demo.services;

import java.util.List;

import com.java.demo.models.bindengModels.user.RegisterUser;
import com.java.demo.models.viewModels.user.ViewUser;

public interface UserService {
	
	void persist(RegisterUser registerUser);
	
	List<ViewUser> findAll ();
	
	
}
