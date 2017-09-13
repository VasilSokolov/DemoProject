package com.java.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.demo.entities.User;
import com.java.demo.models.bindengModels.user.RegisterUser;
import com.java.demo.models.viewModels.user.ViewUser;
import com.java.demo.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void persist(RegisterUser registerUser) {
		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(registerUser, User.class);
		this.userRepository.save(user);
	}
	
	@Override
	public User findById(Long id) {
        return userRepository.findOne(id);
    }
		
	@Override
	public List<ViewUser> findAll() {
		List<User> users = this.userRepository.findAll();
		List<ViewUser> viewUsers = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();
		
		for (User user : users) {
			ViewUser viewUser = modelMapper.map(user, ViewUser.class);
			viewUsers.add(viewUser);
		}
		
		return viewUsers;
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);		
	}

	@Override
	public void updateUser(RegisterUser registerUser) {
		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(registerUser, User.class);
		saveUser(user);
	}

	@Override
	public void deleteUser(RegisterUser registerUser) {
		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(registerUser, User.class);
		userRepository.delete(user.getId());
	}
}
