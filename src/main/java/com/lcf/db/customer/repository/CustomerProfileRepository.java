package com.lcf.db.customer.repository;

import com.lcf.db.customer.dto.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, String> {
}
