package com.kb.location.service.impl;

import com.kb.location.dto.request.VoitureRequest;
import com.kb.location.dto.response.VoitureResponse;
import com.kb.location.entity.Voiture;
import com.kb.location.mapper.VoitureMapper;
import com.kb.location.repository.ModeleRepository;
import com.kb.location.repository.TypeRepository;
import com.kb.location.repository.VoitureRepository;
import com.kb.location.service.VoitureService;
import com.kb.location.utils.GlobalResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class VoitureServiceImpl implements VoitureService {

    private final VoitureRepository repository;
    private final VoitureMapper mapper;
    private final ModeleRepository modeleRepository;
    private final TypeRepository typeRepository;

    public VoitureServiceImpl(VoitureRepository repository, VoitureMapper mapper, ModeleRepository modeleRepository, TypeRepository typeRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.modeleRepository = modeleRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public VoitureResponse create(VoitureRequest request) {
        Voiture entity = mapper.toEntity(request);
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public VoitureResponse update(UUID trackingId, VoitureRequest request) {
        Voiture entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Voiture non trouvé avec trackingId: " + trackingId));
        entity.setImmatriculation(request.getImmatriculation());
        entity.setPrixParJour(request.getPrixparjour());
        entity.setDisponiblite(request.getDisponiblite());
        entity.setModele(modeleRepository.findByTrackingId(request.getModeleId()).orElseThrow(() -> new RuntimeException("Modele non trouvé avec trackingId")));
        entity.setType(typeRepository.findByTrackingId(request.getTypeId()).orElseThrow(() -> new RuntimeException("Type non trouvé avec trackingId")));
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public VoitureResponse findById(UUID trackingId) {
        Voiture entity = repository.findByTrackingId(trackingId)
            .orElseThrow(() -> new RuntimeException("Voiture non trouvé avec trackingId: " + trackingId));
        return mapper.toResponse(entity);
    }

    @Override
    public List<VoitureResponse> findAll() {
        List<Voiture> entities = repository.findAllOrdered();
        return entities.stream()
            .map(mapper::toResponse)
            .toList();
    }

    @Override
    public void delete(UUID trackingId) {
        Voiture entity = repository.findByTrackingId(trackingId)
            .orElseThrow(() -> new RuntimeException("Voiture non trouvé avec trackingId: " + trackingId));
        repository.delete(entity);
    }
}