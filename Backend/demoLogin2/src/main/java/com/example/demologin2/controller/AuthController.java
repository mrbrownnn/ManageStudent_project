package com.example.demologin2.controller;

import com.example.demologin2.models.ERoles;
import com.example.demologin2.models.Roles;
import com.example.demologin2.models.Students;
import com.example.demologin2.payload.request.LoginRequest;
import com.example.demologin2.payload.request.SignupRequest;
import com.example.demologin2.payload.response.JwtResponse;
import com.example.demologin2.payload.response.MessageResponse;
import com.example.demologin2.repository.RolesRespository;
import com.example.demologin2.repository.StudentsRepository;
import com.example.demologin2.security.jwt.AuthEntryPointJwt;
import com.example.demologin2.security.jwt.TokenProvider;
import com.example.demologin2.security.service.StudentsDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    StudentsRepository studentsRepository;

    @Autowired
    RolesRespository rolesRespository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    TokenProvider tokenProvider;

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication);

        StudentsDetailsImpl studentsDetails = (StudentsDetailsImpl) authentication.getPrincipal();
        List<String> roles = studentsDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                studentsDetails.getId(),
                studentsDetails.getUsername(),
                studentsDetails.getPassword(),
                studentsDetails.getEmail(),
                studentsDetails.getGender(),
                studentsDetails.getFullname(),
                studentsDetails.getAddress(),
                studentsDetails.getPhonenumber(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (studentsRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (studentsRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        Students students = new Students(signUpRequest.getUsername(), signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()), signUpRequest.getFullname(), signUpRequest.getGender(),
                signUpRequest.getAddress(), signUpRequest.getPhonenumber());
        Set<String> strRoles = signUpRequest.getRoles();
        Set<Roles> roles = new HashSet<>();

        if(strRoles == null){
            Roles student1Roles = rolesRespository.findByName(ERoles.ROLES_STUDENT1)
                    .orElseThrow(()->new RuntimeException("Error: Role is not found!!!"));
            roles.add(student1Roles);
        } else {
            strRoles.forEach(role ->{
                switch (role){
                    case "student2":
                        Roles student2Roles = rolesRespository.findByName(ERoles.ROLES_STUDENT2)
                                .orElseThrow(()->new RuntimeException("Error: Role is not found"));
                        roles.add(student2Roles);
                        break;
                    case "student3":
                        Roles student3Roles = rolesRespository.findByName(ERoles.ROLES_STUDENT3)
                                .orElseThrow(()->new RuntimeException("Error: Role is not found"));
                        roles.add(student3Roles);
                        break;
                    case "student4":
                        Roles student4Roles = rolesRespository.findByName(ERoles.ROLES_STUDENT4)
                                .orElseThrow(()->new RuntimeException("Error: Role is not found"));
                        roles.add(student4Roles);
                        break;
                    default:
                        Roles student1Roles = rolesRespository.findByName(ERoles.ROLES_STUDENT1)
                                .orElseThrow(()->new RuntimeException("Error: Role is not found"));
                        roles.add(student1Roles);
                }
            });
        }

        students.setRoles(roles);
        studentsRepository.save(students);

        return ResponseEntity.ok(new MessageResponse("User registed successfully!"));
    }
}
