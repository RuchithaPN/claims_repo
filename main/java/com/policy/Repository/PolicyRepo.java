package com.policy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.policy.Main.Policy;

@Repository
public interface PolicyRepo extends JpaRepository<Policy,Integer> {

}
