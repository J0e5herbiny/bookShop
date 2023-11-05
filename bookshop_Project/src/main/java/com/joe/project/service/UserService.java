package com.joe.project.service;

import com.joe.project.dto.UserDTO;
import com.joe.project.entity.User;
import com.joe.project.reposietpry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

  //  @Override
    public List<User> getAll(){          // Read
        return userRepository.findAll();
    }

    public Optional<User> getById(int id){ // Read by id
        return userRepository.findById(id);
    }

    public void save(UserDTO userDTO){   // Create, Update
     User user = new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail());
        user.setId(0);
   //  user.setId(user.getId());
        userRepository.save(user);

    }

    public String delete(int id){       // Delete
        userRepository.deleteById(id);
        return "Deleted";
    }

}
