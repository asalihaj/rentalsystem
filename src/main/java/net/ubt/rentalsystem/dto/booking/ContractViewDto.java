package net.ubt.rentalsystem.dto.booking;

import lombok.Data;
import net.ubt.rentalsystem.dto.car.CarBaseDto;
import net.ubt.rentalsystem.dto.user.ClientDto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class ContractViewDto {
    public UUID id;
    public OffsetDateTime rentalDate;
    public OffsetDateTime returnDate;
    public String notes;
    public BigDecimal totalPrice;
    public CarBaseDto car;
    public ClientDto client;
}
