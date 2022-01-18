/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Elyes
 */
public class Enumerations {
    public enum Role{
	ADMIN,
	MEMBER
    }
  
    public enum LockedType{
	ENABLED,
	DISABLED, //l'utilisateur a désactivé son compte par lui meme
	BANNED
    }
   
    public enum PostType{
        ANSWER,
        PICTURE,
        STATUS,
        UPDATE
    }
   
    public enum PhotoType{
        REGULAR,
        PROFILE,
        COVER
    }
    public enum LastLogin{
        ONE_DAY,
        WEEK,
        MONTH,
        YEAR
    }
}
