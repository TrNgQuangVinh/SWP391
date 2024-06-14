package com.swp.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
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
@Table(name = "Categories")
public class Category {
	@Id
	private String CategoryId;
	private String CategoryName;
	@OneToMany(mappedBy = "categoryId")
	private List<Product> products;

	@Override
	public int hashCode() {
		return Objects.hash(CategoryId, CategoryName, products);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(CategoryId, other.CategoryId) && Objects.equals(CategoryName, other.CategoryName)
				&& Objects.equals(products, other.products);
	}

	@Override
	public String toString() {
		return "Category [CategoryId=" + CategoryId + ", CategoryName=" + CategoryName + ", products=" + products + "]";
	}

}
