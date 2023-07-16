package net.ubt.rentalsystem.controller;

import net.ubt.rentalsystem.dto.AuthenticationRequest;
import net.ubt.rentalsystem.dto.AuthenticationResponse;
import net.ubt.rentalsystem.dto.RegisterRequest;
import net.ubt.rentalsystem.entity.user.Role;
import net.ubt.rentalsystem.service.AuthService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// TODO: Test for missing and empty fields after implementing validation
@RunWith(MockitoJUnitRunner.class)
public class AuthControllerTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private AuthService authService;

    @Test
    public void testRegister() {
        String firstName = "John";
        String lastName = "Doe";
        String username = "johndoe";
        String email = "johndoe@example.com";
        String password = "password";
        Role role = Role.CLIENT;
        // Arrange
        RegisterRequest registerRequest = new RegisterRequest(firstName, lastName, username, email, password, role);
        AuthenticationResponse expectedResponse = new AuthenticationResponse("token");

        Mockito.when(authService.register(registerRequest)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<AuthenticationResponse> responseEntity = authController.register(registerRequest);

        // Assert
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertEquals(expectedResponse, responseEntity.getBody());
        Mockito.verify(authService).register(registerRequest);
    }

    @Test
    public void testAuthenticate() {
        // Arrange
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("username", "password");
        AuthenticationResponse expectedResponse = new AuthenticationResponse("token");

        Mockito.when(authService.authenticate(authenticationRequest)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<AuthenticationResponse> responseEntity = authController.authenticate(authenticationRequest);

        // Assert
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assert.assertEquals(expectedResponse, responseEntity.getBody());
        Mockito.verify(authService).authenticate(authenticationRequest);
    }
}
