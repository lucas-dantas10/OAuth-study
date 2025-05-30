package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@SpringBootApplication
@RestController
public class DemoApplication {

	@GetMapping("/user")
	public Map<String, Object> user(@AuthenticationPrincipal OidcUser principal) {
		return Collections.singletonMap("name", principal.getAttribute("name"));
	}

	@PreAuthorize("hasRole('admin')")
	@GetMapping("/admin/user/details")
	public OidcUser userDetails(@AuthenticationPrincipal OidcUser principal) {
		return principal;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
