package org.example.hibye.entity;
import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String name;

    @Column(unique = true) private String username;

    private String role;

    private String password;

    public User(){

    }
    public User(String name, String username, String role, String password){
        this.name=name;
        this.username=username;
        this.role=role;
        this.password=password;


    }
    public Long getid(){return id;}
    public void setid(Long id){this.id=id;}

    public String getname(){return name;}
    public void setname(String name){this.name=name;}

    public String getusername(){return username;}
    public void setusername(String username){this.username=username;}

    public String getrole(){return role;}
    public void setRole(String role){this.role=role;}

    public String getpassword(){return password;}
    public void setpassword(String password){this.password=password;}
}
