package net.ubt.rentalsystem.service.user;

import lombok.RequiredArgsConstructor;
import net.ubt.rentalsystem.dto.user.ClientCreateDto;
import net.ubt.rentalsystem.entity.user.Client;
import net.ubt.rentalsystem.mapper.user.ClientMapper;
import net.ubt.rentalsystem.repository.user.ClientRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public List<Client> getClientList() {
        return clientRepository.findAll();
    }

    public void createClient(ClientCreateDto clientCreateDto) {
        Client client = clientMapper.clientCreateDtoToClient(clientCreateDto);
        client.setCreatedAt(OffsetDateTime.now());
        client.setLastUpdate(OffsetDateTime.now());

        clientRepository.save(client);
    }
}
