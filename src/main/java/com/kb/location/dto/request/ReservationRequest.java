package com.kb.location.dto.request;

import com.kb.location.enums.StatutReservation;

import java.time.LocalDate;
import java.util.UUID;

public class ReservationRequest {
    private UUID clientId;
    private UUID voitureId;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private StatutReservation statut;

    public ReservationRequest() {
    }

    public UUID getClientId() {
        return clientId;
    }
    
    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }
    
    public UUID getVoitureId() {
        return voitureId;
    }
    
    public void setVoitureId(UUID voitureId) {
        this.voitureId = voitureId;
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
    
}