package com.kb.location.service;

import com.kb.location.dto.request.DetailRequest;
import com.kb.location.dto.response.DetailResponse;
import java.util.List;
import java.util.UUID;

public interface DetailService {
    DetailResponse create(DetailRequest request);
    DetailResponse update(UUID trackingId, DetailRequest request);
    DetailResponse findById(UUID trackingId);
    List<DetailResponse> findAll();
    void delete(UUID trackingId);
}