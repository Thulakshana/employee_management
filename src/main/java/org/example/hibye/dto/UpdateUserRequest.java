package org.example.hibye.dto;

public class UpdateUserRequest {
  private String name;
  private String username;
  private String role;
  private String password;



    public String getname(){return name;}
    public void setname(String name){this.name=name;}

    public String getusername(){return username;}
    public void setusername(String username){this.username=username;}

    public String getrole(){return role;}
    public void setRole(String role){this.role=role;}

    public String getpassword(){return password;}
    public void setpassword(String password){this.password=password;}



}
