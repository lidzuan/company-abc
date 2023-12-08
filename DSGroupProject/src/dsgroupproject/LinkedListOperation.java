package dsgroupproject;

import java.util.ArrayList;

public class LinkedListOperation {

    private Node head = null;

    public void addData(Customer a) {
        Node newNode = new Node(a);
        if (head == null)
            head = newNode;
        else {
            Node current = head;
            while (current.getLink() != null) {
                current = current.getLink();
            }
            current.setLink(newNode);
        }
    }

    public void deleteTarget(int target) {
        if (head.getInfo().getCustomerID() == target) {
            head = head.getLink();
        }
        else {
            Node before = null;
            Node current = head;

            while ((current.getInfo().getCustomerID() != target) && (current.getLink() != null)) {
                before = current;
                current = current.getLink();
            }
            
            if (current.getInfo().getCustomerID() == target)
                before.setLink(current.getLink());
            else
                System.out.println("Error. There is nothing matches the item that you wish to delete");
        }
    }

    public void displayCustomerList() {
        Node current = head;
        
        if (current == null)
            System.out.println("--> The list is empty, add new data!");
        else {
            System.out.printf("|%-3s|%-20s|%-15s|%20s|%10s|%20s|%n", "ID.", "CUSTOMER NAME", "PHONE NUMBER", "PRODUCT NAME", "QUANTITY", "PURCHASE DATE");
            while (current != null) {
                System.out.printf("|%-3d|", current.getInfo().getCustomerID());
                System.out.printf("%-20s|", current.getInfo().getCustomerName());
                System.out.printf("0%-14s|", current.getInfo().getCustomerphoneNumber());
                
                ArrayList<Product> pList = current.getInfo().getPList();
                boolean firstProduct = true;
                
                for (Product product : pList) {
                    if (firstProduct) {
                        System.out.printf("%20s|%10d|%20s|%n", product.getProductName(), product.getPurchaseQuantity(), product.getPurchaseDate());
                        firstProduct = false;
                    }
                    else {
                        System.out.printf("|%-3s|%-20s|%-15s|%20s|%10d|%20s|%n", "", "", "", product.getProductName(), product.getPurchaseQuantity(), product.getPurchaseDate());
                    }
                }
                
                current = current.getLink();
            }
        }
        
    }

    public void search(int target) {
        Node current = head;
        int searchCount = 1;
        
        while ((current.getInfo().getCustomerID() != target) && (current.getLink() != null)) {
            current = current.getLink();
            searchCount++;
        }
        
        if (current.getInfo().getCustomerID() == target) {
            System.out.printf("|%-3s|%-20s|%-15s|%20s|%10s|%20s|%n", "ID.", "CUSTOMER NAME", "PHONE NUMBER", "PRODUCT NAME", "QUANTITY", "PURCHASE DATE");
            while (current != null) {
                System.out.printf("|%-3d|", current.getInfo().getCustomerID());
                System.out.printf("%-20s|", current.getInfo().getCustomerName());
                System.out.printf("0%-14s|", current.getInfo().getCustomerphoneNumber());
                
                ArrayList<Product> pList = current.getInfo().getPList();
                boolean firstProduct = true;
                
                for (Product product : pList) {
                    if (firstProduct) {
                        System.out.printf("%20s|%10d|%20s|%n", product.getProductName(), product.getPurchaseQuantity(), product.getPurchaseDate());
                        firstProduct = false;
                    }
                    else {
                        System.out.printf("|%40s|%20s|%10d|%20s|%n", "", product.getProductName(), product.getPurchaseQuantity(), product.getPurchaseDate());
                    }
                }
                
                break;
            }
        }
        else
            System.out.println("There is nothing matches for your search.");
    }

    public boolean isTheTargetOnTheList(int target) {
        boolean search = false;
        
        if (head == null)
            System.out.println("\n--> The list is empty.");
        else {
            Node current = head;
            while (current.getInfo().getCustomerID() != target && current.getLink() != null) {
                current = current.getLink();
            }

            if (current.getInfo().getCustomerID() == target)
                search = true;
        }
        return search;
    }

    public void updateTarget(int target, Customer newInfo, int updateType) {
        if (head.getInfo().getCustomerID() == target) {
            if (updateType == 1) {
                head.getInfo().setCustomerName(newInfo.getCustomerName());
                head.getInfo().setCustomerphoneNumber(newInfo.getCustomerphoneNumber());
            }
            else {
                ArrayList<Product> pList = head.getInfo().getPList();
                pList.clear();      //clear existing products
                
                ArrayList<Product> updatedpList = newInfo.getPList();
                pList.addAll(updatedpList);     //add updated products list
            }
        }
        else {
            Node current = head;

            while ((current.getInfo().getCustomerID() != target) && (current.getLink() != null)) {
                current = current.getLink();
            }
            if (current.getInfo().getCustomerID() == target) {
                if (updateType == 1) {
                    current.getInfo().setCustomerName(newInfo.getCustomerName());
                    current.getInfo().setCustomerphoneNumber(newInfo.getCustomerphoneNumber());
                }
                else {
                    ArrayList<Product> pList = current.getInfo().getPList();
                    pList.clear();      // Clear the existing products
                    
                    ArrayList<Product> updatedpList = newInfo.getPList();
                    pList.addAll(updatedpList);     //add updated products list
                }
            }
            else
                System.out.println("Error. There is nothing matches the item that you wish to update");
        }
    }

}
