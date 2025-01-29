package com.kb.location.controller;

import com.kb.location.dto.request.ClientRequest;
import com.kb.location.dto.response.ClientResponse;
import com.kb.location.service.ClientService;
import com.kb.location.utils.GlobalResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/clients")
@Tag(name = "Client", description = "API pour les opérations sur les clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }
    
    @Operation(
            summary = "Créer un client",
            description = "Créer un client avec les informations fournies"
        )
        @ApiResponse(
            responseCode = "200",
            description = "Création réussie",
            content = @Content(schema = @Schema(implementation = ClientResponse.class))
        )
        @ApiResponse(
            responseCode = "500",
            description = "Erreur serveur lors de la création"
        )
    @PostMapping
    public ResponseEntity<GlobalResponse<ClientResponse>> create(@RequestBody ClientRequest request) {
        try {
            ClientResponse response = service.create(request);
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Créé avec succès", response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }

    @Operation(
        summary = "Mettre à jour un client",
        description = "Mettre à jour un client avec les informations fournies"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Mise à jour réussie",
        content = @Content(schema = @Schema(implementation = ClientResponse.class))
    )
    @ApiResponse(
        responseCode = "500",
        description = "Erreur serveur lors de la mise à jour"
    )
    @PutMapping("/{trackingId}")
    public ResponseEntity<GlobalResponse<ClientResponse>> update(
            @PathVariable UUID trackingId,
            @RequestBody ClientRequest request) {
        try {
            ClientResponse response = service.update(trackingId, request);
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Mis à jour avec succès", response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }

    @Operation(
        summary = "Trouver un client",
        description = "Trouver un client avec l'identifiant fourni"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Trouvé avec succès",
        content = @Content(schema = @Schema(implementation = ClientResponse.class))
    )
    @ApiResponse(
        responseCode = "404",
        description = "Client non trouvé"
    )
    @GetMapping("/{trackingId}")
    public ResponseEntity<GlobalResponse<ClientResponse>> findById(@PathVariable UUID trackingId) {
        try {
            ClientResponse response = service.findById(trackingId);
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Trouvé avec succès", response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }

    @Operation(
        summary = "Trouver tous les clients",
        description = "Trouver tous les clients"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Trouvé avec succès",
        content = @Content(schema = @Schema(implementation = ClientResponse.class))
    )
    @ApiResponse(
        responseCode = "500",
        description = "Erreur serveur lors de la recherche"
    )
    @GetMapping
    public ResponseEntity<GlobalResponse<List<ClientResponse>>> findAll() {
        try {
            List<ClientResponse> responses = service.findAll();
            return ResponseEntity.ok(new GlobalResponse<>(new Date(), false, "Récupéré tous avec succès", responses));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GlobalResponse<>(new Date(), true, e.getMessage(), null));
        }
    }

    @Operation(
        summary = "Supprimer un client",
        description = "Supprimer un client avec l'identifiant fourni"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Suppression réussie"
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