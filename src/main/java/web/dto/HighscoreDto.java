package web.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class HighscoreDto {
    private UUID highscoreId;

    private int value;

    private Date dateCreated;

    private String user;
}
