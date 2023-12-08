
package dsgroupproject;

import java.util.ArrayList;

public class Customer extends Product {
    
    private int id;
    private String name;
    private int phoneNumber;
    private ArrayList<Product> pList;
    
    //constructor for new customer object
    public Customer(int id, String name, int phoneNumber, ArrayList<Product> pList) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.pList = pList;
    }
    
    //constructor for updated customer personal info object
    public Customer(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    //constructor for updated customer products info object
    public Customer(ArrayList<Product> pList) {
        this.pList = pList;
    }
    
    public int getCustomerID() {
        return id;
    }
    
    public String getCustomerName() {
        return name;
    }

    public int getCustomerphoneNumber(){
        return phoneNumber;
    }

    public ArrayList<Product> getPList() {
        return pList;
    }
    
    public void setCustomerName(String name) {
        this.name = name;
    }
    
    public void setCustomerphoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}
