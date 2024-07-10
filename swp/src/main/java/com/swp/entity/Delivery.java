package com.swp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Deliveries")
public class Delivery {
	@Id
	@Column(name = "DeliveryID")
	private String deliveryId;
	private String orderId;
	private String accountId;
	private String address;
	private int statusId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
	@JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
	@JoinColumn(name = "StatusID", referencedColumnName = "StatusID")
	@Override
	public String toString() {
		return "Delivery [deliveryId=" + deliveryId + ", orderId=" + orderId + ", accountId=" + accountId + ", address="
				+ address + ", statusId=" + statusId + "]";
	}

}
