package project;

import java.util.*;

class Sale implements Subject {
       private ArrayList<Observer> observers = new ArrayList<Observer>();
       private String brand;
       private double discountPercent;
       private double currentPercent;
 
       
       public Sale(String brand) {
  
        this.brand = brand;     
        //this.discountPercent = discountPercent;
    }

      public String getProductList() {
        return brand;
    }

       public double getDiscountPercent() {
        return discountPercent;
    }

   

      public void setDiscountPercent(double discountPercent) {
              this.discountPercent = discountPercent;
              notifyObservers();
       }
      
        public double getCurrentPercent() {
        return discountPercent;
    }

   

      public void setCurrentPercent(double currentPercent) {
              this.currentPercent = currentPercent;
              notifyObserversforCurrentPercent();
       }

       

       @Override
       public void registerObserver(Observer observer) {
              observers.add(observer);

       }

       @Override
       public void removeObserver(Observer observer) {
              observers.remove(observer);

       }

       @Override
       public void notifyObservers() {
              for (Observer ob : observers) {
                     System.out.println("Notifying Observers on change in Price");
                     ob.update(this.discountPercent, this.brand);
              }

       }
        @Override
       public void notifyObserversforCurrentPercent() {
              for (Observer ob : observers) {
                     System.out.println("Notifying Observers on change in Prcie");
                     ob.updateLastPrice(this.currentPercent, this.brand);
              }

       }
       

}