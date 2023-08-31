package com.claim.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.claim.Exception.PolicyNotFoundException;
import com.claim.dto.PolicyProvider;

@FeignClient(name = "Policy-Micro", url = "http://localhost:8410/policy")
public interface PolicyServiceClient {
	@GetMapping(value="/geteligibleclaimamount/{policyId}")
	public Integer getEligibleClaimAmount(@PathVariable("policyId") Integer policyId) throws PolicyNotFoundException;
	
	@GetMapping(value="/getallproviders/{policyId}")
	public List<PolicyProvider> getAllPolicyProviders(@PathVariable("policyId")Integer policyId);

}
