package com.kb.location.repository;

import com.kb.location.entity.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.UUID;
import java.util.Optional;
import java.util.List;

public interface DetailRepository extends JpaRepository<Detail, Long> {
    @Query("SELECT e FROM Detail e WHERE e.trackingId = :trackingId")
    Optional<Detail> findByTrackingId(@Param("trackingId") UUID trackingId);
    
    @Query("SELECT e FROM Detail e ORDER BY e.id")
    List<Detail> findAllOrdered();
}