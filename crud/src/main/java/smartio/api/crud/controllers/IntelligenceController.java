package smartio.api.crud.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smartio.api.crud.models.IntelligenceModel;
import smartio.api.crud.services.IntelligenceService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/intelligence")
public class IntelligenceController {

    @Autowired
    IntelligenceService intelligenceService;

    @GetMapping
    public ArrayList<IntelligenceModel> getIntelligences(){
        return this.intelligenceService.getIntelligences();
    }
    //---------------------------------------

    @GetMapping(path = "/{id}")
    public Optional<IntelligenceModel> getUserById(@PathVariable("id") Long id){
        return this.intelligenceService.getIntelligenceById(id);
    }
}
