package com.kb.location.entity;

import java.io.Serializable;
import java.util.UUID;

import com.kb.location.utils.AuditTable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Type extends AuditTable implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String nom;

	private UUID trackingId;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public UUID getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(UUID trackingId) {
		this.trackingId = trackingId;
	}
	
}
