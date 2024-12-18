package spring.server.dl.entities.person;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import spring.server.dl.entities.Address;
import spring.server.dl.entities.Certificat;
import spring.server.dl.entities.Consultation;
import spring.server.dl.entities.Prescriptions;
import spring.server.dl.enums.Roles;

import java.util.*;

@Entity
@NoArgsConstructor
@Setter
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class Professional extends Person implements UserDetails {

    @Getter
    @Column(unique = true)
    private String licenseNumber;

    @Getter
    @Column()
    private boolean valid;

    @Getter
    @Column()
    @Enumerated(EnumType.STRING)
    private Roles role;

    @Getter
    @Column(nullable = false, length = 120)
    private String specialization;

    @Getter
    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Address> addresses = new HashSet<>();

    public Professional(UUID id, String firstName, String lastName, String email, String phoneNumber, String licenseNumber, boolean valid, Roles role, String specialization, String password) {
        super(id, firstName, lastName, email, phoneNumber);
        this.licenseNumber = licenseNumber;
        this.role = role;
        this.specialization = specialization;
        this.password = password;
    }
    
    public Professional(String firstName, String lastName, String email, String phoneNumber, String licenseNumber, Roles role, String specialization, String password) {
        super(firstName, lastName, email, phoneNumber);
        this.licenseNumber = licenseNumber;
        this.role = role;
        this.specialization = specialization;
        this.password = password;
    }

    public Set<Address> getAddresses() {
        return Set.copyOf(addresses);
        }
    public Professional(String email, String password){
        super(email);
        this.password = password;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.toString()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return valid;
    }
}
