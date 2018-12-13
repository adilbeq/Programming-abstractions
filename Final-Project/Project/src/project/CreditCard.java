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
public class CreditCard implements Payment {
    	private String name;
	private String cardNumber;
	private String cvv;
	private String dateOfExpiry;
        private String username;
        private boolean flag;
	
	public CreditCard(String username,String nm, String ccNum, String cvv, String expiryDate){
                this.username = username;
		this.name=nm;
		this.cardNumber=ccNum;
		this.cvv=cvv;
		this.dateOfExpiry=expiryDate;
	}
	
        @Override
        public boolean pay(int amount) {
           flag = DbConnector.signer(this.username,this.cardNumber,13);
            return flag;
        
        }
        
      
    }


