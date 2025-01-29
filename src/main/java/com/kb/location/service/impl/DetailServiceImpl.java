package com.kb.location.service.impl;

import com.kb.location.dto.request.DetailRequest;
import com.kb.location.dto.response.DetailResponse;
import com.kb.location.entity.Detail;
import com.kb.location.mapper.DetailMapper;
import com.kb.location.repository.DetailRepository;
import com.kb.location.repository.ReservationRepository;
import com.kb.location.service.DetailService;
import com.kb.location.utils.GlobalResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DetailServiceImpl implements DetailService {

    private final DetailRepository repository;
    private final DetailMapper mapper;
    private final ReservationRepository reservationRepository;

    public DetailServiceImpl(DetailRepository repository, DetailMapper mapper, ReservationRepository reservationRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public DetailResponse create(DetailRequest request) {
        Detail entity = mapper.toEntity(request);
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public DetailResponse update(UUID trackingId, DetailRequest request) {
        Detail entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Detail non trouvé avec trackingId: " + trackingId));
        entity.setReservation(reservationRepository.findByTrackingId(request.getReservationId()).orElseThrow(() -> new RuntimeException("Réservation non trouvé")));;
        entity.setPrixTotale(entity.getPrixTotale());
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public DetailResponse findById(UUID trackingId) {
        Detail entity = repository.findByTrackingId(trackingId)
            .orElseThrow(() -> new RuntimeException("Detail non trouvé avec trackingId: " + trackingId));
        return mapper.toResponse(entity);
    }

    @Override
    public List<DetailResponse> findAll() {
        List<Detail> entities = repository.findAllOrdered();
        return entities.stream()
            .map(mapper::toResponse)
            .toList();
    }

    @Override
    public void delete(UUID trackingId) {
        Detail entity = repository.findByTrackingId(trackingId)
            .orElseThrow(() -> new RuntimeException("Detail non trouvé avec trackingId: " + trackingId));
        repository.delete(entity);
    }
}