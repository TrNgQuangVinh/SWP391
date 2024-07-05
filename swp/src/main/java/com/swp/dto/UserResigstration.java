package com.swp.dto;

import java.util.Objects;

public class UserResigstration {
	private String email;
	private String username;
	private String fullname;
	private String password;
	private String phonenumber;
	private String role;
	private String address;
	public UserResigstration() {
		super();
	}
	public UserResigstration(String email, String username, String fullname, String password, String phonenumber,
			String role, String address) {
		super();
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
		this.phonenumber = phonenumber;
		this.role = role;
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, email, fullname, password, phonenumber, role, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserResigstration other = (UserResigstration) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(fullname, other.fullname) && Objects.equals(password, other.password)
				&& phonenumber == other.phonenumber && Objects.equals(role, other.role)
				&& Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "UserResigstration [email=" + email + ", username=" + username + ", fullname=" + fullname + ", password="
				+ password + ", phonenumber=" + phonenumber + ", role=" + role + ", address=" + address + "]";
	}

	

}
