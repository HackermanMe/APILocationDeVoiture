package com.kb.location.repository;

import com.kb.location.entity.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.UUID;
import java.util.Optional;
import java.util.List;

public interface ModeleRepository extends JpaRepository<Modele, Long> {
    @Query("SELECT e FROM Modele e WHERE e.trackingId = :trackingId")
    Optional<Modele> findByTrackingId(@Param("trackingId") UUID trackingId);
    
    @Query("SELECT e FROM Modele e ORDER BY e.id")
    List<Modele> findAllOrdered();
}