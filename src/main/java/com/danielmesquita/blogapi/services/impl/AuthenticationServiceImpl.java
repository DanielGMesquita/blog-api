package com.danielmesquita.blogapi.services.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.danielmesquita.blogapi.models.User;
import com.danielmesquita.blogapi.repositories.UserRepository;
import com.danielmesquita.blogapi.request.AuthRequest;
import com.danielmesquita.blogapi.services.AuthenticationService;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
  @Autowired private UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    return repository.findByUsername(login);
  }

  @Override
  public String getToken(AuthRequest authRequest) {
    User user = repository.findByUsername(authRequest.getUsername());
    return generateToken(user);
  }

  public String generateToken(User user) {
    try {
      Algorithm algorithm = Algorithm.HMAC256("my-secret");

      return JWT.create()
          .withIssuer("blog-api")
          .withSubject(user.getUsername())
          .withExpiresAt(getExpirationDate())
          .sign(algorithm);
    } catch (JWTCreationException exception) {
      throw new RuntimeException("Fail to generate token" + exception.getMessage());
    }
  }

  @Override
  public String validateJwt(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256("my-secret");

      return JWT.require(algorithm).withIssuer("blog-api").build().verify(token).getSubject();
    } catch (JWTVerificationException e) {
      return "";
    }
  }

  private Instant getExpirationDate() {
    return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
  }
}
