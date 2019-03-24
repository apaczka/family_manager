package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class UserService {

    @Autowired
   private UserRepository userRepository;


    public void saveUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.delete(id);
    }

    public User find(Long id){
        return userRepository.findOne(id);

    }

    public List<User> showAllUsers(){
        return userRepository.findAll();
    }

}
