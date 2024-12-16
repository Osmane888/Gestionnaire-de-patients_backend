package spring.server.il.initializers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import spring.server.dal.repositories.ProfessionalRepository;
import spring.server.dl.entities.person.Professional;
import spring.server.dl.enums.Roles;

import java.util.UUID;

@Component
    public class DataInitializer implements CommandLineRunner {

        private final ProfessionalRepository professionalRepository;
        private final PasswordEncoder passwordEncoder;

        @Autowired
        public DataInitializer(ProfessionalRepository professionalRepository, PasswordEncoder passwordEncoder) {
            this.professionalRepository = professionalRepository;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        public void run(String... args) throws Exception {

            Professional admin1 = new Professional();
            admin1.setId(UUID.randomUUID());
            admin1.setFirstName("Osmane");
            admin1.setLastName("Guesmia");
            admin1.setLicenseNumber("464646");
            admin1.setEmail("osmane@hotmail.com");
            admin1.setSpecialization("Administrateur");
            admin1.setPassword(passwordEncoder.encode("test1234"));
            admin1.setRole(Roles.ADMINISTRATEUR);

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

            System.out.println(admin1.getUsername() + " & " + admin2.getUsername() + " ont été sauvegardé dans la db");

        }
    }
