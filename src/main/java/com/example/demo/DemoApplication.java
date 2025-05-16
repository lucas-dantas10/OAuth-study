package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	@GetMapping(value = "/private/resource")
	public String privateResource(@AuthenticationPrincipal Jwt jwt) {
		return jwt.getClaimAsString("sub");
	}

	@GetMapping(value = "/private/write/resource")
	public String privateWriteResource() {
		return "private write resource";
	}

	@GetMapping(value = "/public/resource")
	public String publicResource() {
		return "public resource";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
