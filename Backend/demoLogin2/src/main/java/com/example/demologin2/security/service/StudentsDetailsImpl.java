package com.example.demologin2.security.service;

import com.example.demologin2.models.Students;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@Data
@NoArgsConstructor
public class StudentsDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String username;
    private String password;
    private String email;
    private String fullname;
    private String gender;
    private String address;
    private String phonenumber;

    private Collection<? extends GrantedAuthority> authorities;

    public StudentsDetailsImpl(Long id, String username, String password, String email, String fullname, String gender,
                                String address, String phonenumber, Collection<? extends  GrantedAuthority> authorities){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.gender = gender;
        this.address = address;
        this.phonenumber = phonenumber;
        this.authorities = authorities;
    }

    public static StudentsDetailsImpl build(Students students){
        List<GrantedAuthority> authorities = students.getRoles().stream()
                .map(roles -> new SimpleGrantedAuthority(roles.getName().name()))
                .collect(Collectors.toList());

        return new StudentsDetailsImpl(
            students.getId(),
            students.getUsername(),
            students.getPassword(),
            students.getEmail(),
            students.getFullname(),
            students.getGender(),
            students.getAddress(),
            students.getPhonenumber(),
            authorities);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public Long getId(){
        return id;
    }

    public String getEmail(){
        return email;
    }
    public String getGender(){
        return gender;
    }
    public String getFullname(){
        return fullname;
    }
    public String getAddress(){
        return address;
    }
    public String getPhonenumber(){return phonenumber;}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        StudentsDetailsImpl students =(StudentsDetailsImpl) o;
        return Objects.equals(id, students.id);
    }
}
