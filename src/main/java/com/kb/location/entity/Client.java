package com.kb.location.entity;

import java.io.Serializable;
import java.util.UUID;

import com.kb.location.utils.AuditTable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client extends AuditTable implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private UUID trackingId;
	
	private String nom;
	private String prenoms;
	private String email;
	private String telephone;
	private String adresse;
	private String motDePasse;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	
	
}
