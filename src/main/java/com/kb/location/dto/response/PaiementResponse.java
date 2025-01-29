package com.kb.location.dto.response;

import com.kb.location.enums.MoyenPaiement;
import java.time.LocalDate;
import java.util.UUID;

public class PaiementResponse {
    private UUID trackingId;
    private ReservationResponse reservation;
    private double montant;
    private LocalDate datePaiement;
    private MoyenPaiement moyenPaiement;

    public PaiementResponse() {
    }

    public UUID getTrackingid() {
        return trackingId;
    }
    
    public void setTrackingid(UUID trackingId) {
        this.trackingId = trackingId;
    }
    
    public ReservationResponse getReservation() {
        return reservation;
    }
    
    public void setReservation(ReservationResponse reservation) {
        this.reservation = reservation;
    }
    
    public double getMontant() {
        return montant;
    }
    
    public void setMontant(double montant) {
        this.montant = montant;
    }
    
    public LocalDate getDatepaiement() {
        return datePaiement;
    }
    
    public void setDatepaiement(LocalDate datePaiement) {
        this.datePaiement = datePaiement;
    }
    
    public MoyenPaiement getMoyenpaiement() {
        return moyenPaiement;
    }
    
    public void setMoyenpaiement(MoyenPaiement moyenPaiement) {
        this.moyenPaiement = moyenPaiement;
    }
    
}