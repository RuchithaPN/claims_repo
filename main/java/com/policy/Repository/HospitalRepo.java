package com.policy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.policy.Main.Hospital;

@Repository
public interface HospitalRepo extends JpaRepository<Hospital, Integer> {

}
