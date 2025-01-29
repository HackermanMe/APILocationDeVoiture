package com.kb.location.service.impl;

import com.kb.location.dto.request.ClientRequest;
import com.kb.location.dto.response.ClientResponse;
import com.kb.location.entity.Client;
import com.kb.location.mapper.ClientMapper;
import com.kb.location.repository.ClientRepository;
import com.kb.location.service.ClientService;
import com.kb.location.utils.GlobalResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    public ClientServiceImpl(ClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ClientResponse create(ClientRequest request) {
        Client entity = mapper.toEntity(request);
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public ClientResponse update(UUID trackingId, ClientRequest request) {
        Client entity = repository.findByTrackingId(trackingId).orElseThrow(() -> new RuntimeException("Client non trouvé avec trackingId: " + trackingId));
        entity.setNom(request.getNom());
        entity.setPrenoms(request.getPrenoms());
        entity.setAdresse(request.getAdresse());
        entity.setTelephone(request.getTelephone());
        entity.setEmail(request.getEmail());
        entity.setMotDePasse(request.getMotdepasse());
        entity = repository.save(entity);
        return mapper.toResponse(entity);
    }

    @Override
    public ClientResponse findById(UUID trackingId) {
        Client entity = repository.findByTrackingId(trackingId)
            .orElseThrow(() -> new RuntimeException("Client non trouvé avec trackingId: " + trackingId));
        return mapper.toResponse(entity);
    }

    @Override
    public List<ClientResponse> findAll() {
        List<Client> entities = repository.findAllOrdered();
        return entities.stream()
            .map(mapper::toResponse)
            .toList();
    }

    @Override
    public void delete(UUID trackingId) {
        Client entity = repository.findByTrackingId(trackingId)
            .orElseThrow(() -> new RuntimeException("Client non trouvé avec trackingId: " + trackingId));
        repository.delete(entity);
    }
}