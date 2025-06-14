package com.adminportal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adminportal.domain.User;
import com.adminportal.domain.security.Role;
import com.adminportal.domain.security.UserRole;
import com.adminportal.service.impl.UserServiceInterface; // ✅ Importa tu propia interfaz
import com.adminportal.utility.SecurityUtility;

@SpringBootApplication
public class AdminportalApplication implements CommandLineRunner {

    @Autowired
    private UserServiceInterface userService;

    @Autowired
    private SecurityUtility securityUtility;

    public static void main(String[] args) {
        SpringApplication.run(AdminportalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setUsername("admin");
        user1.setEmail("admin@gmail.com");

        String encryptedPassword = securityUtility.encodePassword("admin");
        user1.setPassword(encryptedPassword);

        Set<UserRole> userRoles = new HashSet<>();
        Role role1 = new Role();
        role1.setRoleId(4L);
        role1.setName("ROLE_admin");
        userRoles.add(new UserRole(user1, role1));

        userService.createUser(user1, userRoles); // ✅ Debería funcionar ahora
    }
}