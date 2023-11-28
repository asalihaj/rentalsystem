package net.ubt.rentalsystem.dto.user;

import net.ubt.rentalsystem.entity.user.Client;

import java.time.LocalDate;
import java.util.UUID;

public class ClientCreateDto {

    public UUID id;
    public String firstName;
    public String lastName;
    public Client.Gender gender;
    public String phoneNumber;
    public String notes;
    public LocalDate birthday;
}
