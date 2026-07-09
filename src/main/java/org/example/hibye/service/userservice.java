package org.example.hibye.service;

import org.example.hibye.dto.*;
import org.example.hibye.entity.Profile;
import org.example.hibye.entity.User;
import org.example.hibye.exception.InvalidPasswordException;
import org.example.hibye.exception.InvalidProfileDetailException;
import org.example.hibye.exception.InvalidUsernameException;
import org.example.hibye.repository.ProfileRepository;
import org.example.hibye.repository.UserRepository;
import org.example.hibye.security.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;


@Service
public class userservice {
    private final UserRepository repo;
    private final ProfileRepository prepo;

    public userservice(UserRepository repo,ProfileRepository prepo){this.repo=repo; this.prepo=prepo;}

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
    public Profile AddDeials(ProfileDetails prequest,User user){
        if(!prequest.getFullname().equals(prequest.getFullname().toLowerCase())){
            throw new InvalidProfileDetailException("full name must be simple letters");
        }
        if(prequest.getAge()>100){
            throw new InvalidProfileDetailException("age must have me under 100");
        }
        if(!prequest.getDepartment().equals("admin") && !prequest.getDepartment().equals("employee")){
            throw new InvalidProfileDetailException("department ust be admin or employee");
        }
        Profile obj4=new Profile(prequest.getFullname(),prequest.getDepartment(),prequest.getAge(),prequest.getIdnumber(),prequest.getEmail(),prequest.getMobilenumber());

        obj4.setUsers(user);
        return prepo.save(obj4);

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public User login(LoginRequest request){
        User obj2=repo.findByUsername(request.getusername()).orElseThrow(()->new RuntimeException("invalid username"));
        if(!obj2.getpassword().equals(request.getpassword())){
            throw new RuntimeException("invalid password");
        }

        return obj2;

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public User findByUsername(String username){
        return repo.findByUsername(username).orElseThrow(()->new RuntimeException("user not found"));
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Profile getLoggeduserData(User user){
        return prepo.findByUsers(user).orElseThrow(()->new RuntimeException("user details not found"));
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    public User updateuserdetails(
            User user1,
            UpdateUserRequest urequest){

        if(urequest.getusername()
                .contains(" ")){

            throw new InvalidUsernameException(
                    "username cannot contain spaces");
        }

        if(!urequest.getusername()
                .equals(
                        urequest.getusername()
                                .toLowerCase())){

            throw new InvalidUsernameException(
                    "username must use lowercase");
        }

        if(urequest.getpassword()
                .length() < 8){

            throw new InvalidPasswordException(
                    "password must have 8 characters");
        }

        user1.setname(
                urequest.getname());

        user1.setusername(
                urequest.getusername());

        user1.setpassword(
                urequest.getpassword());

        return repo.save(user1);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Profile updateprofiledetails(Profile profile1, UpdateProfileRequest pprequest){

        if(!pprequest.getfullname().equals(pprequest.getfullname().toLowerCase())){
            throw new InvalidProfileDetailException("full name must be simple letters");
        }
        if(pprequest.getage()>100){
            throw new InvalidProfileDetailException("age must have me under 100");
        }
        if(!pprequest.getdepartment().equals("admin") && !pprequest.getdepartment().equals("employee")){
            throw new InvalidProfileDetailException("department ust be admin or employee");
        }
        profile1.setfullname(pprequest.getfullname());
        profile1.setdepartment(pprequest.getdepartment());
        profile1.setage(pprequest.getage());
        profile1.setidnumber(pprequest.getidnumber());
        profile1.setemail(pprequest.getemail());
        profile1.setmobilenumber(pprequest.getmobilenumber());

        return prepo.save(profile1);

    }







    }









