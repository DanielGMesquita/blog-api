package com.danielmesquita.blogapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AuthRoles {
  ADMIN("ADMIN"),
  USER("USER");
  private final String role;
}
