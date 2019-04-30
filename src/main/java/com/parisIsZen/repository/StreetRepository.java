package com.parisIsZen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parisIsZen.model.Street;

@Repository
public interface StreetRepository  extends JpaRepository<Street, Long> {

}
