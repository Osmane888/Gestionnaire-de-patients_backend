package spring.server.bll.security.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.server.bll.security.AuthService;
import spring.server.dal.repositories.ProfessionalRepository;
import spring.server.dl.entities.person.Professional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl  implements AuthService {

    private final ProfessionalRepository professionalRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(Professional professional) {

    }

    @Override
    public Professional login(Professional professional) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
