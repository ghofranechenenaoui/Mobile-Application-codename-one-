/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


import java.util.List;

/**
 *
 * @author asus
 */
public class UserRegister {
    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    
    private int phone;
    private boolean gender;
    
    private String birthDate;
    


    public UserRegister() {
    }



    public UserRegister(String username, String firstname, String lastname, String email, String password, int phone, boolean gender,String birthDate) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.gender = gender;
       
        this.birthDate = birthDate;
       
    }

    public UserRegister(String username, String firstname, String lastname, String email, String password, int phone, boolean gender) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
     
        this.phone = phone;
        this.gender = gender;
       
     
    }
    
    
    

   
    



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

 

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }



   

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password=" + password + ", phone=" + phone + ", gender=" + gender + " birthDate=" + birthDate +  '}';
    }
    

    




 


   
    


 
    

 
    
      
    
}
