package com.policy.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policy.Main.Hospital;
import com.policy.Main.MemberPolicy;
import com.policy.Main.Policy;
import com.policy.Repository.HospitalRepo;
import com.policy.Repository.MemberPolicyRepo;
import com.policy.Repository.PolicyRepo;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	PolicyRepo policyRepo;
	@Autowired
	HospitalRepo hospitalRepo;
	@Autowired
	MemberPolicyRepo memberPolicyRepo;

	@Override
	public List<Hospital> findAllHospitals(int policyId) {
		List<Hospital> hospitals = new ArrayList<>();
		for (Hospital hospital : hospitalRepo.findAll()) {
			if (hospital.getPolicyId() == policyId)
				hospitals.add(hospital);
			return hospitals;
		}
		return hospitals;
	}

	@Override
	public Policy getEligibleBenefits(int policyId, int memberId) {
		Optional<MemberPolicy> optionalMemberPolicy = memberPolicyRepo.findById(memberId);
		Optional<Policy> optionalPolicy = policyRepo.findById(policyId);
		if (optionalMemberPolicy.isPresent() && optionalPolicy.isPresent()) {
			MemberPolicy memberPolicy = optionalMemberPolicy.get();
			Policy policy = optionalPolicy.get();
			if (memberPolicy.getPolicyId() == policyId) {
				return policy;
			}
		}
		return null;
	}

	@Override
	public int getEligibleClaimAmount(int policyId, int memberId, int benefits) {
		Optional<Policy> optionalPolicy = policyRepo.findById(policyId);
		Optional<MemberPolicy> optionalMemberPolicy = memberPolicyRepo.findById(memberId);
		if (optionalMemberPolicy.isPresent() && optionalPolicy.isPresent()) {
			int cap = optionalMemberPolicy.get().getCapAmount();
			int benefit = optionalPolicy.get().getBenefits();
			return cap * benefit / 100;
		}
		return 0;
	}

}
