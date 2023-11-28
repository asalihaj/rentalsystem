package net.ubt.rentalsystem.service.booking;

import lombok.RequiredArgsConstructor;
import net.ubt.rentalsystem.dto.booking.ContractCreateDto;
import net.ubt.rentalsystem.dto.booking.ContractViewDto;
import net.ubt.rentalsystem.entity.booking.Contract;
import net.ubt.rentalsystem.mapper.booking.BookingMapper;
import net.ubt.rentalsystem.repository.booking.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;


    public List<ContractViewDto> getContractList() {
        return bookingRepository.findAll()
                .stream()
                .map(bookingMapper::contractToViewDto)
                .collect(Collectors.toList());
    }

    public void createContract(ContractCreateDto contractDto) {
        Contract contract = bookingMapper.createContractDtoToContract(contractDto);

        bookingRepository.save(contract);
    }

    public void deleteContract(UUID id) {
        bookingRepository.deleteById(id);
    }
}
