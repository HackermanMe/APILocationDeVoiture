package com.kb.location.mapper;

import com.kb.location.dto.request.VoitureRequest;
import com.kb.location.dto.response.ModeleResponse;
import com.kb.location.dto.response.TypeResponse;
import com.kb.location.dto.response.VoitureResponse;
import com.kb.location.entity.Modele;
import com.kb.location.entity.Type;
import com.kb.location.entity.Voiture;
import com.kb.location.repository.ModeleRepository;
import com.kb.location.repository.TypeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class VoitureMapper {
    private final ModeleRepository modeleRepository;
    private final TypeRepository typeRepository;

    public VoitureMapper(ModeleRepository modeleRepository, TypeRepository typeRepository) {
        this.modeleRepository = modeleRepository;
        this.typeRepository = typeRepository;
    }

    public Voiture toEntity(VoitureRequest request) {
        if (request == null) {
            return null;
        }
        
        Voiture entity = new Voiture();
        entity.setTrackingId(UUID.randomUUID());
        if (request.getModeleId() != null) {
            entity.setModele(modeleRepository.findByTrackingId(request.getModeleId())
                .orElseThrow(() -> new RuntimeException("Modele non trouvé avec trackingId: " + request.getModeleId())));
        }
        if (request.getTypeId() != null) {
            entity.setType(typeRepository.findByTrackingId(request.getTypeId())
                .orElseThrow(() -> new RuntimeException("Type non trouvé avec trackingId: " + request.getTypeId())));
        }
        entity.setAnneeFabrication(request.getAnneefabrication());
        entity.setImmatriculation(request.getImmatriculation());
        entity.setPrixParJour(request.getPrixparjour());
        entity.setDisponiblite(request.getDisponiblite());
        return entity;
    }
    
    public VoitureResponse toResponse(Voiture entity) {
        if (entity == null) {
            return null;
        }
        
        VoitureResponse response = new VoitureResponse();
        response.setTrackingid(entity.getTrackingId());
        if (entity.getModele() != null) {
            ModeleResponse r = new ModeleResponse();
            r.setTrackingid(entity.getModele().getTrackingId());
            response.setModele(r);
        }
        if (entity.getType() != null) {
            TypeResponse r = new TypeResponse();
            r.setTrackingid(entity.getType().getTrackingId());
            response.setType(r);
        }
        response.setAnneefabrication(entity.getAnneeFabrication());
        response.setImmatriculation(entity.getImmatriculation());
        response.setPrixparjour(entity.getPrixParJour());
        response.setDisponiblite(entity.isDisponiblite());
        return response;
    }
}