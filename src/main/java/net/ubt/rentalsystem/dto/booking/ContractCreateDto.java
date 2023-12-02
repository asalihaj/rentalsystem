package net.ubt.rentalsystem.dto.booking;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class ContractCreateDto {
    public OffsetDateTime rentalDate;
    public OffsetDateTime returnDate;
    public UUID clientId;
    public UUID carId;
    public BigDecimal totalPrice;
    public String notes;
}
