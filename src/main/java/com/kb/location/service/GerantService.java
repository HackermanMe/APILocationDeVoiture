package com.kb.location.service;

import com.kb.location.dto.request.GerantRequest;
import com.kb.location.dto.response.GerantResponse;
import java.util.List;
import java.util.UUID;

public interface GerantService {
    GerantResponse create(GerantRequest request);
    GerantResponse update(UUID trackingId, GerantRequest request);
    GerantResponse findById(UUID trackingId);
    List<GerantResponse> findAll();
    void delete(UUID trackingId);
}