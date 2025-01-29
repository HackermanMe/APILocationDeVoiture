package com.kb.location.dto.request;

import com.kb.location.enums.MoyenPaiement;
import java.time.LocalDate;
import java.util.UUID;

public class PaiementRequest {
    private UUID reservationId;
    private double montant;
    private LocalDate datePaiement;
    private MoyenPaiement moyenPaiement;

    public PaiementRequest() {
    }

    public UUID getReservationId() {
        return reservationId;
    }
    
    public void setReservationId(UUID reservationId) {
        this.reservationId = reservationId;
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