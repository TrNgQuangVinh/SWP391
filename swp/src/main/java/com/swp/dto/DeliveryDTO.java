package com.swp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryDTO {
	private String deliveryId;
	private String orderId;
	private String accountId;
	private String address;
	private int statusId;

	@Override
	public String toString() {
		return "DeliveryDTO [deliveryId=" + deliveryId + ", orderId=" + orderId + ", accountId=" + accountId
				+ ", address=" + address + ", statusId=" + statusId + "]";
	}
}
