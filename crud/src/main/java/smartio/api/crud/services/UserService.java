package smartio.api.crud.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartio.api.crud.models.UserModel;
import smartio.api.crud.models.UserScoreProjection;
import smartio.api.crud.repositories.IUserRepository;

import java.util.ArrayList;
import java.util.List;
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

    public boolean validateUser(String email, String password) {
        UserModel user = userRepository.findByEmail(email);

        if (user == null) {
            return false; // Usuario no encontrado
        }

        return user.getPassword().equals(password);
    }

    //--------------------------------------


    public UserModel getUserByEmail(String email){

        UserModel user = userRepository.findByEmail(email);

        return user;
    }



    public List<UserScoreProjection> getUserScoresById() {
        return userRepository.findUserScoresById();
    }


}
