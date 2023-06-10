package smartio.api.crud.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import smartio.api.crud.models.UserModel;
import smartio.api.crud.repositories.IUserRepository;
import smartio.api.crud.services.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

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
    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }
    //---------------------------------------

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user){

    return this.userService.saveUser(user);

    }

    //---------------------------------------

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){

        return this.userService.getUserById(id);
    }

    //------------------------------------

    @PutMapping(path = "/{id}")
    public UserModel updateUser(@RequestBody UserModel request, Long id){
        return this.userService.updateUser(request,id);
    }
    //------------------------------------
    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") Long id){
    boolean ok = this.userService.deleteUser(id);
    if(ok){
        return "User with id "+ id +" deleted succesfully!";
    }else{
        return "ERROR, User with id "+ id +" not deleted!";
    }

    }
    //------------------------------------
    @PostMapping("/login")
    public UserModel validateUser(@RequestBody UserModel user) {

        if (userService.validateUser(user.getEmail(), user.getPassword())) {
            return userService.getUserByEmail(user.getEmail());
        } else {
            return null;
        }
    }

    //--------------------------------------------


}

