package com.kb.location.repository;

import com.kb.location.entity.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.UUID;
import java.util.Optional;
import java.util.List;

public interface GerantRepository extends JpaRepository<Gerant, Long> {
    @Query("SELECT e FROM Gerant e WHERE e.trackingId = :trackingId")
    Optional<Gerant> findByTrackingId(@Param("trackingId") UUID trackingId);
    
    @Query("SELECT e FROM Gerant e ORDER BY e.id")
    List<Gerant> findAllOrdered();
}