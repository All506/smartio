package smartio.api.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smartio.api.crud.models.ScoreModel;
import smartio.api.crud.models.UserScoreProjection;
import smartio.api.crud.services.ScoreService;
import smartio.api.crud.services.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/score")
public class ScoreController {


    @Autowired
    private ScoreService scoreService;

    @Autowired
    private UserService userService;

    @PostMapping("/{userId}")
    public ResponseEntity<String> saveScores(@PathVariable long userId, @RequestBody List<ScoreModel> scores) {


        Map<Integer, Integer> incomingScores = new HashMap<>();
        for (ScoreModel score : scores) {
            incomingScores.put(score.getIntelligence_code(), score.getScore());
        }

        List<UserScoreProjection> us = userService.getUserScoresById();

        //Map<UserId, Map<IntelligenceCode, Score>> map
        Map<Long, Map<Integer, Integer>> map = new HashMap<>();

        for (UserScoreProjection userScore : us) {
            long uId = userScore.getUserId();

            // Verificar si ya existe una entrada para el userId en el mapa
            Map<Integer, Integer> userScoreMap = map.get(uId);
            if (userScoreMap == null) {
                userScoreMap = new HashMap<>();
                map.put(uId, userScoreMap);
            }

            // Agregar la puntuación al mapa
            userScoreMap.put(userScore.getIntelligence(), userScore.getScores());
        }

        for (Map.Entry<Long, Map<Integer, Integer>> entry : map.entrySet()) {
            long uId = entry.getKey();
            Map<Integer, Integer> userScoreMap = entry.getValue();

            System.out.println(userScoreMap.toString());
            System.out.println(incomingScores);
            //TODO: Aquí debes comparar los scores del usuario con los scores que vienen en el request
            System.out.println("");

        }

        scoreService.saveScores(userId, scores);

        return ResponseEntity.ok("Scores saved successfully.");
    }

    @GetMapping(value = "/{id}")
    public List<ScoreModel> buscarPorId(@PathVariable("id") long id) {
        return scoreService.getScoresByUserId(id);
    }

}
