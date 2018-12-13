/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author farukhiskalinov
 */
public class PayPal implements Payment {
    private String username;
    private String email;
    private String password;
    private boolean flag ;
	
   public PayPal(String username ,String email, String password){
        this.username = username;
	this.email=email;
	this.password=password;
        
    }
	
    @Override
    public boolean pay(int amount) {
         flag = DbConnector.signer(this.username,this.email,this.password);
        return flag;
        
    }
    
   
}
