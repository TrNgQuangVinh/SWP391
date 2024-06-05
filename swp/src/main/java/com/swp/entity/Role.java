package com.swp.entity;

import java.util.Collection;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Roles")
public class Role {
	@Id
	@Column(name = "RoleID")
	private String role;
	private String roleName;
	
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<User> users;
	
	public Role() {
		super();
	}

	public Role(String role, String roleName) {
		super();
		this.role = role;
		this.roleName = roleName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(role, roleName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(role, other.role) && Objects.equals(roleName, other.roleName);
	}

	@Override
	public String toString() {
		return "Role [role=" + role + ", roleName=" + roleName + "]";
	}

}
