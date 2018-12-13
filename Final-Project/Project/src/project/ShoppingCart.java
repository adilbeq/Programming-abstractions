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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
public class ShoppingCart extends ArrayList<ProductList> {
	
	public ShoppingCart(){
		
	}
	
	public void addProduct(ProductList productList){
		super.add(productList);
	}
	
	public void removeProduct(ProductList productList){
		super.remove(productList);
	}
        
        
	public int calculateTotal(){
		int sum = 0;
		for(ProductList productList : this){
			sum += productList.getPrice();
                        
		}
		return sum;
	}
	
	public boolean pay(Payment paymentMethod){
		int amount = calculateTotal();
		return paymentMethod.pay(amount);
	}
             

}
