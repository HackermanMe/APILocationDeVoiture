package com.kb.location.service;

import com.kb.location.dto.request.PaiementRequest;
import com.kb.location.dto.response.PaiementResponse;
import java.util.List;
import java.util.UUID;

public interface PaiementService {
    PaiementResponse create(PaiementRequest request);
    PaiementResponse update(UUID trackingId, PaiementRequest request);
    PaiementResponse findById(UUID trackingId);
    List<PaiementResponse> findAll();
    void delete(UUID trackingId);
}