package com.swp.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.swp.dto.UserDTO;
import com.swp.dto.UserResigstration;
import com.swp.entity.Role;
import com.swp.entity.User;
import com.swp.exception.UserNotFoundException;
import com.swp.mapper.UserMapper;
import com.swp.repository.UserRepository;
import com.swp.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepo;
	
	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public UserDTO createUser(UserDTO userDto) {
		User user = UserMapper.mapToUser(userDto);
		User savedUser = userRepo.save(user);
		return UserMapper.mapToUserDTO(savedUser);
	}

	@Override
	public UserDTO getUserById(String accountId) {
		User user = userRepo.findById(accountId)
				.orElseThrow(() -> new UserNotFoundException("User does not exist with this id:" + accountId));
		return UserMapper.mapToUserDTO(user);
	}

	@Override
	public List<UserDTO> getAllUser() {
		List<User> users = userRepo.findAll();
		return users.stream().map((user) -> UserMapper.mapToUserDTO(user)).collect(Collectors.toList());
	}

	@Override
	public UserDTO updateUser(String accountId, UserDTO updatedUser) {
		User user = userRepo.findById(accountId)
				.orElseThrow(() -> new UserNotFoundException("User does not exist with this id:" + accountId));
		user.setAddress(updatedUser.getAddress());
		user.setEmail(updatedUser.getEmail());
		user.setFullname(updatedUser.getFullname());
		user.setPassword(updatedUser.getPassword());
		user.setPhonenumber(updatedUser.getPhonenumber());
		user.setUsername(updatedUser.getUsername());
		User updatedUserObj = userRepo.save(user);
		return UserMapper.mapToUserDTO(updatedUserObj);
	}

	@Override
	public void deleteUser(String accountId) {
		User user = userRepo.findById(accountId)
				.orElseThrow(() -> new UserNotFoundException("User does not exist with this id:" + accountId));
		userRepo.deleteById(accountId);
	}

	@Override
	public User saveResigstration(UserResigstration userResigstration) {
		List<User> users = userRepo.findAll();
		String id = users.get(users.lastIndexOf(users)).getAccountId();
		String roleCode = id.substring(0, 2);
		int numbPart = Integer.parseInt(id.substring(2));
		numbPart++;
		String numberCode = String.valueOf(numbPart);
		id = roleCode + numberCode;
		User user = new User(id, userResigstration.getUsername(), userResigstration.getFullname(),
				userResigstration.getEmail(), userResigstration.getPassword(), userResigstration.getPhonenumber(), "US",
				userResigstration.getAddress());
		return userRepo.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username);
		if (user == null)
			throw new UsernameNotFoundException("Invalid username or password");
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRoleToAuthorities(user.getRole()));
	}

	private Collection<? extends GrantedAuthority> mapRoleToAuthorities(String roleString) {
		return Collections.singletonList(new SimpleGrantedAuthority(roleString));
	}
}
