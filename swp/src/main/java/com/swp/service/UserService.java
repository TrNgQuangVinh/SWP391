package com.swp.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.swp.dto.UserDTO;
import com.swp.dto.UserResigstration;
import com.swp.entity.User;

public interface UserService extends UserDetailsService{
	UserDTO createUser(UserDTO userDTO);
	
	UserDTO getUserById(String accountId);
	
	UserDTO getUserByEmailOrName(String emailOrName);
	
	List<UserDTO> getAllUser();
	
	UserDTO updateUser(String accountId,UserDTO updatedUser);
	
	void deleteUser(String accountId);
	
	User saveResigstration(UserResigstration userResigstration);
}
