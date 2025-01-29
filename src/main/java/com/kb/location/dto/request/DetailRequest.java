package com.kb.location.dto.request;

import java.util.UUID;

public class DetailRequest {
    private UUID reservationId;
    private double prixTotale;

    public DetailRequest() {
    }

    public UUID getReservationId() {
        return reservationId;
    }
    
    public void setReservationId(UUID reservationId) {
        this.reservationId = reservationId;
    }
    
    public double getPrixtotale() {
        return prixTotale;
    }
    
    public void setPrixtotale(double prixTotale) {
        this.prixTotale = prixTotale;
    }
    
}