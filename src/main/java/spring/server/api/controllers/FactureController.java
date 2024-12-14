package spring.server.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.server.bll.ConsultationService;
import spring.server.bll.FactureService;
import spring.server.dl.entities.Consultation;
import spring.server.dl.entities.Facture;

import java.util.UUID;

@RestController
@RequestMapping("/api/factures")
public class FactureController {

    private final FactureService factureService;

    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }

    // Endpoint pour générer une facture
    @PostMapping("/generate")
    public ResponseEntity<String> generateFacture(@RequestBody Consultation consultation) {
        try {
            Facture facture = factureService.createFacture(consultation);
            return ResponseEntity.ok("Facture générée avec succès pour le rendez-vous : " + consultation.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la génération de la facture.");
        }
    }

    // Endpoint pour envoyer la facture par email
    @PostMapping("/send-email")
    public ResponseEntity<String> sendFactureEmail(@RequestBody Facture facture) {
        try {
            byte[] pdfBytes = factureService.generateFacturePdf(facture);
            factureService.sendFactureEmail(facture, pdfBytes);
            return ResponseEntity.ok("Facture envoyée par email avec succès.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'envoi de l'email.");
        }
    }
}

