package web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;


import java.util.Date;
import java.util.UUID;

@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class HighscoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID highscoreId;

    private int value;

    private Date dateCreated;

    private String user;
}
