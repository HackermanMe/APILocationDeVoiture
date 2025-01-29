package com.kb.location.service;

import com.kb.location.dto.request.ModeleRequest;
import com.kb.location.dto.response.ModeleResponse;
import java.util.List;
import java.util.UUID;

public interface ModeleService {
    ModeleResponse create(ModeleRequest request);
    ModeleResponse update(UUID trackingId, ModeleRequest request);
    ModeleResponse findById(UUID trackingId);
    List<ModeleResponse> findAll();
    void delete(UUID trackingId);
}