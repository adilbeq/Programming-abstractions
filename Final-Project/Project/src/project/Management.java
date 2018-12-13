
package project;
import java.util.*;
import project.ProductList;
public interface Management {
    
    public  void insertintoTable(String brand, String model, int price, int qty, String description, String imagePath);
    
    public void updateTable(String model, int qty);
    
    public ArrayList<ProductList> TableGenerator();
    
    public ArrayList<ProductList> homePageContent();
    
    public void  delete(String model);
    
    public  ArrayList<ProductList> checkStock();
}
