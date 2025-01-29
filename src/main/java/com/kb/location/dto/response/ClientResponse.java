package com.kb.location.dto.response;

import java.util.UUID;

public class ClientResponse {
    private UUID trackingId;
    private String nom;
    private String prenoms;
    private String email;
    private String telephone;
    private String adresse;
    private String motDePasse;

    public ClientResponse() {
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
    
    public String getTelephone() {
        return telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public String getAdresse() {
        return adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public String getMotdepasse() {
        return motDePasse;
    }
    
    public void setMotdepasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
}