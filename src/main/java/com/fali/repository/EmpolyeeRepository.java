package com.fali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fali.model.Empolyee;
@Repository
public interface EmpolyeeRepository extends JpaRepository<Empolyee, Long>{

}
