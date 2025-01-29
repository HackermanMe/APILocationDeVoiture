package com.kb.location.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import com.kb.location.enums.StatutReservation;
import com.kb.location.utils.AuditTable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reservation extends AuditTable implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name = "voiture_id")
	private Voiture voiture;
	
	private LocalDate dateDebut;
	private LocalDate dateFin;
	
	private StatutReservation statut;

	private UUID trackingId;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public StatutReservation getStatut() {
		return statut;
	}

	public void setStatut(StatutReservation statut) {
		this.statut = statut;
	}

	public UUID getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(UUID trackingId) {
		this.trackingId = trackingId;
	}
	
	
	
}
