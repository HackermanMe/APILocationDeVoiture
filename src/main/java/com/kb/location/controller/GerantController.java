package com.kb.location.controller;

import com.kb.location.dto.request.GerantRequest;
import com.kb.location.dto.response.GerantResponse;
import com.kb.location.service.GerantService;
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
@RequestMapping("/api/v1/gerants")
@Tag(name = "Gerant", description = "API pour les opérations sur les gerants")
public class GerantController {

    private final GerantService service;

    public GerantController(GerantService service) {
        this.service = service;
    }

    @Operation(
            summary = "Créer un gerant",
            description = "Créer un gerant avec les informations fournies"
        )
        @ApiResponse(
            responseCode = "200",
            description = "Création réussie",
            content = @Content(schema = @Schema(implementation = GerantResponse.class))
        )
        @ApiResponse(
            responseCode = "500",
            description = "Erreur serveur lors de la création"
    )
    @PostMapping
    public ResponseEntity<GlobalResponse<GerantResponse>> create(@RequestBody GerantRequest request) {
        try {
            GerantResponse response = service.create(request);
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Créé avec succès", response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }

    @Operation(
        summary = "Mettre à jour un gerant",
        description = "Mettre à jour un gerant avec les informations fournies"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Mise à jour réussie",
        content = @Content(schema = @Schema(implementation = GerantResponse.class))
    )
    @ApiResponse(
        responseCode = "500",
        description = "Erreur serveur lors de la mise à jour"
    )
    @PutMapping("/{trackingId}")
    public ResponseEntity<GlobalResponse<GerantResponse>> update(
            @PathVariable UUID trackingId,
            @RequestBody GerantRequest request) {
        try {
            GerantResponse response = service.update(trackingId, request);
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Mis à jour avec succès", response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }

    @GetMapping("/{trackingId}")
    public ResponseEntity<GlobalResponse<GerantResponse>> findById(@PathVariable UUID trackingId) {
        try {
            GerantResponse response = service.findById(trackingId);
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Trouvé avec succès", response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }

    @GetMapping
    public ResponseEntity<GlobalResponse<List<GerantResponse>>> findAll() {
        try {
            List<GerantResponse> responses = service.findAll();
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Récupéré tous avec succès", responses));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }

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