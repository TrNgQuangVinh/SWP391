package com.swp.entity;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Accounts")
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
				 && Objects.equals(role, other.role)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [accountId=" + accountId + ", username=" + username + ", fullname=" + fullname + ", email=" + email
				+ ", password=" + password + ", phonenumber=" + phonenumber + ", role=" + role + ", address=" + address
				+ ", products="  + "]";
	}
	
	
}
