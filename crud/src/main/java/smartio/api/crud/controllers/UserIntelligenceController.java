package smartio.api.crud.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smartio.api.crud.models.UserIntelligenceModel;
import smartio.api.crud.models.UserModel;
import smartio.api.crud.services.UserIntelligenceService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/result")
public class UserIntelligenceController {

    @Autowired
    private UserIntelligenceService userIntelligenceService;


    @GetMapping
    public ArrayList<UserIntelligenceModel> getGeneralResults(){
        return this.userIntelligenceService.getGeneralResults();
    }


    //-----------------------------------------------

    @PostMapping
    public UserIntelligenceModel saveUser(@RequestBody UserIntelligenceModel result){

        return this.userIntelligenceService.saveUserIntelligence(result);

    }

    //---------------------------------------------

}
