package com.kb.location.mapper;

import com.kb.location.dto.request.TypeRequest;
import com.kb.location.dto.response.TypeResponse;
import com.kb.location.entity.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class TypeMapper {

    public Type toEntity(TypeRequest request) {
        if (request == null) {
            return null;
        }
        
        Type entity = new Type();
        entity.setTrackingId(UUID.randomUUID());
        entity.setNom(request.getNom());
        return entity;
    }
    
    public TypeResponse toResponse(Type entity) {
        if (entity == null) {
            return null;
        }
        
        TypeResponse response = new TypeResponse();
        response.setTrackingid(entity.getTrackingId());
        response.setNom(entity.getNom());
        return response;
    }
}