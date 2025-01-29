package com.kb.location.mapper;

import com.kb.location.dto.request.ClientRequest;
import com.kb.location.dto.response.ClientResponse;
import com.kb.location.entity.Client;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client toEntity(ClientRequest request) {
        if (request == null) {
            return null;
        }
        
        Client entity = new Client();
        entity.setTrackingId(UUID.randomUUID());
        entity.setNom(request.getNom());
        entity.setPrenoms(request.getPrenoms());
        entity.setEmail(request.getEmail());
        entity.setTelephone(request.getTelephone());
        entity.setAdresse(request.getAdresse());
        entity.setMotDePasse(request.getMotdepasse());
        return entity;
    }
    
    public ClientResponse toResponse(Client entity) {
        if (entity == null) {
            return null;
        }
        
        ClientResponse response = new ClientResponse();
        response.setTrackingid(entity.getTrackingId());
        response.setNom(entity.getNom());
        response.setPrenoms(entity.getPrenoms());
        response.setEmail(entity.getEmail());
        response.setTelephone(entity.getTelephone());
        response.setAdresse(entity.getAdresse());
        response.setMotdepasse(entity.getMotDePasse());
        return response;
    }
}