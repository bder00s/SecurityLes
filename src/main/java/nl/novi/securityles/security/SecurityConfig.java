//package nl.novi.securityles.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    //AUTHENTICATIE
//
//    @Bean
//    // Bruikbaar wanneer Spring password encoder nodig heeft - encrypten van password
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    // Levert de user details aan + dependency injection van passwordEncoder object van hierboven
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//        InMemoryUserDetailsManager memoryManager = new InMemoryUserDetailsManager();
//        UserDetails detailsPerson1 = User.withUsername("pietje")
//                .password(passwordEncoder.encode("wachtwoord123"))
//                .roles("USER")
//                .build();
//        memoryManager.createUser(detailsPerson1);
//
//        UserDetails detailsPerson2 = User.withUsername("Dagobert")
//                .password(passwordEncoder.encode("geld"))
//                .roles("ADMIN")
//                .build();
//        memoryManager.createUser(detailsPerson2);
//
//        return memoryManager;
//    }
//
//    //AUTHORISATIE
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .httpBasic()
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers( "/secret").hasRole("ADMIN")
//                //Wildcard: voor alle andere paden hoef je alleen maar ingelogd te zijn: "/**" als pad
//                .requestMatchers("/hello").permitAll()
//                .anyRequest().denyAll()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .csrf().disable();
//        return httpSecurity.build();
//    }
//
//}
