package com.kb.location.repository;

import com.kb.location.entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.UUID;
import java.util.Optional;
import java.util.List;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
    @Query("SELECT e FROM Voiture e WHERE e.trackingId = :trackingId")
    Optional<Voiture> findByTrackingId(@Param("trackingId") UUID trackingId);
    
    @Query("SELECT e FROM Voiture e ORDER BY e.id")
    List<Voiture> findAllOrdered();
}