package com.policy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.policy.Main.Hospital;
import com.policy.Main.Policy;
import com.policy.Service.PolicyServiceImpl;
import com.policy.feign.AuthClient;

@RestController
@CrossOrigin(origins = "*")
public class PolicyController {

	@Autowired
	PolicyServiceImpl service;

	@Autowired
	private AuthClient client;
	
	@GetMapping("/getchainofproviders/{policyId}")
	public List<Hospital> getChainOfProviders( @PathVariable int policyId){
			
			return service.findAllHospitals(policyId);
		}
	@GetMapping("/getEligibleBenefits/{policyId}/{memberId}")
	public Policy getEligibleBenefits(@PathVariable int memberId,@PathVariable int policyId) {
			return service.getEligibleBenefits(policyId, memberId);
	}
	
	@GetMapping("/getEligibleClaimAmount/{policyId}/{memberId}/{benefits}")
	public int getEligibleClaimAmount(@PathVariable int benefits,@PathVariable int policyId,@PathVariable int memberId) {
				return service.getEligibleClaimAmount(policyId, memberId, benefits);
		
	}
}
