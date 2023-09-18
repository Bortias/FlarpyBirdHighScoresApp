package web.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "users")
public class UserEntity {
    @Id
    @Column(name = "uuid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;

    private String name;

    private String email;

    private String password;
}
