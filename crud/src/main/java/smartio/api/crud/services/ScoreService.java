package smartio.api.crud.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartio.api.crud.models.ScoreModel;
import smartio.api.crud.models.UserModel;
import smartio.api.crud.repositories.IScoreRepository;
import smartio.api.crud.repositories.IUserRepository;

import java.util.*;

@Service
public class ScoreService {

    @Autowired
    IScoreRepository scoreRepository;

    @Autowired
    IUserRepository userRepository;

    private final Map<Integer, String> intelligences = new HashMap<>();

    public void intelligenceLabeling() {
        // Agregar las etiquetas al mapa
        intelligences.put(0, "espacial");
        intelligences.put(1, "musical");
        intelligences.put(2, "linguistico-verbal");
        intelligences.put(3, "logico-matematica");
        intelligences.put(4, "corporal-cinestesica");
        intelligences.put(5, "intrapersonal");
        intelligences.put(6, "interpersonal");
        intelligences.put(7, "naturalista");
        intelligences.put(8, "existencial");
        intelligences.put(9, "creativa");
        intelligences.put(10, "emocional");
        intelligences.put(11, "colaborativa");
    }

    public List<ScoreModel> getAllScores() {
        return (List<ScoreModel>) scoreRepository.findAll();
    }

    public ScoreModel findById(long id) {
        Optional<ScoreModel> optional = scoreRepository.findById(id);
        if (optional.isEmpty())
            throw new RuntimeException("Score no encontrado");

        return optional.get();
    }

    public ScoreModel save(ScoreModel scoreModel) {
        if (scoreModel == null)
            throw new RuntimeException("Score no válido");
        return scoreRepository.save(scoreModel);
    }

    public void saveScores(long userId, List<ScoreModel> scores) {
        Optional<UserModel> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            UserModel user = optionalUser.get();
            for (ScoreModel score : scores) {
                score.setUser(user);
                scoreRepository.save(score);
            }
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }
    }

    public List<ScoreModel> getScoresByUserId(long userId) {
        return scoreRepository.findByUserId(userId);
    }


}

