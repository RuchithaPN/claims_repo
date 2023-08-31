package com.claim.Main;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="Claim")
public class Claim {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer claimNo;
	private String status;
	private String remarks;
	private String policyBenefits;
	private String hospitalName;
	private Integer benefitsAvailed;
	private Integer amount;
	private Integer policyId;
	private String policyName;
	public Integer getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(Integer claimNo) {
		this.claimNo = claimNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPolicyBenefits() {
		return policyBenefits;
	}
	public void setPolicyBenefits(Object object) {
		
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(Object object) {
	
	}
	public Integer getBenefitsAvailed() {
		return benefitsAvailed;
	}
	public void setBenefitsAvailed(Object object) {
		
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Object object) {
	
	}
	public Integer getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(Object object) {
	
	}


}
