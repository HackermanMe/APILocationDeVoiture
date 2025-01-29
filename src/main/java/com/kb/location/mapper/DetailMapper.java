package com.kb.location.mapper;

import com.kb.location.dto.request.DetailRequest;
import com.kb.location.dto.response.DetailResponse;
import com.kb.location.dto.response.ReservationResponse;
import com.kb.location.entity.Detail;
import com.kb.location.repository.ReservationRepository;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class DetailMapper {
    private final ReservationRepository reservationRepository;

    public DetailMapper(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Detail toEntity(DetailRequest request) {
        if (request == null) {
            return null;
        }
        
        Detail entity = new Detail();
        entity.setTrackingId(UUID.randomUUID());
        if (request.getReservationId() != null) {
            entity.setReservation(reservationRepository.findByTrackingId(request.getReservationId())
                .orElseThrow(() -> new RuntimeException("Reservation non trouvé avec trackingId: " + request.getReservationId())));
        }
        entity.setPrixTotale(request.getPrixtotale());
        return entity;
    }
    
    public DetailResponse toResponse(Detail entity) {
        if (entity == null) {
            return null;
        }
        
        DetailResponse response = new DetailResponse();
        response.setTrackingid(entity.getTrackingId());
        if (entity.getReservation() != null) {
            ReservationResponse r = new ReservationResponse();
            r.setTrackingid(entity.getReservation().getTrackingId());
            response.setReservation(r);
        }
        response.setPrixtotale(entity.getPrixTotale());
        return response;
    }
}