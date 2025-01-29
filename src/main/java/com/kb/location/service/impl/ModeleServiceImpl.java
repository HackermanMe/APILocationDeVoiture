package com.kb.location.service.impl;

import com.kb.location.dto.request.ModeleRequest;
import com.kb.location.dto.response.ModeleResponse;
import com.kb.location.entity.Modele;
import com.kb.location.mapper.ModeleMapper;
import com.kb.location.repository.MarqueRepository;
import com.kb.location.repository.ModeleRepository;
import com.kb.location.service.ModeleService;
import com.kb.location.utils.GlobalResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ModeleServiceImpl implements ModeleService {

    private final ModeleRepository repository;
    private final ModeleMapper mapper;
    private final MarqueRepository marqueRepository;

    public ModeleServiceImpl(ModeleRepository repository, ModeleMapper mapper, MarqueRepository marqueRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.marqueRepository = marqueRepository;
    }

    @Override
    public ModeleResponse create(ModeleRequest request) {
        Modele entity = mapper.toEntity(request);
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public ModeleResponse update(UUID trackingId, ModeleRequest request) {
        Modele entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Modele non trouvé avec trackingId: " + trackingId));
        entity.setNom(request.getNom());
        entity.setMarque(marqueRepository.findByTrackingId(request.getMarqueId()).orElseThrow(() -> new RuntimeException("Marque non trouvé")));
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public ModeleResponse findById(UUID trackingId) {
        Modele entity = repository.findByTrackingId(trackingId)
            .orElseThrow(() -> new RuntimeException("Modele non trouvé avec trackingId: " + trackingId));
        return mapper.toResponse(entity);
    }

    @Override
    public List<ModeleResponse> findAll() {
        List<Modele> entities = repository.findAllOrdered();
        return entities.stream()
            .map(mapper::toResponse)
            .toList();
    }

    @Override
    public void delete(UUID trackingId) {
        Modele entity = repository.findByTrackingId(trackingId)
            .orElseThrow(() -> new RuntimeException("Modele non trouvé avec trackingId: " + trackingId));
        repository.delete(entity);
    }
}