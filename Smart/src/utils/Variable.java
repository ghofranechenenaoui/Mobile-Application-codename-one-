package utils;


import entity.fosuser;

public class Variable {
    
    private static fosuser fosuser =null;
 

    
    public static fosuser getFosuser(){
        return fosuser;
    }
    
    public static void setFosuser(fosuser user){
        Variable.fosuser = user;
        System.out.println(Variable.getFosuser().getId());
    }
    

    
}

