package spring.server.bll.impls;

import com.itextpdf.text.DocumentException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import spring.server.bll.FactureService;
import spring.server.dal.repositories.FactureRepository;
import spring.server.dl.entities.Consultation;
import spring.server.dl.entities.Facture;
import spring.server.dl.entities.person.Patient;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class FactureServiceImpl implements FactureService {

    private final FactureRepository factureRepository;
    private final JavaMailSender mailSender;

    public FactureServiceImpl(FactureRepository factureRepository, JavaMailSender mailSender) {
        this.factureRepository = factureRepository;
        this.mailSender = mailSender;
    }

    @Override
    public Facture createFacture(Consultation consultation) {
        Facture facture = new Facture();
        facture.setAmount(facture.getAmount()); // Récupérer le montant
        facture.setGenerationDate(LocalDateTime.now());
        facture.setConsultation(consultation);
        return factureRepository.save(facture);
    }

    @Override
    public byte[] generateFacturePdf(Facture facture) {
        try {
            return PdfGenerator.createPdf(facture);
        } catch (IOException | DocumentException e) {
            // Ici tu peux logger l'erreur, ou la lancer sous forme de RuntimeException
            throw new RuntimeException("Erreur lors de la génération du PDF", e);
        }
    }


    @Override
    public void sendFactureEmail(Facture facture, byte[] pdfBytes) {
        Patient patient = facture.getConsultation().getPatient();
        String email = patient.getEmail();

        if (email != null && !email.isEmpty()) {
            try {
                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true);
                helper.setTo(email);
                helper.setSubject("Votre facture");
                helper.setText("Bonjour " + patient.getFirstName() + ",\n\nVeuillez trouver ci-joint votre facture.");
                helper.addAttachment("facture_" + facture.getId() + ".pdf", new ByteArrayDataSource(pdfBytes, "application/pdf"));
                mailSender.send(message);
            } catch (MessagingException e) {
                throw new RuntimeException("Erreur lors de l'envoi de l'email", e);
            }
        } else {
            System.out.println("Email non disponible pour le patient : " + patient.getFirstName());
        }
    }


}

