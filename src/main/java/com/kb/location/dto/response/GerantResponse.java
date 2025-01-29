package com.kb.location.dto.response;

import java.util.UUID;

public class GerantResponse {
    private ReservationResponse reservation;
    private UUID trackingId;
    private String nom;
    private String prenoms;
    private String email;
    private String motDePasse;

    public GerantResponse() {
    }

    public ReservationResponse getReservation() {
        return reservation;
    }
    
    public void setReservation(ReservationResponse reservation) {
        this.reservation = reservation;
    }
    
    public UUID getTrackingid() {
        return trackingId;
    }
    
    public void setTrackingid(UUID trackingId) {
        this.trackingId = trackingId;
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