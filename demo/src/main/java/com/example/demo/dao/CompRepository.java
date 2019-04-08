package com.example.demo.dao;

import com.example.demo.bean.Comp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompRepository extends JpaRepository<Comp, Long> {
}
