package net.ubt.rentalsystem.service.auth;

import lombok.RequiredArgsConstructor;
import net.ubt.rentalsystem.config.JwtService;
import net.ubt.rentalsystem.dto.auth.AuthenticationResponse;
import net.ubt.rentalsystem.dto.auth.RegisterRequest;
import net.ubt.rentalsystem.dto.auth.AuthenticationRequest;
import net.ubt.rentalsystem.entity.user.User;
import net.ubt.rentalsystem.repository.user.CompanyRepository;
import net.ubt.rentalsystem.repository.user.EmployeeRepository;
import net.ubt.rentalsystem.repository.user.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public void register(RegisterRequest request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .createdAt(OffsetDateTime.now())
                .lastUpdate(OffsetDateTime.now())
                .build();
        userRepository.save(user);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
        );
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());

        String jwtToken = jwtService.generateToken(claims, user);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}
