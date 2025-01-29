package com.kb.location.controller;

import com.kb.location.enums.StatutReservation;
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
@RequestMapping("/api/v1/statuts-reservation")
@Tag(name = "StatutReservation", description = "API pour les opérations sur les statuts de réservation")
public class StatutReservationController {

    @Operation(
        summary = "Récupérer tous les statuts de réservation",
        description = "Récupérer tous les statuts de réservation"
    )
    @ApiResponse(
        responseCode = "200",
        description = "Statuts de réservation récupérés avec succès",
        content = @Content(schema = @Schema(implementation = StatutReservation.class))
    )
    @ApiResponse(
        responseCode = "500",
        description = "Erreur serveur lors de la récupération des statuts de réservation"
    )
    @GetMapping
    public List<StatutReservation> getAllStatuts() {
        return Arrays.asList(StatutReservation.values());
    }
}
