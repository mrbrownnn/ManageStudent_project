package com.fpt.booking.domain.entities;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fpt.booking.domain.enums.AuthProvider;
import com.fpt.booking.domain.enums.DateAudit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.HashSet;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class,
		  property = "id")
public class User extends DateAudit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(name = "phone", unique = true)
	private String phone;

	private String imageUrl;

	@Column(unique = true)
	private String email;

	@JsonIgnore
	private String password;

	@NotNull
	@Enumerated(EnumType.STRING)
	private AuthProvider provider;

	private String providerId;

	@Column(name = "is_locked")
	private Boolean isLocked;

	@Column(name = "is_active")
	private Boolean isActive;

	private String address;

	private String accessToken;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();


	public User(String phone, String password, AuthProvider provider, Boolean isLocked, Boolean isActive) {
		this.phone = phone;
		this.password = password;
		this.provider = provider;
		this.isLocked = isLocked;
		this.isActive = isActive;
	}
}
