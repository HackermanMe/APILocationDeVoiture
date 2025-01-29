package com.kb.location.repository;

import com.kb.location.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.UUID;
import java.util.Optional;
import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Long> {
    @Query("SELECT e FROM Type e WHERE e.trackingId = :trackingId")
    Optional<Type> findByTrackingId(@Param("trackingId") UUID trackingId);
    
    @Query("SELECT e FROM Type e ORDER BY e.id")
    List<Type> findAllOrdered();
}