package com.danielmesquita.blogapi.models;

import com.danielmesquita.blogapi.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long userId;

  @Column(name = "user_name", unique = true)
  private String name;

  @Column(name = "user_email")
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "role")
  private Role role;
}
