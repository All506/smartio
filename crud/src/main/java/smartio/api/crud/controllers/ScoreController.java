package smartio.api.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartio.api.crud.models.ScoreModel;
import smartio.api.crud.services.ScoreService;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {



    @Autowired
    private ScoreService scoreService;

    @PostMapping
    public ResponseEntity<String> saveScoresForUser(@PathVariable Long userId, @RequestBody List<ScoreModel> scores) {
        for (ScoreModel score : scores) {

            scoreService.saveScore(score);
        }
        return ResponseEntity.ok("Scores saved successfully for user with ID: " + userId);
    }




}
