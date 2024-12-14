package spring.server.bll.impls;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import spring.server.dl.entities.Document;
import spring.server.dl.entities.Facture;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component
public class PdfGenerator {

    public static byte[] createPdf(Facture facture) throws IOException, DocumentException {
        // Créer un document PDF
        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, byteArrayOutputStream);
        document.open();

        // Ajouter des informations à la facture (par exemple le montant et la date)
        document.add(new Paragraph("Facture n° " + facture.getId()));
        document.add(new Paragraph("Montant: " + facture.getAmount() + " €"));
        document.add(new Paragraph("Date de génération: " + facture.getGenerationDate()));

        // Fermer le document PDF
        document.close();

        // Retourner le PDF sous forme de tableau de bytes
        return byteArrayOutputStream.toByteArray();
    }
}
