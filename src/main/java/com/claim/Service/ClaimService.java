package com.claim.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claim.Client.PolicyServiceClient;
import com.claim.Exception.ClaimNotFoundException;
import com.claim.Exception.PolicyNotFoundException;
import com.claim.Main.Claim;
import com.claim.Repository.ClaimRepository;
import com.claim.dto.ClaimInput;
import com.claim.dto.PolicyProvider;


@Service
public class ClaimService {
	@Autowired
	ClaimRepository claimrepo;

	@Autowired
	PolicyServiceClient policyclient;
	public Claim getClaimStatus(Integer claimId) throws ClaimNotFoundException {
		Claim claim = claimrepo.findById(claimId).orElse(null);
		if(claim==null)
			throw new ClaimNotFoundException("Claim not found");
		else
			return claim;
	}
	public Claim submitClaim(ClaimInput claimInput) throws PolicyNotFoundException {
		int claimAmount = policyclient.getEligibleClaimAmount(claimInput.getPolicyId());
		List<PolicyProvider> list = policyclient.getAllPolicyProviders(claimInput.getPolicyId());
		boolean flag=false;
		for(PolicyProvider p:list) {
			if(p.getHospitalName().equalsIgnoreCase(claimInput.getHospitalName())) {
				flag=true;
				break;
			}
		}
		Claim claim=new Claim();
		claim.setAmount(claimInput.getAmount());
		claim.setBenefitsAvailed(claimInput.getBenefitsAvailed());
		claim.setHospitalName(claimInput.getHospitalName());
		claim.setPolicyBenefits(claimInput.getPolicyBenefits());
		claim.setPolicyId(claimInput.getPolicyId());
		claim.setPolicyName(claimInput.getPolicyName());		
		if(flag==true && claimAmount>=claimInput.getAmount()) {
			claim.setStatus("Sanctioned");
			claim.setRemarks("Please contact the branch office.");
		}
		else {
			claim.setStatus("Rejected");
			claim.setRemarks("Please check your eligibilty criteria");
		}
		claim=claimrepo.save(claim);
		return claim;		
	}

}