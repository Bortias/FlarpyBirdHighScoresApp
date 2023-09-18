package web.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private UUID userId;

    private String name;

    private String email;

    private String password;
}
