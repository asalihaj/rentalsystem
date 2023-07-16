package net.ubt.rentalsystem.service;

import net.ubt.rentalsystem.config.JwtService;
import net.ubt.rentalsystem.dto.AuthenticationRequest;
import net.ubt.rentalsystem.dto.AuthenticationResponse;
import net.ubt.rentalsystem.dto.RegisterRequest;
import net.ubt.rentalsystem.entity.user.Role;
import net.ubt.rentalsystem.entity.user.User;
import net.ubt.rentalsystem.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    @Test
    public void testRegister_SuccessfulRegistration() {
        // Arrange
        RegisterRequest registerRequest = RegisterRequest.builder()
                .firstName("John")
                .lastName("Doe")
                .username("johndoe")
                .email("johndoe@example.com")
                .password("password")
                .role(Role.CLIENT)
                .build();

        User savedUser = User.builder()
                .firstName("John")
                .lastName("Doe")
                .username("johndoe")
                .email("johndoe@example.com")
                .password("encodedPassword")
                .role(Role.CLIENT)
                .build();

        Mockito.when(passwordEncoder.encode(registerRequest.getPassword())).thenReturn("encodedPassword");
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(savedUser);
        Mockito.when(jwtService.generateToken(savedUser)).thenReturn("jwtToken");

        // Act
        AuthenticationResponse response = authService.register(registerRequest);

        // Assert
        Assert.assertEquals("jwtToken", response.getToken());
        Mockito.verify(userRepository).save(Mockito.any(User.class));
    }

    @Test
    public void testAuthenticate_SuccessfulAuthentication() {
        // Arrange
        AuthenticationRequest authenticationRequest = AuthenticationRequest.builder()
                .email("johndoe@example.com")
                .password("password")
                .build();

        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .username("johndoe")
                .email("johndoe@example.com")
                .password("encodedPassword")
                .role(Role.CLIENT)
                .build();

        Mockito.when(userRepository.findByEmail(authenticationRequest.getEmail())).thenReturn(Optional.of(user));
        Mockito.when(jwtService.generateToken(user)).thenReturn("jwtToken");

        // Act
        AuthenticationResponse response = authService.authenticate(authenticationRequest);

        // Assert
        Assert.assertEquals("jwtToken", response.getToken());
        Mockito.verify(authenticationManager).authenticate(Mockito.any(UsernamePasswordAuthenticationToken.class));
    }

    @Test
    public void testAuthenticate_Failure() {
        // Arrange
        AuthenticationRequest authenticationRequest = AuthenticationRequest.builder()
                .email("johndoe@example.com")
                .password("incorrectPassword")
                .build();

        Mockito.when(authenticationManager.authenticate(Mockito.any()))
                .thenThrow(new AuthenticationServiceException("Authentication failed."));

        // Act & Assert
        try {
            authService.authenticate(authenticationRequest);
            Assert.fail("Expected AuthenticationServiceException to be thrown.");
        } catch (AuthenticationServiceException e) {
            // Exception expected
        }
    }

    @Test
    public void testAuthenticate_MissingFields() {
        // Arrange
        AuthenticationRequest authenticationRequest = AuthenticationRequest.builder()
                // Missing required fields
                .build();

        // Act & Assert
        try {
            authService.authenticate(authenticationRequest);
            Assert.fail("Expected an exception for validation failure");
        } catch (Exception e) {
            // Exception expected
        }
    }
}


