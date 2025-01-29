package com.kb.location.mapper;

import com.kb.location.dto.request.ReservationRequest;
import com.kb.location.dto.response.ClientResponse;
import com.kb.location.dto.response.ReservationResponse;
import com.kb.location.dto.response.VoitureResponse;
import com.kb.location.entity.Client;
import com.kb.location.entity.Reservation;
import com.kb.location.entity.Voiture;
import com.kb.location.repository.ClientRepository;
import com.kb.location.repository.VoitureRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    private final ClientRepository clientRepository;
    private final VoitureRepository voitureRepository;

    public ReservationMapper(ClientRepository clientRepository, VoitureRepository voitureRepository) {
        this.clientRepository = clientRepository;
        this.voitureRepository = voitureRepository;
    }

    public Reservation toEntity(ReservationRequest request) {
        if (request == null) {
            return null;
        }
        
        Reservation entity = new Reservation();
        entity.setTrackingId(UUID.randomUUID());
        if (request.getClientId() != null) {
            entity.setClient(clientRepository.findByTrackingId(request.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec trackingId: " + request.getClientId())));
        }
        if (request.getVoitureId() != null) {
            entity.setVoiture(voitureRepository.findByTrackingId(request.getVoitureId())
                .orElseThrow(() -> new RuntimeException("Voiture non trouvé avec trackingId: " + request.getVoitureId())));
        }
        entity.setDateDebut(request.getDatedebut());
        entity.setDateFin(request.getDatefin());
        entity.setStatut(request.getStatut());
        return entity;
    }
    
    public ReservationResponse toResponse(Reservation entity) {
        if (entity == null) {
            return null;
        }
        
        ReservationResponse response = new ReservationResponse();
        response.setTrackingid(entity.getTrackingId());
        if (entity.getClient() != null) {
            ClientResponse r = new ClientResponse();
            r.setTrackingid(entity.getClient().getTrackingId());
            response.setClient(r);
        }
        if (entity.getVoiture() != null) {
            VoitureResponse r = new VoitureResponse();
            r.setTrackingid(entity.getVoiture().getTrackingId());
            response.setVoiture(r);
        }
        response.setDatedebut(entity.getDateDebut());
        response.setDatefin(entity.getDateFin());
        response.setStatut(entity.getStatut());
        return response;
    }
}