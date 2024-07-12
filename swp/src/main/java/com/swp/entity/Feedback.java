package com.swp.entity;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "Feedback")
public class Feedback {
	@Id
	@Column(name = "FeedbackID")
	private String feedbackId;
	@Column
	private String feedbackContent;
	@Column
	private float rating;
	@Column(name = "ProductID")
	private String productId;
	@Column(name = "AccountID")
	private String accountId;
	@Column
	private Timestamp Date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "accountId", referencedColumnName="AccountID")
	@JoinColumn(name = "productId", referencedColumnName="ProductID")

	@Override
	public int hashCode() {
		return Objects.hash(Date, accountId, feedbackContent, feedbackId, productId, rating);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Feedback other = (Feedback) obj;
		return Objects.equals(Date, other.Date) && Objects.equals(accountId, other.accountId)
				&& Objects.equals(feedbackContent, other.feedbackContent)
				&& Objects.equals(feedbackId, other.feedbackId) && Objects.equals(productId, other.productId)
				&& Float.floatToIntBits(rating) == Float.floatToIntBits(other.rating);
	}
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", feedbackContent=" + feedbackContent + ", rating=" + rating
				+ ", productId=" + productId + ", accountId=" + accountId + ", Date=" + Date + "]";
	}

}
