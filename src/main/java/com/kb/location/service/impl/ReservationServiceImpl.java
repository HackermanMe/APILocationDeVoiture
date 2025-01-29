package com.kb.location.service.impl;

import com.kb.location.dto.request.ReservationRequest;
import com.kb.location.dto.response.ReservationResponse;
import com.kb.location.entity.Reservation;
import com.kb.location.mapper.ReservationMapper;
import com.kb.location.repository.ClientRepository;
import com.kb.location.repository.ReservationRepository;
import com.kb.location.repository.VoitureRepository;
import com.kb.location.service.ReservationService;
import com.kb.location.utils.GlobalResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;
    private final ReservationMapper mapper;
    private final ClientRepository clientRepository;
    private final VoitureRepository voitureRepository; 

    public ReservationServiceImpl(ReservationRepository repository, ReservationMapper mapper, ClientRepository clientRepository, VoitureRepository voitureRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.clientRepository = clientRepository;
        this.voitureRepository = voitureRepository;
    }

    @Override
    public ReservationResponse create(ReservationRequest request) {
        Reservation entity = mapper.toEntity(request);
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public ReservationResponse update(UUID trackingId, ReservationRequest request) {
        Reservation entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Reservation non trouvé avec trackingId: " + trackingId));
        entity.setClient(clientRepository.findByTrackingId(request.getClientId()).orElseThrow(() -> new RuntimeException("Client non trouvé")));
        entity.setVoiture(voitureRepository.findByTrackingId(request.getVoitureId()).orElseThrow(() -> new RuntimeException("Voiture non trouvé avec trackingId")));
        entity.setDateDebut(request.getDatedebut());
        entity.setDateFin(request.getDatefin());
        entity.setStatut(request.getStatut());
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public ReservationResponse findById(UUID trackingId) {
        Reservation entity = repository.findByTrackingId(trackingId)
            .orElseThrow(() -> new RuntimeException("Reservation non trouvé avec trackingId: " + trackingId));
        return mapper.toResponse(entity);
    }

    @Override
    public List<ReservationResponse> findAll() {
        List<Reservation> entities = repository.findAllOrdered();
        return entities.stream()
            .map(mapper::toResponse)
            .toList();
    }

    @Override
    public void delete(UUID trackingId) {
        Reservation entity = repository.findByTrackingId(trackingId)
            .orElseThrow(() -> new RuntimeException("Reservation non trouvé avec trackingId: " + trackingId));
        repository.delete(entity);
    }
    
}