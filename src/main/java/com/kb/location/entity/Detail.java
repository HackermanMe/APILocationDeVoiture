package com.kb.location.entity;

import java.io.Serializable;
import java.util.UUID;

import com.kb.location.utils.AuditTable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Detail extends AuditTable implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name = "reservation_id")
	private Reservation reservation;
	
	private double prixTotale;
	private UUID trackingId;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public double getPrixTotale() {
		return prixTotale;
	}
	public void setPrixTotale(double prixTotale) {
		this.prixTotale = prixTotale;
	}
	public UUID getTrackingId() {
		return trackingId;
	}
	public void setTrackingId(UUID trackingId) {
		this.trackingId = trackingId;
	}
	
	
	
}
