package smartio.api.crud.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartio.api.crud.models.ScoreModel;
import smartio.api.crud.models.UserModel;
import smartio.api.crud.repositories.IScoreRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScoreService {

    @Autowired
    IScoreRepository scoreRepository;

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

    public ArrayList<ScoreModel> getAllScores(){
        return (ArrayList <ScoreModel>) scoreRepository.findAll();
    }

    //--------------------------------------------

    public void saveScoreWithUser(ScoreModel score, UserModel user) {
        scoreRepository.insertScore(score.getIntelligence_code(), score.getScore(), user);
    }


}
