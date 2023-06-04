package smartio.api.crud.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartio.api.crud.models.IntelligenceModel;
import smartio.api.crud.repositories.IIntelligenceRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class IntelligenceService{

    @Autowired
   IIntelligenceRepository intelligenceRepository;

    public ArrayList<IntelligenceModel> getIntelligences(){
        return (ArrayList <IntelligenceModel>) intelligenceRepository.findAll();
    }

//----------------------------------------------
    public Optional<IntelligenceModel> getIntelligenceById(Long id){

        return intelligenceRepository.findById(id);
    }

    //----------------------------------------------


}
