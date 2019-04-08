package com.example.demo.dao;

import com.example.demo.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    public Person findByPersonName(String personName);
}
