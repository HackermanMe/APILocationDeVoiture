package com.kb.location.dto.response;

import java.util.UUID;

public class ModeleResponse {
    private String nom;
    private MarqueResponse marque;
    private UUID trackingId;

    public ModeleResponse() {
    }

    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public MarqueResponse getMarque() {
        return marque;
    }
    
    public void setMarque(MarqueResponse marque) {
        this.marque = marque;
    }
    
    public UUID getTrackingid() {
        return trackingId;
    }
    
    public void setTrackingid(UUID trackingId) {
        this.trackingId = trackingId;
    }
    
}