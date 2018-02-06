package br.med.MaisVida;

import br.med.MaisVida.config.CustomUserConfig;
import br.med.MaisVida.entities.Role;
import br.med.MaisVida.entities.User;
import br.med.MaisVida.repository.UserRepository;
import br.med.MaisVida.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Configuration
@SpringBootApplication
public class MaisVidaApplication {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(MaisVidaApplication.class, args);
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository, UserService service) throws Exception {
        if (repository.count() == 0)
            service.save(new User("user", "ee11cbb19052e40b07aac0ca060c23ee", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
        builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
    }

    private UserDetailsService userDetailsService(final UserRepository repository) {
        return username -> new CustomUserConfig(repository.findByUsername(username));
    }
}
