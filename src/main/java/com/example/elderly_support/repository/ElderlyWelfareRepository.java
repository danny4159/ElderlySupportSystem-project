package com.example.elderly_support.repository;

import com.example.elderly_support.model.entity1.ElderlyWelfare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElderlyWelfareRepository extends JpaRepository<ElderlyWelfare, Long> {
}
