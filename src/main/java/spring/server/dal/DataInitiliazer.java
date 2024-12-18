package spring.server.dal;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.server.dal.repositories.AddressRepository;
import spring.server.dal.repositories.PatientRepository;
import spring.server.dl.entities.Address;
import spring.server.dl.entities.person.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitiliazer implements CommandLineRunner {

    private final PatientRepository patientRepository;
    private final AddressRepository addressRepository;


    @Override
    public void run(String... args) throws Exception {

        Address address1 = new Address(
                "Pine Ave",
                "Paris",
                "789",
                "75001");
        Address address2 = new Address(
                " Elm St",
                "London",
                "456",
                "42451");
        Address address3 = new Address(
                "Main St",
                "Springfield",
                "123",
                "62704"
        );

        addressRepository.saveAll(Arrays.asList(address1, address2, address3));

        if (patientRepository.count() == 0) {
            List<Patient> patients = Arrays.asList(
                    new Patient(
                            UUID.randomUUID(),
                            "Smith",
                            "John",
                            "john.smith@example.com",
                            "+11234567890",
                            LocalDate.of(1990, 4, 15),
                            "Mutuelle Santé Alpha",
                            "Aucun",
                            address1
                    ),
                    new Patient(
                            UUID.randomUUID(),
                            "Jane",
                            "Doe",
                            "jane.doe@example.com",
                            "+442071838888",
                            LocalDate.of(1985, 8, 23),
                            "Mutuelle Bien-être",
                            "Besoins spécifiques: Allergies",
                            address2
                    ),
                    new Patient(
                            UUID.randomUUID(),
                            "Michael",
                            "Brown",
                            "m.brown@example.com",
                            "+33142345678",
                            LocalDate.of(1992, 1, 12),
                            "Mutuelle Prévoyance",
                            "Dossier complet",
                            address3
                    )
                    );
            patientRepository.saveAll(patients);
        }
    }
}
