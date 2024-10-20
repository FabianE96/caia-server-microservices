package com.solidos.caia.gateway.filters;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {
  public static final List<String> openApiEndpoints = List.of(
          "/api/users/health",
          "/api/users/signup",
          "/api/users/confirm",
          "/api/users/login",
          "/api/conferences/health"
  );

  public Predicate<ServerHttpRequest>  isSecured =
          request -> openApiEndpoints
                  .stream()
                  .noneMatch(uri -> request.getURI().getPath().contains(uri));


}