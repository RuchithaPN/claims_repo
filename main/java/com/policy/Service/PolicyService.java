package com.policy.Service;

import java.util.List;

import com.policy.Main.Hospital;
import com.policy.Main.Policy;

public interface PolicyService {

	List<Hospital> findAllHospitals(int policyId);

	Policy getEligibleBenefits(int policyId, int memberId);

	int getEligibleClaimAmount(int policyId, int memberId, int benefits);
}