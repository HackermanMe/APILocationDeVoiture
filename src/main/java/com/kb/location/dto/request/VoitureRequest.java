package com.kb.location.dto.request;

import java.util.UUID;

public class VoitureRequest {
    private UUID modeleId;
    private UUID typeId;
    private String anneeFabrication;
    private String immatriculation;
    private double prixParJour;
    private boolean disponiblite;

    public VoitureRequest() {
    }

    public UUID getModeleId() {
        return modeleId;
    }
    
    public void setModeleId(UUID modeleId) {
        this.modeleId = modeleId;
    }
    
    public UUID getTypeId() {
        return typeId;
    }
    
    public void setTypeId(UUID typeId) {
        this.typeId = typeId;
    }
    
    public String getAnneefabrication() {
        return anneeFabrication;
    }
    
    public void setAnneefabrication(String anneeFabrication) {
        this.anneeFabrication = anneeFabrication;
    }
    
    public String getImmatriculation() {
        return immatriculation;
    }
    
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
    
    public double getPrixparjour() {
        return prixParJour;
    }
    
    public void setPrixparjour(double prixParJour) {
        this.prixParJour = prixParJour;
    }
    
    public boolean getDisponiblite() {
        return disponiblite;
    }
    
    public void setDisponiblite(boolean disponiblite) {
        this.disponiblite = disponiblite;
    }
    
}