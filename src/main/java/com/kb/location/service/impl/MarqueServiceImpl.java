package com.kb.location.service.impl;

import com.kb.location.dto.request.MarqueRequest;
import com.kb.location.dto.response.MarqueResponse;
import com.kb.location.entity.Marque;
import com.kb.location.mapper.MarqueMapper;
import com.kb.location.repository.MarqueRepository;
import com.kb.location.service.MarqueService;
import com.kb.location.utils.GlobalResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class MarqueServiceImpl implements MarqueService {

    private final MarqueRepository repository;
    private final MarqueMapper mapper;

    public MarqueServiceImpl(MarqueRepository repository, MarqueMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public MarqueResponse create(MarqueRequest request) {
        Marque entity = mapper.toEntity(request);
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public MarqueResponse update(UUID trackingId, MarqueRequest request) {
        Marque entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Marque non trouvé avec trackingId: " + trackingId));
        entity.setNom(request.getNom());
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public MarqueResponse findById(UUID trackingId) {
        Marque entity = repository.findByTrackingId(trackingId)
            .orElseThrow(() -> new RuntimeException("Marque non trouvé avec trackingId: " + trackingId));
        return mapper.toResponse(entity);
    }

    @Override
    public List<MarqueResponse> findAll() {
        List<Marque> entities = repository.findAllOrdered();
        return entities.stream()
            .map(mapper::toResponse)
            .toList();
    }

    @Override
    public void delete(UUID trackingId) {
        Marque entity = repository.findByTrackingId(trackingId)
            .orElseThrow(() -> new RuntimeException("Marque non trouvé avec trackingId: " + trackingId));
        repository.delete(entity);
    }
}