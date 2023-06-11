package smartio.api.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartio.api.crud.models.ScoreModel;
import smartio.api.crud.models.UserModel;
import smartio.api.crud.services.ScoreService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/score")
public class ScoreController {


    @Autowired
    private ScoreService scoreService;
    
    @PostMapping("/{userId}")
    public ResponseEntity<String> saveScores(@PathVariable Long userId, @RequestBody List<ScoreModel> scores) {


        scoreService.saveScores(userId, scores);


        return ResponseEntity.ok("Scores saved successfully.");
    }

}
