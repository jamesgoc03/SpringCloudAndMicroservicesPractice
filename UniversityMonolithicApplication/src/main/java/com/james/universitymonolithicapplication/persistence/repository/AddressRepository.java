package com.james.universitymonolithicapplication.persistence.repository;

import com.james.universitymonolithicapplication.persistence.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
