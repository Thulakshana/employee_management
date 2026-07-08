package org.example.hibye.entity;
import jakarta.persistence.*;
@Entity
@Table(name="employee_profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;


    private String fullname;
    private String department;
    private Integer age;
    private String idnumber;
    private String email;
    private String mobilenumber;

    @OneToOne
    @JoinColumn(name="user_id") private User users;

    public Profile(String fullname,String department,int age,String idnumber,String email,String mobilenumber){

        this.fullname = fullname;
        this.department = department;
        this.age = age;
        this.idnumber = idnumber;
        this.email = email;
        this.mobilenumber = mobilenumber;
    }

    public Long getid(){return id;}
    public void setid(Long id){this.id=id;}

    public String getfullname(){return fullname;}
    public void setfullname(String full_name){this.fullname=full_name;}

    public String getdepartment(){return department;}
    public void setdepartment(String department){this.department=department;}

    public Integer getage(){return age;}
    public void setage(Integer age){this.age=age;}

    public String getidnumber(){return idnumber;}
    public void setidnumber(String idnumber){this.idnumber=idnumber;}

    public String getemail(){return email;}
    public void setemail(String email){this.email=email;}

    public String getmobilenumber(){return mobilenumber;}
    public void setmobilenumber(String mobilenumber){this.mobilenumber=mobilenumber;}





}
