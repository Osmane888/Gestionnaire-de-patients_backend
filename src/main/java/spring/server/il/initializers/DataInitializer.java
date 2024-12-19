package spring.server.il.initializers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import spring.server.dal.repositories.AddressRepository;
import spring.server.dal.repositories.PatientRepository;
import spring.server.dal.repositories.ProfessionalRepository;
import spring.server.dl.entities.Address;
import spring.server.dl.entities.person.Patient;
import spring.server.dl.entities.person.Professional;
import spring.server.dl.enums.Roles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
    public class DataInitializer implements CommandLineRunner {

        private final ProfessionalRepository professionalRepository;
        private final PasswordEncoder passwordEncoder;
        private final List<Professional> admins = new ArrayList<>();
    private final PatientRepository patientRepository;
    private final AddressRepository addressRepository;

    @Autowired
        public DataInitializer(ProfessionalRepository professionalRepository, PasswordEncoder passwordEncoder, PatientRepository patientRepository, AddressRepository addressRepository) {
            this.professionalRepository = professionalRepository;
            this.passwordEncoder = passwordEncoder;
        this.patientRepository = patientRepository;
        this.addressRepository = addressRepository;
    }

        @Override
        public void run(String... args) throws Exception {

            if(professionalRepository.count() == 0) {
                Professional admin1 = new Professional();
                admin1.setId(UUID.randomUUID());
                admin1.setFirstName("Osmane");
                admin1.setLastName("Guesmia");
                admin1.setLicenseNumber("464646");
                admin1.setEmail("osmane@hotmail.com");
                admin1.setSpecialization("Administrateur");
                admin1.setPassword(passwordEncoder.encode("test1234"));
                admin1.setRole(Roles.ADMINISTRATEUR);
                admins.add(admin1);

                professionalRepository.save(admin1);

                Professional admin2 = new Professional();
                admin2.setId(UUID.randomUUID());
                admin2.setFirstName("Ayoub");
                admin2.setLastName("Laquiche");
                admin2.setLicenseNumber("79845");
                admin2.setEmail("ayoub@hotmail.com");
                admin2.setSpecialization("Administrateur");
                admin2.setPassword(passwordEncoder.encode("testtest1234"));
                admin2.setRole(Roles.ADMINISTRATEUR);
                professionalRepository.save(admin2);
                admins.add(admin1);

                System.out.println(admin1.getUsername() + " & " + admin2.getUsername() + " ont été sauvegardé dans la db");

                Professional admin3 = new Professional();
                admin3.setId(UUID.randomUUID());
                admin3.setFirstName("Amin");
                admin3.setLastName("Rozas");
                admin3.setLicenseNumber("729993");
                admin3.setEmail("amin@hotmail.com");
                admin3.setSpecialization("Administrateur");
                admin3.setPassword(passwordEncoder.encode("test456"));
                admin3.setRole(Roles.ADMINISTRATEUR);
                professionalRepository.save(admin3);
                admins.add(admin1);

                Professional admin4 = new Professional();
                admin4.setId(UUID.randomUUID());
                admin4.setFirstName("Abdellah");
                admin4.setLastName("Lamrani");
                admin4.setLicenseNumber("900924");
                admin4.setEmail("abdellah@hotmail.com");
                admin4.setSpecialization("Administrateur");
                admin4.setPassword(passwordEncoder.encode("test789"));
                admin4.setRole(Roles.ADMINISTRATEUR);
                professionalRepository.save(admin4);
                admins.add(admin1);
            }

            if(addressRepository.count() == 0) {

                Address address1 = new Address("Boulevard du Souverain", "Bruxelles", "890", "1000");
                Address address2 = new Address("Rue de la Paix", "Paris", "12", "75001");
                Address address3 = new Address("Avenue Louise", "Bruxelles", "150", "1050");
                Address address4 = new Address("High Street", "London", "45A", "SW1A1AA");
                Address address5 = new Address("Place Saint-Lambert", "Liège", "75", "4000");
                Address address6 = new Address("Via Roma", "Rome", "44", "00184");
                Address address7 = new Address("Calle Mayor", "Madrid", "10", "28005");
                Address address8 = new Address("Kurfürstendamm", "Berlin", "123", "10707");
                Address address9 = new Address("Broadway", "New York", "155", "10036");
                Address address10 = new Address("Kingsway", "Sydney", "68", "2000");
                Address address11 = new Address("Princes Street", "Edinburgh", "22", "EH2");
                Address address12 = new Address("Grafton Street", "Dublin", "14", "D02");
                Address address13 = new Address("Nanjing Road", "Shanghai", "400", "200001");

                addressRepository.saveAll(List.of(
                        address1, address2, address3, address4, address5, address6, address7, address8,
                        address9, address10, address11, address12, address13
                ));


                if (patientRepository.count() == 0) {

                    Patient patient1 = new Patient(
                            UUID.randomUUID(), "Bassem", "DZ", "b.dz@example.com", "+3298404",
                            LocalDate.of(1991, 10, 20), "Mutuelle Sympa", "Dossier complet", address1);

                    Patient patient2 = new Patient(
                            UUID.randomUUID(), "Alice", "Smith", "alice.smith@example.com", "+33123456789",
                            LocalDate.of(1985, 3, 15), "Mutuelle A", "Dossier complet", address2);

                    Patient patient3 = new Patient(
                            UUID.randomUUID(), "John", "Doe", "john.doe@example.com", "+32298765432",
                            LocalDate.of(1978, 6, 22), "Mutuelle B", "Dossier en attente", address3);

                    Patient patient4 = new Patient(
                            UUID.randomUUID(), "Emily", "Brown", "emily.brown@example.com", "+441234567890",
                            LocalDate.of(1990, 8, 9), "Mutuelle C", "Dossier incomplet", address4);

                    Patient patient5 = new Patient(
                            UUID.randomUUID(), "Claire", "Durand", "claire.durand@example.com", "+33456234987",
                            LocalDate.of(1994, 4, 14), "Mutuelle D", "Dossier complet", address5);

                    Patient patient6 = new Patient(
                            UUID.randomUUID(), "Marc", "Lemoine", "marc.lemoine@example.com", "+32256489741",
                            LocalDate.of(1980, 11, 2), "Mutuelle A", "Dossier complet", address6);

                    Patient patient7 = new Patient(
                            UUID.randomUUID(), "Sophie", "Dubois", "sophie.dubois@example.com", "+33645879632",
                            LocalDate.of(1972, 1, 30), "Mutuelle B", "Dossier incomplet", address7);

                    Patient patient8 = new Patient(
                            UUID.randomUUID(), "Paul", "Simon", "paul.simon@example.com", "+33712345678",
                            LocalDate.of(2001, 12, 17), "Mutuelle Sympa", "Dossier complet", address8);

                    Patient patient9 = new Patient(
                            UUID.randomUUID(), "Nina", "Rossi", "nina.rossi@example.com", "+33199887766",
                            LocalDate.of(1988, 9, 21), "Mutuelle D", "Dossier en attente", address9);

                    Patient patient10 = new Patient(
                            UUID.randomUUID(), "Antoine", "Martin", "antoine.martin@example.com", "+33123456700",
                            LocalDate.of(1997, 5, 7), "Mutuelle A", "Dossier complet", address10);

                    Patient patient11 = new Patient(
                            UUID.randomUUID(), "Emma", "Taylor", "emma.taylor@example.com", "+448123451234",
                            LocalDate.of(2000, 11, 8), "Mutuelle B", "Dossier en attente", address11);

                    Patient patient12 = new Patient(
                            UUID.randomUUID(), "Liam", "Anderson", "liam.anderson@example.com", "+442079876543",
                            LocalDate.of(1982, 2, 12), "Mutuelle C", "Dossier incomplet", address12);

                    Patient patient13 = new Patient(
                            UUID.randomUUID(), "Mia", "Garcia", "mia.garcia@example.com", "+863005678123",
                            LocalDate.of(1993, 7, 19), "Mutuelle D", "Dossier complet", address13);

                    // Patient partageant l'adresse de patient 1
                    Patient patient14 = new Patient(
                            UUID.randomUUID(), "Julien", "Besson", "julien.besson@example.com", "+32987654321",
                            LocalDate.of(1990, 9, 15), "Mutuelle Sympa", "Dossier en attente", address1);

                    patientRepository.saveAll(List.of(
                            patient1, patient2, patient3, patient4, patient5, patient6, patient7, patient8,
                            patient9, patient10, patient11, patient12, patient13, patient14
                    ));
                };
            };
        }
    }
