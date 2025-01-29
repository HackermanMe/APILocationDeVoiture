package com.kb.location.dto.response;

import java.util.UUID;

public class MarqueResponse {
    private String nom;
    private UUID trackingId;

    public MarqueResponse() {
    }

    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public UUID getTrackingid() {
        return trackingId;
    }
    
    public void setTrackingid(UUID trackingId) {
        this.trackingId = trackingId;
    }
    
}