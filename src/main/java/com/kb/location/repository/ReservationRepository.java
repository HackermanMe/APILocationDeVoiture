package com.kb.location.repository;

import com.kb.location.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.UUID;
import java.util.Optional;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT e FROM Reservation e WHERE e.trackingId = :trackingId")
    Optional<Reservation> findByTrackingId(@Param("trackingId") UUID trackingId);
    
    @Query("SELECT e FROM Reservation e ORDER BY e.id")
    List<Reservation> findAllOrdered();
}