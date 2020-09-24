package com.example.elderly_support.repository;

import com.example.elderly_support.model.entity1.SocialWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialWorkerRepository extends JpaRepository<SocialWorker, Long> {
}
