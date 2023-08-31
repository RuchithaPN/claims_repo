package com.claim.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.claim.Exception.ClaimNotFoundException;
import com.claim.Exception.PolicyNotFoundException;
import com.claim.Main.Claim;
import com.claim.Service.ClaimService;
import com.claim.dto.ClaimInput;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClaimController {
	@Autowired
	ClaimService service;
	@GetMapping(value="/getclaimstatus/{claimNo}")
	public Claim getClaimStatus(@PathVariable("claimNo") Integer claimNo) throws ClaimNotFoundException {
		return service.getClaimStatus(claimNo);
	}
	
	@PostMapping(value="/submitclaim")
	public Claim submitClaim(@RequestBody ClaimInput claim) throws PolicyNotFoundException {
		return service.submitClaim(claim);
	}

}
