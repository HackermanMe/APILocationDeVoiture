package com.kb.location.service;

import com.kb.location.dto.request.VoitureRequest;
import com.kb.location.dto.response.VoitureResponse;
import java.util.List;
import java.util.UUID;

public interface VoitureService {
    VoitureResponse create(VoitureRequest request);
    VoitureResponse update(UUID trackingId, VoitureRequest request);
    VoitureResponse findById(UUID trackingId);
    List<VoitureResponse> findAll();
    void delete(UUID trackingId);
}