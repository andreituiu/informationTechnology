package com.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Specialization;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Integer>{

}
