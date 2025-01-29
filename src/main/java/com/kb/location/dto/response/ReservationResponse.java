package com.kb.location.dto.response;

import com.kb.location.enums.StatutReservation;
import java.time.LocalDate;
import java.util.UUID;

public class ReservationResponse {
    private ClientResponse client;
    private VoitureResponse voiture;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private StatutReservation statut;
    private UUID trackingId;

    public ReservationResponse() {
    }

    public ClientResponse getClient() {
        return client;
    }
    
    public void setClient(ClientResponse client) {
        this.client = client;
    }
    
    public VoitureResponse getVoiture() {
        return voiture;
    }
    
    public void setVoiture(VoitureResponse voiture) {
        this.voiture = voiture;
    }
    
    public LocalDate getDatedebut() {
        return dateDebut;
    }
    
    public void setDatedebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }
    
    public LocalDate getDatefin() {
        return dateFin;
    }
    
    public void setDatefin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
    
    public StatutReservation getStatut() {
        return statut;
    }
    
    public void setStatut(StatutReservation statut) {
        this.statut = statut;
    }
    
    public UUID getTrackingid() {
        return trackingId;
    }
    
    public void setTrackingid(UUID trackingId) {
        this.trackingId = trackingId;
    }
    
}