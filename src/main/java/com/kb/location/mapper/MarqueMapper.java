package com.kb.location.mapper;

import com.kb.location.dto.request.MarqueRequest;
import com.kb.location.dto.response.MarqueResponse;
import com.kb.location.entity.Marque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class MarqueMapper {

    public Marque toEntity(MarqueRequest request) {
        if (request == null) {
            return null;
        }
        
        Marque entity = new Marque();
        entity.setTrackingId(UUID.randomUUID());
        entity.setNom(request.getNom());
        return entity;
    }
    
    public MarqueResponse toResponse(Marque entity) {
        if (entity == null) {
            return null;
        }
        
        MarqueResponse response = new MarqueResponse();
        response.setTrackingid(entity.getTrackingId());
        response.setNom(entity.getNom());
        return response;
    }
}