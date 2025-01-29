package com.kb.location.service;

import com.kb.location.dto.request.MarqueRequest;
import com.kb.location.dto.response.MarqueResponse;
import java.util.List;
import java.util.UUID;

public interface MarqueService {
    MarqueResponse create(MarqueRequest request);
    MarqueResponse update(UUID trackingId, MarqueRequest request);
    MarqueResponse findById(UUID trackingId);
    List<MarqueResponse> findAll();
    void delete(UUID trackingId);
}