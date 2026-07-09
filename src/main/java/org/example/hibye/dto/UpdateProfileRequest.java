package org.example.hibye.dto;

public class UpdateProfileRequest {

    private String fullname;
    private String department;
    private Integer age;
    private String idnumber;
    private String email;
    private String mobilenumber;

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
