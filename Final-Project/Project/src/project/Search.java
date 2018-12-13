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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Void
 */
public class Search {
    static int jumpers = 0;
    static int tshirts = 0;
    static int sweatshirts = 0;
    public static ArrayList<ProductList> tshirtsSearch(String model){
        ArrayList<ProductList> list = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:sqlite:DBs/jumpersDB.db");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM jumpers WHERE mbrand=? COLLATE NOCASE OR mmodel=? COLLATE NOCASE");
            ps.setString(1, model);
            ps.setString(2, model);
            ResultSet rs = ps.executeQuery();
            
            ProductList pl, gl, kl=null;
            
            while(rs.next()){
                pl = new ProductList(rs.getString("mbrand"),rs.getString("mmodel"),
                        rs.getInt("mprice"),rs.getInt("mquantity"),rs.getString("mdescription"),
                        rs.getString("mphoto"));
                jumpers++;
                
                list.add(pl);

            }
            con.close();
            
            con = DriverManager.getConnection("jdbc:sqlite:DBs/tshirtsDB.db");
            ps = con.prepareStatement("SELECT * FROM tshirts WHERE mbrand=? COLLATE NOCASE OR mmodel=? COLLATE NOCASE");
            ps.setString(1, model);
            ps.setString(2, model);
            rs = ps.executeQuery();

            
            while(rs.next()){
                gl = new ProductList(rs.getString("mbrand"),rs.getString("mmodel"),
                        rs.getInt("mprice"),rs.getInt("mquantity"),rs.getString("mdescription"),
                        rs.getString("mphoto"));
                tshirts++;
                list.add(gl);

            }
            con.close();
            
            con = DriverManager.getConnection("jdbc:sqlite:DBs/sweatshirtsDB.db");
            ps = con.prepareStatement("SELECT * FROM sweatshirts WHERE mbrand=? COLLATE NOCASE OR mmodel=? COLLATE NOCASE");
            ps.setString(1, model);
            ps.setString(2, model);
            rs = ps.executeQuery();

            
            while(rs.next()){
                kl = new ProductList(rs.getString("mbrand"),rs.getString("mmodel"),
                        rs.getInt("mprice"),rs.getInt("mquantity"),rs.getString("mdescription"),
                        rs.getString("mphoto"));
                sweatshirts++;
                list.add(kl);

            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(TshirtsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
   }
    
}
