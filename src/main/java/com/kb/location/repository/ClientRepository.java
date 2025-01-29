package com.kb.location.repository;

import com.kb.location.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.UUID;
import java.util.Optional;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT e FROM Client e WHERE e.trackingId = :trackingId")
    Optional<Client> findByTrackingId(@Param("trackingId") UUID trackingId);
    
    @Query("SELECT e FROM Client e ORDER BY e.id")
    List<Client> findAllOrdered();
}