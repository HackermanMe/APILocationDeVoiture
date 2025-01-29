package com.kb.location.service;

import com.kb.location.dto.request.TypeRequest;
import com.kb.location.dto.response.TypeResponse;
import java.util.List;
import java.util.UUID;

public interface TypeService {
    TypeResponse create(TypeRequest request);
    TypeResponse update(UUID trackingId, TypeRequest request);
    TypeResponse findById(UUID trackingId);
    List<TypeResponse> findAll();
    void delete(UUID trackingId);
}