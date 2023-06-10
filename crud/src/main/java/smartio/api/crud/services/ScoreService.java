package smartio.api.crud.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartio.api.crud.models.ScoreModel;
import smartio.api.crud.repositories.IScoreRepository;

import java.util.ArrayList;

@Service
public class ScoreService {

    @Autowired
    IScoreRepository scoreRepository;

    public ArrayList<ScoreModel> getAllScores(){
        return (ArrayList <ScoreModel>) scoreRepository.findAll();
    }

    //--------------------------------------------





}
