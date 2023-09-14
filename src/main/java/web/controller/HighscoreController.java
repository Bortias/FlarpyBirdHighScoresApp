package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.dto.HighscoreDto;
import web.service.HighscoreServiceImpl;

import java.util.List;
import java.util.UUID;

@RestController
public class HighscoreController {

    @Autowired
    HighscoreServiceImpl highscoreService;

    @GetMapping(value = "/highscores", produces = "application/json")
    public ResponseEntity<List<HighscoreDto>> getAllHighscores() {
        return ResponseEntity.ok(highscoreService.getAllHighscores());
    }

    @PostMapping(value = "/highscore", produces = "application/json", consumes = "application/json")
    public ResponseEntity<HighscoreDto> saveHighscore(@RequestBody HighscoreDto highscoreDto) {
        return ResponseEntity.ok(highscoreService.saveHighscore(highscoreDto));
    }

    @DeleteMapping(value = "/highscore", produces = "application/json")
    public ResponseEntity<String> deleteHighscore(@RequestParam String highscoreId) {
        highscoreService.deleteHighscore(UUID.fromString(highscoreId));
        return ResponseEntity.noContent().build();
    }
}
