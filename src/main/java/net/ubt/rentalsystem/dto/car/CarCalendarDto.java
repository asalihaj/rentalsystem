package net.ubt.rentalsystem.dto.car;

import lombok.Data;

import java.util.UUID;

@Data
public class CarCalendarDto {
    public UUID id;
    public ModelDto model;
    private Short productionYear;
    private ColorDto color;
}
