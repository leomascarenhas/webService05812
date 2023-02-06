package ca.vanier.customersapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApplicationSecurityConfiguration {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .headers().frameOptions().disable();

        http
                .authorizeHttpRequests()
                .requestMatchers("/", "index")
                .permitAll()
                .anyRequest()
                .authenticated()

                .and()
                .httpBasic()

                .and()
                .formLogin();

        return http.build();
    }

    // Spring Context
    // UserDetailsService // user | {generated password}

    // EXAMPLE: You can imagine that the following code is
    // the default implementation by Spring boot security
    // in case we don't provide our own implementation
    //
    // @Bean
    // public UserDetailsService userDetailsService() {
    // String password = methodGeneratePassword();
    //     UserDetails user = User.withUsername("user")
    //             .password(password})
    //             .roles("USER")
    //             .build();
    //
    // Hey! this is your password:
    // print(password)
    //     return new InMemoryUserDetailsManager(user);
    // }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("student")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}
