package com.muktai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muktai.model.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
