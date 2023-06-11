package smartio.api.crud.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smartio.api.crud.models.UserModel;
import smartio.api.crud.services.UserService;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


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

