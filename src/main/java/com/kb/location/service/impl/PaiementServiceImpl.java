package com.kb.location.service.impl;

import com.kb.location.dto.request.PaiementRequest;
import com.kb.location.dto.response.PaiementResponse;
import com.kb.location.entity.Paiement;
import com.kb.location.mapper.PaiementMapper;
import com.kb.location.repository.PaiementRepository;
import com.kb.location.repository.ReservationRepository;
import com.kb.location.service.PaiementService;
import com.kb.location.utils.GlobalResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PaiementServiceImpl implements PaiementService {

    private final PaiementRepository repository;
    private final PaiementMapper mapper;
    private final ReservationRepository reservationRepository;

    public PaiementServiceImpl(PaiementRepository repository, PaiementMapper mapper, ReservationRepository reservationRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public PaiementResponse create(PaiementRequest request) {
        Paiement entity = mapper.toEntity(request);
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public PaiementResponse update(UUID trackingId, PaiementRequest request) {
        Paiement entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Paiement non trouvé avec trackingId: " + trackingId));
        entity.setDatePaiement(request.getDatepaiement());
        entity.setMontant(request.getMontant());
        entity.setMoyenPaiement(request.getMoyenpaiement());
        entity.setReservation(reservationRepository.findByTrackingId(request.getReservationId()).orElseThrow(() -> new RuntimeException("Reservation non trouvé avec trackingId: " + request.getReservationId())));
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public PaiementResponse findById(UUID trackingId) {
        Paiement entity = repository.findByTrackingId(trackingId)
            .orElseThrow(() -> new RuntimeException("Paiement non trouvé avec trackingId: " + trackingId));
        return mapper.toResponse(entity);
    }

    @Override
    public List<PaiementResponse> findAll() {
        List<Paiement> entities = repository.findAllOrdered();
        return entities.stream()
            .map(mapper::toResponse)
            .toList();
    }

    @Override
    public void delete(UUID trackingId) {
        Paiement entity = repository.findByTrackingId(trackingId)
            .orElseThrow(() -> new RuntimeException("Paiement non trouvé avec trackingId: " + trackingId));
        repository.delete(entity);
    }
}