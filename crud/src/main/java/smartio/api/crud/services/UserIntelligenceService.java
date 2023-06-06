package smartio.api.crud.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartio.api.crud.models.UserIntelligenceModel;
import smartio.api.crud.models.UserModel;
import smartio.api.crud.repositories.IUserIntelligenceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserIntelligenceService {

    @Autowired
    IUserIntelligenceRepository userIntelligenceRepository;

    public ArrayList<UserIntelligenceModel> getGeneralResults(){
        return (ArrayList <UserIntelligenceModel>) userIntelligenceRepository.findAll();
    }

    //--------------------------------------------------------------------------------
    public UserIntelligenceModel saveUserIntelligence(UserIntelligenceModel userIntelligence) {
        return userIntelligenceRepository.save(userIntelligence);
    }


}
