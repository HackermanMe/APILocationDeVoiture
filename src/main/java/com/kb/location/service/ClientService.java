package com.kb.location.service;

import com.kb.location.dto.request.ClientRequest;
import com.kb.location.dto.response.ClientResponse;
import java.util.List;
import java.util.UUID;

public interface ClientService {
    ClientResponse create(ClientRequest request);
    ClientResponse update(UUID trackingId, ClientRequest request);
    ClientResponse findById(UUID trackingId);
    List<ClientResponse> findAll();
    void delete(UUID trackingId);
}