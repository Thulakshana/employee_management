package org.example.hibye.service;

import org.example.hibye.dto.LoginRequest;
import org.example.hibye.dto.SignupRequest;
import org.example.hibye.entity.User;
import org.example.hibye.exception.InvalidPasswordException;
import org.example.hibye.exception.InvalidUsernameException;
import org.example.hibye.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class userservice {
    private final UserRepository repo;

    public userservice(UserRepository repo){this.repo=repo;}

    public User signup(SignupRequest request){
        if(request.getusername().contains(" ")){
            throw new InvalidUsernameException("username cannot contain spaces");
        }
        if(!request.getusername().equals(request.getusername().toLowerCase())){
            throw new InvalidUsernameException("username cannot be contain capital letters");
        }
        if(request.getpassword().length()<8){
            throw new InvalidPasswordException("password must have 8 characters");
        }
        if(repo.findByUsername(request.getusername()).isPresent()){
            throw new InvalidUsernameException("user alredy exust");
        }
       if(!(request.getrole().equals("admin")||request.getrole().equals("employee"))){
           throw new InvalidUsernameException("role must be employee or admin");
       }
       User obj=new User(request.getname(),request.getusername(),request.getrole(),request.getpassword());
       return repo.save(obj);

    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public User login(LoginRequest request){
        User obj2=repo.findByUsername(request.getusername()).orElseThrow(()->new RuntimeException("invalid username"));
        if(!obj2.getpassword().equals(request.getpassword())){
            throw new RuntimeException("invalid password");
        }

        return obj2;

    }




}
