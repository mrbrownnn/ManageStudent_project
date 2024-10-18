package com.ptit.studentmanagement.domain.entities;


import com.ptit.studentmanagement.domain.enums.RoleName;
import com.ptit.studentmanagement.domain.playload.request.AccountRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(unique = true, length = 50)
    private Long username;

    @Column(length = 255)
    private Long password;

    @Enumerated(EnumType.STRING)
    @Column(length = 60)
    private RoleName role;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Accounts(AccountRequest accountsRequest)  {
    }
}