package com.example.elderly_support.repository;

import com.example.elderly_support.model.entity1.Elderly;
import com.example.elderly_support.model.entity1.HistorySupport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistorySupportRepository extends JpaRepository<HistorySupport, Long> {

    Optional<HistorySupport> findByElderly(Optional<Elderly> byId);
}
