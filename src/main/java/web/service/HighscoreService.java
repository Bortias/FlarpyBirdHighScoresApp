package web.service;

import web.dto.HighscoreDto;

import java.util.List;

public interface HighscoreService {

    List<HighscoreDto> getAllHighscores();

    HighscoreDto saveHighscore(HighscoreDto highscoreDto);

    boolean deleteHighscore(String highscoreId);
}
