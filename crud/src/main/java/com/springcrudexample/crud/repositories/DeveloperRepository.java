package com.springcrudexample.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcrudexample.crud.models.DeveloperModel;

@Repository
public interface DeveloperRepository extends JpaRepository<DeveloperModel, Long> {

}
