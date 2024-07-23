package com.swp.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Shells")
public class Shell {
	@Id
	@Column(name = "ShellID")
	private String shellId;
	@Column
	private String name;
	@Column
	private float ShellPrice;
	@Column
	private int quantity;
//	@JsonIgnore
	@OneToMany(mappedBy = "shellId", fetch = FetchType.LAZY)
	//private List<Product> products;

	@Override
	public int hashCode() {
		return Objects.hash(name, ShellPrice, /*products,*/ quantity, shellId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shell other = (Shell) obj;
		return  Objects.equals(name, other.name)
				&& Float.floatToIntBits(ShellPrice) == Float.floatToIntBits(other.ShellPrice)
				/*&& Objects.equals(products, other.products)*/ && quantity == other.quantity
				&& Objects.equals(shellId, other.shellId);
	}

	@Override
	public String toString() {
		return "Shell [shellId=" + shellId + ", name=" + name + ", price=" + ShellPrice
				+ ", quantity=" + quantity /*+ ", products=" + products */ + "]";
	}

}
