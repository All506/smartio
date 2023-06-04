package smartio.api.crud.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import smartio.api.crud.models.UserModel;
import smartio.api.crud.repositories.IUserRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;


    public ArrayList <UserModel> getUsers(){
        return (ArrayList <UserModel>) userRepository.findAll();
    }

    //------------------------------------

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    //------------------------------------


    public Optional<UserModel> getUserById(Long id){

        return userRepository.findById(id);
    }

    //------------------------------------

    public UserModel updateUser(UserModel request, Long id ){

    UserModel user = userRepository.findById(id).get();
    user.setName(request.getName());
    user.setEmail(request.getEmail());
    user.setPassword(request.getPassword());

    return user;
    }

    //------------------------------------

    public Boolean deleteUser(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    //------------------------------------




}
