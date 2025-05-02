package com.rami.chanteur;

import com.rami.chanteur.Role;
import com.rami.chanteur.User;
import com.rami.chanteur.repos.RoleRepository;
import com.rami.chanteur.repos.UserRepository;
import com.rami.chanteur.service.ChanteurService;
import com.rami.chanteur.service.HiphopService;
import com.rami.chanteur.dto.HiphopDTO;
import com.rami.chanteur.dto.ChanteurDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ChanteurApplication implements CommandLineRunner {

    @Autowired
    private ChanteurService chanteurService;

    @Autowired
    private HiphopService hiphopService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(ChanteurApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      
            // Add roles if they don't exist
            Role adminRole;
            List<Role> adminRoles = roleRepository.findByRole("ADMIN");
            if (adminRoles.isEmpty()) {
                adminRole = roleRepository.save(new Role(null, "ADMIN"));
            } else {
                adminRole = adminRoles.get(0); // Use the first ADMIN role
            }
    
            Role userRole;
            List<Role> userRoles = roleRepository.findByRole("USER");
            if (userRoles.isEmpty()) {
                userRole = roleRepository.save(new Role(null, "USER"));
            } else {
                userRole = userRoles.get(0); // Use the first USER role
            }
    
            // Add users if they don't exist
            if (!userRepository.findByUsername("admin").isPresent()) {
                User admin = new User(null, "admin", passwordEncoder.encode("123"), true, List.of(adminRole));
                userRepository.save(admin);
            }
    
            if (!userRepository.findByUsername("user").isPresent()) {
                User user = new User(null, "user", passwordEncoder.encode("123"), true, List.of(userRole));
                userRepository.save(user);
            }
    
            // Add test data
            HiphopDTO westCoastDTO = new HiphopDTO(null, "West Coast", "West Coast hip-hop style", null);
            HiphopDTO savedHiphop = hiphopService.saveHiphop(westCoastDTO);
    
            ChanteurDTO eminemDTO = new ChanteurDTO(null, "Eminem", 50000.0, new Date(), savedHiphop);
            chanteurService.saveChanteur(eminemDTO);
        }
    }