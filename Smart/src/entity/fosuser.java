/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Calendar;
import java.util.Date;



public class fosuser {

    private int id;
    public String username_canonical;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String email_canonical;
    private int enabled;
    private String salt;
    private Date last_login;
    private String confirmation_token;
    private Date password_requested_at;
    public String password;
    private Date birth_date;
    private boolean gender;
    private short locked;
    private int phone;
    private Date lastLogin;

    private String description;

    private boolean connected;
    private Date created_at;
    private Date updated_at;
    private String path;
    private String pays;
    private String roles;
    private int role;
    private String couverture;



    
    public fosuser() {
    }
    
       public fosuser(String username,String email) {
        this.username = username;
        this.email = email;

    }
    

    public fosuser(String username, String firstname, String lastname, String email, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }
    
      public fosuser(int id,String username, String firstname, String lastname, String email, String password) {
        this.id=id; 
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }
    
    
    public fosuser(int id){
        this.id = id;
    }

    public fosuser(int id, String username, String firstname, String lastname, String email, String password , Date birth_date, boolean gender) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.birth_date=birth_date;
        this.gender=gender;
    }

  //  public fosuser(int aInt, String string, String string0, String string1, String string2, Date date, Date date0, int aInt0, float aFloat, String string3, String string4) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }

  

   
    public String getUsername_canonical() {
        return username_canonical;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCouverture() {
        return couverture;
    }

    public void setCouverture(String couverture) {
        this.couverture = couverture;
    }

   
    public String getEmail_canonical() {
        return email_canonical;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public void setConfirmation_token(String confirmation_token) {
        this.confirmation_token = confirmation_token;
    }

    public Date getPassword_requested_at() {
        return password_requested_at;
    }

    public void setPassword_requested_at(Date password_requested_at) {
        this.password_requested_at = password_requested_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdate_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

   
    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

        public fosuser(int id, String username, String firstname, String lastname, String email, String password,Date birth_date, Boolean gender,int phone) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;

        this.birth_date = birth_date;
        this.gender = gender;
        this.phone=phone;
        
       
       }
 public fosuser(String username, String firstname, String lastname, String email, String password,Date birth_date, Boolean gender,int phone) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;

        this.birth_date = birth_date;
        this.gender = gender;
           this.phone=phone;}
 
  public fosuser(String username, String firstname, String lastname, String email, String password,Date birth_date, Boolean gender,int phone,String path,String couverture) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;

        this.birth_date = birth_date;
        this.gender = gender;
           this.phone=phone;
           this.path=path;
            this.couverture= couverture;}
 
 
 
    public fosuser(int id, String username_canonical, String username, String firstname, String lastname, String email, String email_canonical, int enabled, String salt, Date last_login, String confirmation_token, Date password_requested_at, String password, Date birth_date, boolean gender, short locked, int phone, Date lastLogin, String description, boolean connected, Date created_at, Date updated_at, String path, String pays, String roles,int role) {
        this.id = id;
        this.username_canonical = username_canonical;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.email_canonical = email_canonical;
        this.enabled = enabled;
        this.salt = salt;
        this.last_login = last_login;
        this.confirmation_token = confirmation_token;
        this.password_requested_at = password_requested_at;
        this.password = password;
        this.birth_date = birth_date;
        this.gender = gender;
        this.locked = locked;
        this.phone = phone;
        this.lastLogin = lastLogin;
        this.description = description;
        this.connected = connected;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.path = path;
        
        this.pays = pays;
        this.roles = roles;
        this.role=role;
    }
    
    public fosuser( String username_canonical, String username, String firstname, String lastname, String email, String email_canonical, int enabled, String salt, Date last_login, String confirmation_token, Date password_requested_at, String password, Date birth_date, boolean gender, short locked, int phone, Date lastLogin, String description, boolean connected, Date created_at, Date updated_at, String path, String pays, String roles,int role) {
        this.username_canonical = username_canonical;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.email_canonical = email_canonical;
        this.enabled = enabled;
        this.salt = salt;
        this.last_login = last_login;
        this.confirmation_token = confirmation_token;
        this.password_requested_at = password_requested_at;
        this.password = password;
        this.birth_date = birth_date;
        this.gender = gender;
        this.locked = locked;
        this.phone = phone;
        this.lastLogin = lastLogin;
        this.description = description;
        this.connected = connected;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.path = path;
        this.pays = pays;
        this.roles = roles;
this.role=role;
    }
      
   

    
   
    
       public fosuser(int id,String username, String password) {
           this.id = id;
           this.username = username;
           this.password = password;

    }

    public short getLocked() {
        return locked;
    }

    public void setLocked(short locked) {
        this.locked = locked;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
    
 

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }

    public Date getBirth_date() {
	return birth_date;
    }

    public void setBirth_date(Date birth_date) {
	this.birth_date = birth_date;
    }

    public boolean isGender() {
	return gender;
    }

    public void setGender(boolean gender) {
	this.gender = gender;
    }

  

    public int getPhone() {
	return phone;
    }

    public void setPhone(int phone) {
	this.phone = phone;
    }

    public Date getLastLogin() {
	return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
	this.lastLogin = lastLogin;
    }

  public int getAge() {
        Date now = new Date();
        int birthday_year = Integer.parseInt((new SimpleDateFormat("yyyy")).format(birth_date));
        int birthday_month = Integer.parseInt((new SimpleDateFormat("MM")).format(birth_date));
        int birthday_day = Integer.parseInt((new SimpleDateFormat("dd")).format(birth_date));
        
        int nowMonth = Integer.parseInt((new SimpleDateFormat("MM")).format(now));
        int nowYear = Integer.parseInt((new SimpleDateFormat("yyyy")).format(now));
        int nowDay = Integer.parseInt((new SimpleDateFormat("dd")).format(now));
        int result = nowYear - birthday_year;

        if (birthday_month > nowMonth) {
            result--;
        } else if (birthday_month == nowMonth) {
            if (birthday_day > nowDay) {
                result--;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password=" + password + "birth_date=" + birth_date + ", gender=" + gender + ", phone=" + phone + ", lastLogin=" + lastLogin +", path=" + path +  '}';
    }

  
    
}
