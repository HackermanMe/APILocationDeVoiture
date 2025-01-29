package com.kb.location.controller;

import com.kb.location.dto.request.VoitureRequest;
import com.kb.location.dto.response.VoitureResponse;
import com.kb.location.service.VoitureService;
import com.kb.location.utils.GlobalResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/voitures")
@Tag(name = "Voiture", description = "API pour les opérations sur les voitures")
public class VoitureController {

    private final VoitureService service;

    public VoitureController(VoitureService service) {
        this.service = service;
    }   

    @Operation(
            summary = "Créer une voiture",
            description = "Créer une voiture avec les informations fournies"
        )
        @ApiResponse(
            responseCode = "200",
            description = "Création réussie",
            content = @Content(schema = @Schema(implementation = VoitureResponse.class))
        )
        @ApiResponse(
            responseCode = "500",
            description = "Erreur serveur lors de la création"
        )
    @PostMapping
    public ResponseEntity<GlobalResponse<VoitureResponse>> create(@RequestBody VoitureRequest request) {
        try {
            VoitureResponse response = service.create(request);
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Créé avec succès", response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }

    @Operation(
        summary = "Mettre à jour une voiture",
        description = "Mettre à jour une voiture avec les informations fournies"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Mise à jour réussie",
        content = @Content(schema = @Schema(implementation = VoitureResponse.class))
    )
    @ApiResponse(
        responseCode = "500",
        description = "Erreur serveur lors de la mise à jour"
    )
    @PutMapping("/{trackingId}")
    public ResponseEntity<GlobalResponse<VoitureResponse>> update(
            @PathVariable UUID trackingId,
            @RequestBody VoitureRequest request) {
        try {
            VoitureResponse response = service.update(trackingId, request);
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Mis à jour avec succès", response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }

    @Operation(
        summary = "Trouver une voiture",
        description = "Trouver une voiture avec l'identifiant fourni"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Trouvé avec succès",
        content = @Content(schema = @Schema(implementation = VoitureResponse.class))
    )
    @ApiResponse(
        responseCode = "404",
        description = "Non trouvé"
    )
    @GetMapping("/{trackingId}")
    public ResponseEntity<GlobalResponse<VoitureResponse>> findById(@PathVariable UUID trackingId) {
        try {
            VoitureResponse response = service.findById(trackingId);
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Trouvé avec succès", response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }

    @Operation(
        summary = "Trouver tous les voitures",
        description = "Trouver tous les voitures"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Trouvé avec succès",
        content = @Content(schema = @Schema(implementation = VoitureResponse.class))
    )
    @ApiResponse(
        responseCode = "500",
        description = "Erreur serveur lors de la récupération"
    )
    @GetMapping
    public ResponseEntity<GlobalResponse<List<VoitureResponse>>> findAll() {
        try {
            List<VoitureResponse> responses = service.findAll();
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Récupéré tous avec succès", responses));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }

    @Operation(
        summary = "Supprimer une voiture",
        description = "Supprimer une voiture avec l'identifiant fourni"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Supprimé avec succès"
    )
    @ApiResponse(
        responseCode = "500",
        description = "Erreur serveur lors de la suppression"
    )
    @DeleteMapping("/{trackingId}")
    public ResponseEntity<GlobalResponse<Void>> delete(@PathVariable UUID trackingId) {
        try {
            service.delete(trackingId);
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Supprimé avec succès", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }
}