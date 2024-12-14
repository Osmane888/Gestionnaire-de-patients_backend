package spring.server.bll;

import spring.server.dl.entities.Consultation;
import spring.server.dl.entities.Facture;

public interface FactureService {
    // Responsable de la création, de la génération PDF, et de l’envoi des factures.
    Facture createFacture(Consultation consultation);
    byte[] generateFacturePdf(Facture facture);
    void sendFactureEmail(Facture facture, byte[] pdfBytes);


}
