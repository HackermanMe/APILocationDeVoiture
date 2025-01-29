package com.kb.location.mapper;

import com.kb.location.dto.request.PaiementRequest;
import com.kb.location.dto.response.PaiementResponse;
import com.kb.location.dto.response.ReservationResponse;
import com.kb.location.entity.Paiement;
import com.kb.location.entity.Reservation;
import com.kb.location.repository.ReservationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class PaiementMapper {
    private final ReservationRepository reservationRepository;

    public PaiementMapper(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Paiement toEntity(PaiementRequest request) {
        if (request == null) {
            return null;
        }
        
        Paiement entity = new Paiement();
        entity.setTrackingId(UUID.randomUUID());
        if (request.getReservationId() != null) {
            entity.setReservation(reservationRepository.findByTrackingId(request.getReservationId())
                .orElseThrow(() -> new RuntimeException("Reservation non trouvé avec trackingId: " + request.getReservationId())));
        }
        entity.setMontant(request.getMontant());
        entity.setDatePaiement(request.getDatepaiement());
        entity.setMoyenPaiement(request.getMoyenpaiement());
        return entity;
    }
    
    public PaiementResponse toResponse(Paiement entity) {
        if (entity == null) {
            return null;
        }
        
        PaiementResponse response = new PaiementResponse();
        response.setTrackingid(entity.getTrackingId());
        if (entity.getReservation() != null) {
            ReservationResponse r = new ReservationResponse();
            r.setTrackingid(entity.getReservation().getTrackingId());
            response.setReservation(r);
        }
        response.setMontant(entity.getMontant());
        response.setDatepaiement(entity.getDatePaiement());
        response.setMoyenpaiement(entity.getMoyenPaiement());
        return response;
    }
}