package com.kb.location.dto.request;

import java.util.UUID;

public class GerantRequest {
    private UUID reservationId;
    private String nom;
    private String prenoms;
    private String email;
    private String motDePasse;

    public GerantRequest() {
    }

    public UUID getReservationId() {
        return reservationId;
    }
    
    public void setReservationId(UUID reservationId) {
        this.reservationId = reservationId;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenoms() {
        return prenoms;
    }
    
    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getMotdepasse() {
        return motDePasse;
    }
    
    public void setMotdepasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
}