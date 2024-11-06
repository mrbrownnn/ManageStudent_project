package com.example.demologin2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Size(max = 30)
    private String username;

    @NotBlank
    @Size(max = 150)
    private String password;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @Size(max = 50)
    private String fullname;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
        joinColumns = @JoinColumn(name = "students_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles =new HashSet<>();

    @NotBlank
    @Size(max = 10)
    private String gender;

    @Size(max = 200)
    private String address;

    @NotBlank
    @Size(max = 20)
    private String phonenumber;

    public Students(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Students(String username, String email, String encode, String fullname, String gender, String address,
                    String phonenumber) {
        this.username = username;
        this.email = email;
        this.password = encode;
        this.fullname = fullname;
        this.gender = gender;
        this.address = address;
        this.phonenumber = phonenumber;
    }
}
