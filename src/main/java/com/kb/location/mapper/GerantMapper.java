package com.kb.location.mapper;

import com.kb.location.dto.request.GerantRequest;
import com.kb.location.dto.response.GerantResponse;
import com.kb.location.dto.response.ReservationResponse;
import com.kb.location.entity.Gerant;
import com.kb.location.entity.Reservation;
import com.kb.location.repository.ReservationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class GerantMapper {
    private final ReservationRepository reservationRepository;

    public GerantMapper(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Gerant toEntity(GerantRequest request) {
        if (request == null) {
            return null;
        }
        
        Gerant entity = new Gerant();
        entity.setTrackingId(UUID.randomUUID());
        if (request.getReservationId() != null) {
            entity.setReservation(reservationRepository.findByTrackingId(request.getReservationId())
                .orElseThrow(() -> new RuntimeException("Reservation non trouvé avec trackingId: " + request.getReservationId())));
        }
        entity.setNom(request.getNom());
        entity.setPrenoms(request.getPrenoms());
        entity.setEmail(request.getEmail());
        entity.setMotDePasse(request.getMotdepasse());
        return entity;
    }
    
    public GerantResponse toResponse(Gerant entity) {
        if (entity == null) {
            return null;
        }
        
        GerantResponse response = new GerantResponse();
        response.setTrackingid(entity.getTrackingId());
        if (entity.getReservation() != null) {
            ReservationResponse r = new ReservationResponse();
            r.setTrackingid(entity.getReservation().getTrackingId());
            response.setReservation(r);
        }
        response.setNom(entity.getNom());
        response.setPrenoms(entity.getPrenoms());
        response.setEmail(entity.getEmail());
        response.setMotdepasse(entity.getMotDePasse());
        return response;
    }
}