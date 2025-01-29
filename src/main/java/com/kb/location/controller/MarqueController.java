package com.kb.location.controller;

import com.kb.location.dto.request.MarqueRequest;
import com.kb.location.dto.response.MarqueResponse;
import com.kb.location.service.MarqueService;
import com.kb.location.utils.GlobalResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.UUID;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/marques")
@Tag(name = "Marque", description = "API pour les opérations sur les marques")
public class MarqueController {

    private final MarqueService service;

    public MarqueController(MarqueService service) {
        this.service = service;
    }

    @Operation(
            summary = "Créer une marque",
            description = "Créer une marque avec les informations fournies"
        )
        @ApiResponse(
            responseCode = "200",
            description = "Création réussie",
            content = @Content(schema = @Schema(implementation = MarqueResponse.class))
        )
        @ApiResponse(
            responseCode = "500",
            description = "Erreur serveur lors de la création"
        )
    @PostMapping
    public ResponseEntity<GlobalResponse<MarqueResponse>> create(@RequestBody MarqueRequest request) {
        try {
            MarqueResponse response = service.create(request);
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Créé avec succès", response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }

    @Operation(
        summary = "Mettre à jour une marque",
        description = "Mettre à jour une marque avec les informations fournies"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Mise à jour réussie",
        content = @Content(schema = @Schema(implementation = MarqueResponse.class))
    )
    @ApiResponse(
        responseCode = "500",
        description = "Erreur serveur lors de la mise à jour"
    )
    @PutMapping("/{trackingId}")
    public ResponseEntity<GlobalResponse<MarqueResponse>> update(
            @PathVariable UUID trackingId,
            @RequestBody MarqueRequest request) {
        try {
            MarqueResponse response = service.update(trackingId, request);
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Mis à jour avec succès", response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }

    @Operation(
        summary = "Trouver une marque",
        description = "Trouver une marque avec l'identifiant fourni"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Trouvé avec succès",
        content = @Content(schema = @Schema(implementation = MarqueResponse.class))
    )
    @ApiResponse(
        responseCode = "404",
        description = "Marque non trouvée"
    )
    @GetMapping("/{trackingId}")
    public ResponseEntity<GlobalResponse<MarqueResponse>> findById(@PathVariable UUID trackingId) {
        try {
            MarqueResponse response = service.findById(trackingId);
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Trouvé avec succès", response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }

    @Operation(
        summary = "Trouver toutes les marques",
        description = "Trouver toutes les marques"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Trouvé avec succès",
        content = @Content(schema = @Schema(implementation = MarqueResponse.class))
    )
    @ApiResponse(
        responseCode = "500",
        description = "Erreur serveur lors de la recherche"
    )
    @GetMapping
    public ResponseEntity<GlobalResponse<List<MarqueResponse>>> findAll() {
        try {
            List<MarqueResponse> responses = service.findAll();
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Récupéré tous avec succès", responses));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }

    @Operation(
        summary = "Supprimer une marque",
        description = "Supprimer une marque avec l'identifiant fourni"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Suppression réussie",
        content = @Content(schema = @Schema(implementation = Void.class))
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