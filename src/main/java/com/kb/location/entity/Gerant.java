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
public class Gerant extends AuditTable implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name = "reservation_id")
	private Reservation reservation;

	private UUID trackingId;
	
	private String nom;
	private String prenoms;
	private String email;
	private String motDePasse;
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
	public UUID getTrackingId() {
		return trackingId;
	}
	public void setTrackingId(UUID trackingId) {
		this.trackingId = trackingId;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenoms() {
		return prenoms;
	}
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	
	
	
}
