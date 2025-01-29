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
public class Voiture extends AuditTable implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name = "modele_id")
	private Modele modele;
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private Type type;

	private UUID trackingId;
	
	private String anneeFabrication;
	private String immatriculation;
	private double prixParJour;
	private boolean disponiblite;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Modele getModele() {
		return modele;
	}
	public void setModele(Modele modele) {
		this.modele = modele;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public UUID getTrackingId() {
		return trackingId;
	}
	public void setTrackingId(UUID trackingId) {
		this.trackingId = trackingId;
	}
	public String getAnneeFabrication() {
		return anneeFabrication;
	}
	public void setAnneeFabrication(String anneeFabrication) {
		this.anneeFabrication = anneeFabrication;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public double getPrixParJour() {
		return prixParJour;
	}
	public void setPrixParJour(double prixParJour) {
		this.prixParJour = prixParJour;
	}
	public boolean isDisponiblite() {
		return disponiblite;
	}
	public void setDisponiblite(boolean disponiblite) {
		this.disponiblite = disponiblite;
	}
	
	
}
