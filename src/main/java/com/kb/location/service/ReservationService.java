package com.kb.location.service;

import com.kb.location.dto.request.ReservationRequest;
import com.kb.location.dto.response.ReservationResponse;
import java.util.List;
import java.util.UUID;

public interface ReservationService {
    ReservationResponse create(ReservationRequest request);
    ReservationResponse update(UUID trackingId, ReservationRequest request);
    ReservationResponse findById(UUID trackingId);
    List<ReservationResponse> findAll();
    void delete(UUID trackingId);
}