package com.kb.location.dto.request;

import java.util.UUID;

public class ModeleRequest {
    private String nom;
    private UUID marqueId;

    public ModeleRequest() {
    }

    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public UUID getMarqueId() {
        return marqueId;
    }
    
    public void setMarqueId(UUID marqueId) {
        this.marqueId = marqueId;
    }
    
}