package spring.server.bll.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import spring.server.dl.entities.person.Professional;

public interface AuthService extends UserDetailsService {

    void register(Professional professional);
    Professional login(Professional professional);
}
