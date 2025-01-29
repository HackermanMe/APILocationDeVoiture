package com.kb.location.service.impl;

import com.kb.location.dto.request.GerantRequest;
import com.kb.location.dto.response.GerantResponse;
import com.kb.location.entity.Gerant;
import com.kb.location.mapper.GerantMapper;
import com.kb.location.repository.GerantRepository;
import com.kb.location.service.GerantService;
import com.kb.location.utils.GlobalResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GerantServiceImpl implements GerantService {

    private final GerantRepository repository;
    private final GerantMapper mapper;

    public GerantServiceImpl(GerantRepository repository, GerantMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public GerantResponse create(GerantRequest request) {
        Gerant entity = mapper.toEntity(request);
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public GerantResponse update(UUID trackingId, GerantRequest request) {
        Gerant entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Gerant non trouvé avec trackingId: " + trackingId));
        entity = mapper.toEntity(request);
        entity.setNom(request.getNom());
        entity.setPrenoms(request.getPrenoms());
        entity.setEmail(request.getEmail());
        entity.setMotDePasse(request.getMotdepasse());
        return mapper.toResponse(entity);
    }

    @Override
    public GerantResponse findById(UUID trackingId) {
        Gerant entity = repository.findByTrackingId(trackingId)
            .orElseThrow(() -> new RuntimeException("Gerant non trouvé avec trackingId: " + trackingId));
        return mapper.toResponse(entity);
    }

    @Override
    public List<GerantResponse> findAll() {
        List<Gerant> entities = repository.findAllOrdered();
        return entities.stream()
            .map(mapper::toResponse)
            .toList();
    }

    @Override
    public void delete(UUID trackingId) {
        Gerant entity = repository.findByTrackingId(trackingId)
            .orElseThrow(() -> new RuntimeException("Gerant non trouvé avec trackingId: " + trackingId));
        repository.delete(entity);
    }
}