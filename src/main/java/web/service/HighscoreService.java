package web.service;

import web.dto.HighscoreDto;

import java.util.List;
import java.util.UUID;

public interface HighscoreService {

    List<HighscoreDto> getAllHighscores();

    HighscoreDto saveHighscore(HighscoreDto highscoreDto);

    boolean deleteHighscore(UUID highscoreId);
}
