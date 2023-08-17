package net.ubt.rentalsystem.controller.auth;

import lombok.RequiredArgsConstructor;
import net.ubt.rentalsystem.dto.auth.AuthenticationResponse;
import net.ubt.rentalsystem.dto.auth.RegisterRequest;
import net.ubt.rentalsystem.dto.auth.AuthenticationRequest;
import net.ubt.rentalsystem.service.auth.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
