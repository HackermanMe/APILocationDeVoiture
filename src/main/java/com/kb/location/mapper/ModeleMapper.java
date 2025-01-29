package com.kb.location.mapper;

import com.kb.location.dto.request.ModeleRequest;
import com.kb.location.dto.response.MarqueResponse;
import com.kb.location.dto.response.ModeleResponse;
import com.kb.location.entity.Marque;
import com.kb.location.entity.Modele;
import com.kb.location.repository.MarqueRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class ModeleMapper {
    private final MarqueRepository marqueRepository;

    public ModeleMapper(MarqueRepository marqueRepository) {
        this.marqueRepository = marqueRepository;
    }

    public Modele toEntity(ModeleRequest request) {
        if (request == null) {
            return null;
        }
        
        Modele entity = new Modele();
        entity.setTrackingId(UUID.randomUUID());
        entity.setNom(request.getNom());
        if (request.getMarqueId() != null) {
            entity.setMarque(marqueRepository.findByTrackingId(request.getMarqueId())
                .orElseThrow(() -> new RuntimeException("Marque non trouvé avec trackingId: " + request.getMarqueId())));
        }
        return entity;
    }
    
    public ModeleResponse toResponse(Modele entity) {
        if (entity == null) {
            return null;
        }
        
        ModeleResponse response = new ModeleResponse();
        response.setTrackingid(entity.getTrackingId());
        response.setNom(entity.getNom());
        if (entity.getMarque() != null) {
            MarqueResponse r = new MarqueResponse();
            r.setTrackingid(entity.getMarque().getTrackingId());
            response.setMarque(r);
        }
        return response;
    }
}