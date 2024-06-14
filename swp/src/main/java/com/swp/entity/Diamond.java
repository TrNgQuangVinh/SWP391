package com.swp.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
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
@Table(name = "Diamonds")
public class Diamond {
	@Id
	@Column(name = "DiamondID")
	private String diamondId;
	private float caratWeight;
	private String color;
	private String cut;
	private String clarity;
	private float price;
	private int qunatity;
	@OneToMany(mappedBy = "diamondId")
	private List<Product> products;
	@Override
	public int hashCode() {
		return Objects.hash(caratWeight, clarity, color, cut, diamondId, price, products, qunatity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diamond other = (Diamond) obj;
		return Float.floatToIntBits(caratWeight) == Float.floatToIntBits(other.caratWeight)
				&& Objects.equals(clarity, other.clarity) && Objects.equals(color, other.color)
				&& Objects.equals(cut, other.cut) && Objects.equals(diamondId, other.diamondId)
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& Objects.equals(products, other.products) && qunatity == other.qunatity;
	}
	@Override
	public String toString() {
		return "Diamond [diamondId=" + diamondId + ", caratWeight=" + caratWeight + ", color=" + color + ", cut=" + cut
				+ ", clarity=" + clarity + ", price=" + price + ", qunatity=" + qunatity + ", products=" + products
				+ "]";
	}
	
}
