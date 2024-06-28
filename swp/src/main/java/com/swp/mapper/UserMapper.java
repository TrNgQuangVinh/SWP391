package com.swp.mapper;

import com.swp.dto.UserDTO;
import com.swp.entity.User;

public class UserMapper {
	public static UserDTO mapToUserDTO(User user) {
		return new UserDTO(
				user.getAccountId(), 
				user.getUsername(), 
				user.getFullname(), 
				user.getEmail(),
				user.getPassword(), 
				user.getPhonenumber(), 
				user.getRole(), 
				user.getAddress());
	}
	public static User mapToUser(UserDTO userDTO) {
		return new User(
				userDTO.getAccountId(),
				userDTO.getUsername(),
				userDTO.getFullname(),
				userDTO.getEmail(),
				userDTO.getPassword(),
				userDTO.getPhonenumber(),
				userDTO.getRole(),
				userDTO.getAddress()
				);
	}
}
