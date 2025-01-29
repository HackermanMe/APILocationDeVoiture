package com.kb.location.service.impl;

import com.kb.location.dto.request.TypeRequest;
import com.kb.location.dto.response.TypeResponse;
import com.kb.location.entity.Type;
import com.kb.location.mapper.TypeMapper;
import com.kb.location.repository.TypeRepository;
import com.kb.location.service.TypeService;
import com.kb.location.utils.GlobalResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    private final TypeRepository repository;
    private final TypeMapper mapper;

    public TypeServiceImpl(TypeRepository repository, TypeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TypeResponse create(TypeRequest request) {
        Type entity = mapper.toEntity(request);
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public TypeResponse update(UUID trackingId, TypeRequest request) {
        Type entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Type non trouvé avec trackingId: " + trackingId));
        entity.setNom(request.getNom());
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public TypeResponse findById(UUID trackingId) {
        Type entity = repository.findByTrackingId(trackingId)
            .orElseThrow(() -> new RuntimeException("Type non trouvé avec trackingId: " + trackingId));
        return mapper.toResponse(entity);
    }

    @Override
    public List<TypeResponse> findAll() {
        List<Type> entities = repository.findAllOrdered();
        return entities.stream()
            .map(mapper::toResponse)
            .toList();
    }

    @Override
    public void delete(UUID trackingId) {
        Type entity = repository.findByTrackingId(trackingId)
            .orElseThrow(() -> new RuntimeException("Type non trouvé avec trackingId: " + trackingId));
        repository.delete(entity);
    }
}