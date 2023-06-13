package smartio.api.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smartio.api.crud.logic.Matches;
import smartio.api.crud.models.ScoreModel;
import smartio.api.crud.services.ScoreService;
import smartio.api.crud.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {


    @Autowired
    private ScoreService scoreService;

    @Autowired
    private UserService userService;


    @PostMapping("/{userId}")
    public List<String> saveScores(@PathVariable long userId, @RequestBody List<ScoreModel> scores) {

        Matches matches = new Matches();
        List<String> names = matches.getUserMatches(scores, userService, userId);

        System.out.println(names.toString());

        scoreService.saveScores(userId, scores);

        return names;
    }

    @GetMapping(value = "/{id}")
    public List<ScoreModel> buscarPorId(@PathVariable("id") long id) {
        return scoreService.getScoresByUserId(id);
    }

}
