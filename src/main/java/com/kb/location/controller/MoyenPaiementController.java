package com.kb.location.controller;

import com.kb.location.enums.MoyenPaiement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/moyens-paiement")
@Tag(name = "MoyenPaiement", description = "API pour les opérations sur les moyens de paiement")
public class MoyenPaiementController {

    @Operation(
        summary = "Récupérer tous les moyens de paiement",
        description = "Récupérer tous les moyens de paiement"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Moyens de paiement récupérés avec succès",
        content = @Content(schema = @Schema(implementation = MoyenPaiement.class))
    )
    @ApiResponse(
        responseCode = "500",
        description = "Erreur serveur lors de la récupération des moyens de paiement"
    )
    @GetMapping
    public List<MoyenPaiement> getAllMoyensPaiement() {
        return Arrays.asList(MoyenPaiement.values());
    }
}
