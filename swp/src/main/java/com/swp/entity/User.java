package com.swp.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Accounts")
public class User {
	@Id
	@Column(name = "AccountID")
	private String accountId;
	private String username;
	private String fullname;
	private String email;
	private String password;
	private int phonenumber;
	private String role;
	private String address;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RoleID", referencedColumnName = "id")
	
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
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
	public String toString() {
		return "User [accountId=" + accountId + ", username=" + username + ", fullname=" + fullname + ", email=" + email
				+ ", password=" + password + ", phonenumber=" + phonenumber + ", role=" + role + ", address=" + address
				+ "]";
	}

	public User() {
		super();
	}

	public User(String accountId, String username, String fullname, String email, String password, int phonenumber,
			String role, String address) {
		super();
		this.accountId = accountId;
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.phonenumber = phonenumber;
		this.role = role;
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountId, address, email, fullname, password, phonenumber, role, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(accountId, other.accountId) && Objects.equals(address, other.address)
				&& Objects.equals(email, other.email) && Objects.equals(fullname, other.fullname)
				&& Objects.equals(password, other.password) && phonenumber == other.phonenumber
				&& Objects.equals(role, other.role) && Objects.equals(username, other.username);
	}

}
