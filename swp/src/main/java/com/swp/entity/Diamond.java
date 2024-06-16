package com.swp.entity;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "Diamonds")
public class Diamond {
	@Id
	@Column(name = "DiamondID")
	private String diamondId;
	@Column
	private float caratWeight;
	@Column
	private String color;
	@Column
	private String cut;
	@Column
	private String clarity;
	@Column
	private float price;
	@Column
	private int quantity;
//	@JsonIgnore
	@OneToMany(mappedBy = "diamondId", fetch = FetchType.LAZY)
	private List<Product> products;
	@Override
	public int hashCode() {
		return Objects.hash(caratWeight, clarity, color, cut, diamondId, price, products ,quantity);
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
				&& Objects.equals(products, other.products) && quantity == other.quantity;
	}
	@Override
	public String toString() {
		return "Diamond [diamondId=" + diamondId + ", caratWeight=" + caratWeight + ", color=" + color + ", cut=" + cut
				+ ", clarity=" + clarity + ", price=" + price + ", quantity=" + quantity + ", products=" + products
				+ "]";
	}
	
}
