package net.ubt.rentalsystem.controller.user;

import lombok.RequiredArgsConstructor;
import net.ubt.rentalsystem.dto.user.ClientCreateDto;
import net.ubt.rentalsystem.entity.user.Client;
import net.ubt.rentalsystem.service.user.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {
    public final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getClientList();

        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createClient(@RequestBody ClientCreateDto clientCreateDto) {
        clientService.createClient(clientCreateDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
