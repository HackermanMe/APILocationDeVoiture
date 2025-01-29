package com.kb.location.repository;

import com.kb.location.entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.UUID;
import java.util.Optional;
import java.util.List;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    @Query("SELECT e FROM Paiement e WHERE e.trackingId = :trackingId")
    Optional<Paiement> findByTrackingId(@Param("trackingId") UUID trackingId);
    
    @Query("SELECT e FROM Paiement e ORDER BY e.id")
    List<Paiement> findAllOrdered();
}