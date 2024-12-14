package spring.server.bll.security.impls;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.server.bll.security.AuthService;
import spring.server.dal.repositories.ProfessionalRepository;
import spring.server.dl.entities.person.Professional;

import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl  implements AuthService {

    private final ProfessionalRepository professionalRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void register(Professional professional) {
        if(professionalRepository.existsByEmail(professional.getEmail())){
            throw new UsernameNotFoundException("User with email " + professional.getEmail() + " already exists");
        }

        professional.setPassword(passwordEncoder.encode(professional.getPassword()));
        professional.setId(UUID.randomUUID());
        professionalRepository.save(professional);
    }

    @Override
    public Professional login(Professional professional) {

        Professional existingProfessional = professionalRepository.findByEmail(professional.getEmail()).orElseThrow();

        if(!passwordEncoder.matches(professional.getPassword(), existingProfessional.getPassword())){
            throw new RuntimeException("Wrong Password");
        }
        return existingProfessional;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return professionalRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
    }



//    private String generatePassword(int length){
//        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}|\\:;\"'<>,.?/";
//        Random random = new Random();
//        StringBuilder password = new StringBuilder();
//
//        for(int i = 0; i < length ; i++){
//        password.append(characters.charAt(random.nextInt(characters.length())));
//        }
//
//        return password.toString();
//    }
}
