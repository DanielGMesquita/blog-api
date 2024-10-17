package com.danielmesquita.blogapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AuthRoles {
  ADMIN("ROLE_ADMIN"),
  USER("ROLE_USER");
  private final String role;
}
