package com.policy.Main;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member_policy")
public class MemberPolicy {
	
	@Id 
	@GeneratedValue
	private int memberId;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate subsDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate premiumDueDate;
	private int capAmount;
	private int policyId;
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getSubsDate() {
		return subsDate;
	}
	public void setSubsDate(LocalDate subsDate) {
		this.subsDate = subsDate;
	}
	public LocalDate getPremiumDueDate() {
		return premiumDueDate;
	}
	public void setPremiumDueDate(LocalDate premiumDueDate) {
		this.premiumDueDate = premiumDueDate;
	}
	public int getCapAmount() {
		return capAmount;
	}
	public void setCapAmount(int capAmount) {
		this.capAmount = capAmount;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}


}
