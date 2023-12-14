package com.policy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.policy.Main.MemberPolicy;

@Repository
public interface MemberPolicyRepo extends JpaRepository<MemberPolicy,Integer> {

}