package net.ubt.rentalsystem.controller.booking.ContractController;

import lombok.RequiredArgsConstructor;
import net.ubt.rentalsystem.dto.booking.ContractCreateDto;
import net.ubt.rentalsystem.dto.booking.ContractViewDto;
import net.ubt.rentalsystem.service.booking.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/contract")
@RequiredArgsConstructor
public class ContractController {
    private final BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<ContractViewDto>> getAllContracts() {
        List<ContractViewDto> contractList = bookingService.getContractList();

        return new ResponseEntity<>(contractList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createContract(@RequestBody ContractCreateDto contractCreateDto) {
        bookingService.createContract(contractCreateDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteContractById(@PathVariable UUID id) {
        bookingService.deleteContract(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
