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
@Table(name = "Material")
public class Material {
	@Id
	@Column(name="MaterialID")
	private String materialId;
	@Column
	private String materialName;
	
	@OneToMany(mappedBy = "materialId", fetch = FetchType.LAZY)
	
	@Override
	public int hashCode() {
		return Objects.hash(materialId, materialName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		return Objects.equals(materialId, other.materialId) && Objects.equals(materialName, other.materialName);
	}
	@Override
	public String toString() {
		return "Material [materialId=" + materialId + ", materialName=" + materialName + "]";
	}
	
}
