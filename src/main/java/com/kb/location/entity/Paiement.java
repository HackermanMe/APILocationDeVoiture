package com.kb.location.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import com.kb.location.enums.MoyenPaiement;
import com.kb.location.utils.AuditTable;

@Entity
public class Paiement extends AuditTable implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private UUID trackingId;
	
	@JoinColumn(name = "reservation_id")
	@OneToOne
	private Reservation reservation;
	
	private double montant;
	
	private LocalDate datePaiement;
	
	private MoyenPaiement moyenPaiement;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(UUID trackingId) {
		this.trackingId = trackingId;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public LocalDate getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(LocalDate datePaiement) {
		this.datePaiement = datePaiement;
	}

	public MoyenPaiement getMoyenPaiement() {
		return moyenPaiement;
	}

	public void setMoyenPaiement(MoyenPaiement moyenPaiement) {
		this.moyenPaiement = moyenPaiement;
	}
	
	
}
