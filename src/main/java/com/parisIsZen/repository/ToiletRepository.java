package com.parisIsZen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parisIsZen.model.Toilet;

@Repository
public interface ToiletRepository extends JpaRepository<Toilet, Long>{

}
