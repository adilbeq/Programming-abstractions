/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Void
 */
public class TshirtsDB implements Management,Observer {
    public static boolean flag = false;
    private Subject subject;
   
    public TshirtsDB(){};
    public TshirtsDB(Subject subject ) {
        this.subject = subject;
        this.subject.registerObserver(this);
    }
     public void insertintoTable(String brand, String model, int price, int qty, String description, String imagePath){
         try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:DBs/tshirtsDB.db");
         
            PreparedStatement ps = con.prepareStatement("INSERT tshirts(mbrand, mmodel, mprice,"
                    + "mquantity, mdescription, mphoto) VALUES(?,?,?,?,?,?)");
            
            ps.setString(1, brand);
            ps.setString(2, model);
            ps.setInt(3, price);
            ps.setInt(4, qty);
            ps.setString(5, description);
            ps.setString(6, imagePath);
            if(ps.executeUpdate()==1)
                JOptionPane.showMessageDialog(null, "Entry successful!");
            
        } catch (SQLException ex) {
            Logger.getLogger(TshirtsDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    };
    //public static void insertIntoTshirtsDB(String brand, String model, int price, int qty, String description, String imagePath){//public static void insertIntoTshirtsDB(String brand, String model, int price, int qty, String description, String imagePath){
       
    //}
    
    public  void updateTable(String model, int qty){
         try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:DBs/tshirtsDB.db");
            
            PreparedStatement ps = con.prepareStatement("UPDATE tshirts SET mquantity=? WHERE mmodel=?");
            
            ps.setInt(1, qty);
            ps.setString(2, model);
            if(ps.executeUpdate()==0)
                JOptionPane.showMessageDialog(null, "Entry does not exist!");
            else if(ps.executeUpdate()==1 && flag){
                JOptionPane.showMessageDialog(null, "Stock updated successfully!");
                flag = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TshirtsDB.class.getName()).log(Level.SEVERE, null, ex);

    }
    }
    
    public  ArrayList<ProductList> TableGenerator(){
        ArrayList<ProductList> list = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:DBs/tshirtsDB.db");
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("SELECT mbrand, mmodel, mprice,mquantity, mdescription, mphoto FROM tshirts");
            
            ProductList pl;
            
            while(rs.next()){
                pl = new ProductList(rs.getString("mbrand"),rs.getString("mmodel"),
                        rs.getInt("mprice"),rs.getInt("mquantity"),rs.getString("mdescription"),
                        rs.getString("mphoto"));
                
                list.add(pl);

            }

        } catch (SQLException ex) {
            Logger.getLogger(TshirtsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
}
    public  ArrayList<ProductList> homePageContent(){
        ArrayList<ProductList> list = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:DBs/tshirtsDB.db");
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("SELECT mbrand, mmodel, mprice,mquantity, mdescription, mphoto FROM tshirts ORDER BY id DESC LIMIT 3");
            
            ProductList pl;
            
            while(rs.next()){
                pl = new ProductList(rs.getString("mbrand"),rs.getString("mmodel"),
                        rs.getInt("mprice"),rs.getInt("mquantity"),rs.getString("mdescription"),
                        rs.getString("mphoto"));
                
                list.add(pl);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TshirtsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
   }
    
    public ArrayList<ProductList> checkStock(){
        ArrayList<ProductList> list = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:DBs/tshirtsDB.db");
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("SELECT mbrand, mmodel, mprice, mquantity FROM tshirts");
            
            ProductList pl;
            
            while(rs.next()){
                pl = new ProductList(rs.getString("mbrand"),rs.getString("mmodel"),
                        0, rs.getInt("mquantity"),null, null);
                
                list.add(pl);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TshirtsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
   }
    
       public void delete(String model){
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:DBs/tshirtsDB.db");
            PreparedStatement ps = con.prepareStatement("DELETE FROM tshirts WHERE mmodel=?");
            ps.setString(1, model);
           if(ps.executeUpdate()==0)
                JOptionPane.showMessageDialog(null, "Entry does not exist!");
            else
                JOptionPane.showMessageDialog(null, "Entry deleted successfully!");
            
        } catch (SQLException ex) {
            Logger.getLogger(JumpersDB.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
       
         public  void update(double discountPercent, String brand){
         try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:DBs/tshirtsDB.db");
            
              PreparedStatement ps = con.prepareStatement("UPDATE tshirts SET mprice = mprice*? WHERE mbrand=?");
            
            ps.setDouble(1, discountPercent);
            ps.setString(2, brand);
            ps.execute();
             con.close();
           

        } catch (SQLException ex) {
            Logger.getLogger(TshirtsDB.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
              public  void updateLastPrice(double currentPercent, String brand){
         try {
            Connection con1 = DriverManager.getConnection("jdbc:sqlite:DBs/tshirtsDB.db");
            
              PreparedStatement ps1 = con1.prepareStatement("UPDATE tshirts SET mprice=mprice/? WHERE mbrand=?");
            
            ps1.setDouble(1, currentPercent);
            System.out.println(currentPercent);
            ps1.setString(2, brand);
            ps1.execute();
             con1.close();
          
            

        } catch (SQLException ex) {
            Logger.getLogger(TshirtsDB.class.getName()).log(Level.SEVERE, null, ex);

        }
      }
         
    
    
    
}
