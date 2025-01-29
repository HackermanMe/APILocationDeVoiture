package com.kb.location.controller;

import com.kb.location.dto.request.DetailRequest;
import com.kb.location.dto.response.DetailResponse;
import com.kb.location.service.DetailService;
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
@RequestMapping("/api/v1/details")
@Tag(name = "Detail", description = "API pour les opérations sur les détails")
public class DetailController {

    private final DetailService service;

    public DetailController(DetailService service) {
        this.service = service;
    }

    @Operation(
            summary = "Créer un détail",
            description = "Créer un détail avec les informations fournies"
        )
        @ApiResponse(
            responseCode = "200",
            description = "Création réussie",
            content = @Content(schema = @Schema(implementation = DetailResponse.class))
        )
        @ApiResponse(
            responseCode = "500",
            description = "Erreur serveur lors de la création"
        )
    @PostMapping
    public ResponseEntity<GlobalResponse<DetailResponse>> create(@RequestBody DetailRequest request) {
        try {
            DetailResponse response = service.create(request);
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Créé avec succès", response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }  


    @Operation(
        summary = "Mettre à jour un détail",
        description = "Mettre à jour un détail avec les informations fournies"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Mise à jour réussie",
        content = @Content(schema = @Schema(implementation = DetailResponse.class))
    )
    @ApiResponse(
        responseCode = "500",
        description = "Erreur serveur lors de la mise à jour"
    )
    @PutMapping("/{trackingId}")
    public ResponseEntity<GlobalResponse<DetailResponse>> update(
            @PathVariable UUID trackingId,
            @RequestBody DetailRequest request) {
        try {
            DetailResponse response = service.update(trackingId, request);
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Mis à jour avec succès", response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }

    @Operation(
        summary = "Trouver un détail",
        description = "Trouver un détail avec l'identifiant fourni"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Trouvé avec succès",
        content = @Content(schema = @Schema(implementation = DetailResponse.class))
    )
    @ApiResponse(
        responseCode = "404",
        description = "Non trouvé"
    )
    @GetMapping("/{trackingId}")
    public ResponseEntity<GlobalResponse<DetailResponse>> findById(@PathVariable UUID trackingId) {
        try {
            DetailResponse response = service.findById(trackingId);
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Trouvé avec succès", response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }

    @Operation(
        summary = "Trouver tous les détails",
        description = "Trouver tous les détails"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Trouvé avec succès",
        content = @Content(schema = @Schema(implementation = DetailResponse.class))
    )
    @ApiResponse(
        responseCode = "500",
        description = "Erreur serveur lors de la récupération"
    )
    @GetMapping
    public ResponseEntity<GlobalResponse<List<DetailResponse>>> findAll() {
        try {
            List<DetailResponse> responses = service.findAll();
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Récupéré tous avec succès", responses));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }

    @Operation(
        summary = "Supprimer un détail",
        description = "Supprimer un détail avec l'identifiant fourni"
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