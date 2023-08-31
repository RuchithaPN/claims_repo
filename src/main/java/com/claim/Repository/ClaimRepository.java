package com.claim.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claim.Main.Claim;
import com.claim.dto.ClaimInput;

public interface ClaimRepository extends JpaRepository<Claim, Integer>{

	void save(Integer claimId);

	Object save(ClaimInput claim1);

}
