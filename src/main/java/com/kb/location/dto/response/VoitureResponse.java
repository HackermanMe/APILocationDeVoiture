package com.kb.location.dto.response;

import java.util.UUID;

public class VoitureResponse {
    private ModeleResponse modele;
    private TypeResponse type;
    private UUID trackingId;
    private String anneeFabrication;
    private String immatriculation;
    private double prixParJour;
    private boolean disponiblite;

    public VoitureResponse() {
    }

    public ModeleResponse getModele() {
        return modele;
    }
    
    public void setModele(ModeleResponse modele) {
        this.modele = modele;
    }
    
    public TypeResponse getType() {
        return type;
    }
    
    public void setType(TypeResponse type) {
        this.type = type;
    }
    
    public UUID getTrackingid() {
        return trackingId;
    }
    
    public void setTrackingid(UUID trackingId) {
        this.trackingId = trackingId;
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