package net.ubt.rentalsystem.dto.user;

import lombok.Data;

@Data
public class ClientDto {
    public String id;
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String notes;
    public String gender;
}
