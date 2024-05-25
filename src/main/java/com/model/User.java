package com.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int user_id;

	@Column(name = "user_name")
	private String user_name;

	@Column(name = "user_surname")
	private String user_surname;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;
}
