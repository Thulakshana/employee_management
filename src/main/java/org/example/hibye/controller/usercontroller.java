package org.example.hibye.controller;


import org.example.hibye.dto.LoginRequest;
import org.example.hibye.dto.LoginResponse;
import org.example.hibye.dto.SignupRequest;
import org.example.hibye.entity.Profile;
import org.example.hibye.entity.User;
import org.example.hibye.dto.ProfileDetails;
import org.example.hibye.security.JwtUtil;
import org.example.hibye.service.userservice;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class usercontroller {
    private final userservice service_file;
    private final JwtUtil Jwt_util_file;

    public usercontroller(userservice service_file,JwtUtil jwt_util_file){
        this.service_file=service_file;
        this.Jwt_util_file=jwt_util_file;

    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/signup")
    public User signup(@RequestBody SignupRequest request){
        return service_file.signup(request);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        User user_obj=service_file.login(request);
        String token=Jwt_util_file.generateToken(user_obj.getusername());
        return new LoginResponse(token);
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/profile")
    public User profile(@RequestHeader("Authorization")String authHeader){
        String token=authHeader.substring(7);
        String username=Jwt_util_file.extractusername(token);
        return service_file.findByUsername(username);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/me")
    public Profile myprofile(@RequestHeader("Authorization")String authHeader){
        String token=authHeader.substring(7);
        String username=Jwt_util_file.extractusername(token);
        User user=service_file.findByUsername(username);
        return service_file.getLoggeduserData(user);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/add-profile")
    public Profile addProfile(@RequestBody ProfileDetails request){
        return service_file.AddDeials(request);
    }




}
