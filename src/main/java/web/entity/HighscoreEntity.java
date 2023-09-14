package web.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;


import java.util.Date;
import java.util.UUID;

@Entity(name = "highscores")
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class HighscoreEntity {

    @Id
    @Column(name = "uuid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID highscoreId;

    private int value;

    @Column(name = "creation_date")
    private Date dateCreated;

    @Column(name = "user_id")
    private String user;
}
