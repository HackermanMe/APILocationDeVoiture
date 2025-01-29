package com.kb.location.dto.response;

import java.util.UUID;

public class DetailResponse {
    private ReservationResponse reservation;
    private double prixTotale;
    private UUID trackingId;

    public DetailResponse() {
    }

    public ReservationResponse getReservation() {
        return reservation;
    }
    
    public void setReservation(ReservationResponse reservation) {
        this.reservation = reservation;
    }
    
    public double getPrixtotale() {
        return prixTotale;
    }
    
    public void setPrixtotale(double prixTotale) {
        this.prixTotale = prixTotale;
    }
    
    public UUID getTrackingid() {
        return trackingId;
    }
    
    public void setTrackingid(UUID trackingId) {
        this.trackingId = trackingId;
    }
    
}