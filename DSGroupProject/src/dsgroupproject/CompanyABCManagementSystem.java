package dsgroupproject;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.InputMismatchException;

public class CompanyABCManagementSystem {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int id = 1;
        int choice;
        LinkedListOperation customers = new LinkedListOperation();
        
        String customerName;
        int phoneNumber;
        int noOfProducts;
        int productNo;
        String pName;
        String pDate;
        int pQuantity;
                        
        while (true) {
            
            try {
                System.out.println("**********************");
                System.out.println("Welcome To Company ABC\n");
                System.out.println("1. Display Data");
                System.out.println("2. Add Data");
                System.out.println("3. Search Data");
                System.out.println("4. Update Data");
                System.out.println("5. Delete Data");
                System.out.println("6. Exit");
                System.out.print("\nEnter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    
                    //1. Display Data
                    case 1:
                        
                        System.out.println("\n----------\nDISPLAY LIST\n");
                        
                        customers.displayCustomerList();
                        
                        System.out.print("\nEnter any number to return: ");
                        choice = scanner.nextInt();
                        System.out.println("");
                        break;
                        
                    //2. Add Data
                    case 2:
                        
                        System.out.println("\n----------\nADD DATA\n");
                        System.out.print("Enter customer name: ");
                        customerName = scanner.nextLine();

                        while (true) {
                            try {
                                System.out.print("Enter customer phone number: ");
                                phoneNumber = scanner.nextInt();
                                scanner.nextLine();
                                break;
                            } catch (InputMismatchException imx) {
                                System.out.println("--> Phone number can only have digits! Try again.");
                                scanner.nextLine();
                            }
                        }
                        
                        while (true) {
                            try {
                                System.out.print("Enter number of products purchased: ");
                                noOfProducts = scanner.nextInt();
                                
                                if ((noOfProducts <= 0))
                                    throw new Exception("--> Invalid digit! Try again.");
                                
                                scanner.nextLine();
                                break;
                            } catch (InputMismatchException imx) {
                                System.out.println("--> Insert digits only! Try again.");
                                scanner.nextLine();
                            } catch (Exception x) {
                                System.out.println(x.getMessage());
                                scanner.nextLine();
                            }
                        }
                        
                        ArrayList<Product> pList = new ArrayList<>();
                        
                        for (int i=1; i<=noOfProducts; i++) {
                            boolean cond = true;
                            while (cond) {
                                try {
                                    System.out.println("\nProduct " + i);
                                    System.out.println("-- 1. Air purifier");
                                    System.out.println("-- 2. Water purifier");
                                    System.out.println("-- 3. Air conditioner");
                                    System.out.print("Select product type for Product " + i + ": ");
                                    productNo = scanner.nextInt();

                                    if ((productNo != 1) && (productNo != 2) && (productNo != 3))
                                        throw new Exception("--> Invalid digit! Try again.");

                                    if (productNo == 1)
                                        pName = "Air purifier";
                                    else if (productNo == 2)
                                        pName = "Water purifier";
                                    else
                                        pName = "Air conditioner";
                                    
                                    scanner.nextLine();
                                    
                                    System.out.print("Enter purchase date: ");
                                    pDate = scanner.nextLine();

                                    while (true) {
                                        try {
                                            System.out.print("Enter quantity: ");
                                            pQuantity = scanner.nextInt();

                                            if (pQuantity <= 0)
                                                throw new Exception("--> Invalid quantity! Try again.");
                                            
                                            break;
                                            
                                        } catch (InputMismatchException imx) {
                                            System.out.println("--> Quantity can only have digits! Try again.");
                                            scanner.nextLine();
                                        } catch (Exception x) {
                                            System.out.println(x.getMessage());
                                        }
                                    }
                                    
                                    Product product = new Product(pName, pQuantity, pDate);
                                    pList.add(product);
                                    
                                    break;
                                    
                                } catch (InputMismatchException imx) {
                                    System.out.println("--> Enter digits only! Try again.");
                                    scanner.nextLine();
                                } catch (Exception x) {
                                    System.out.println(x.getMessage());
                                    scanner.nextLine();
                                }
                            }
                        }
                        
                        Customer customer = new Customer(id, customerName, phoneNumber, pList);
                        id++;
                        customers.addData(customer);

                        System.out.println("\n--> Customer added successfully.");
                        System.out.print("\nEnter any number to return: ");
                        choice = scanner.nextInt();
                        break;
                        
                    //3. Search Data
                    case 3:
                        
                        System.out.println("\n----------\nSEARCH DATA\n");
                        
                        System.out.print("Please enter Customer ID for Search : ");
                        int searchID = scanner.nextInt();
                        
                        if (customers.isTheTargetOnTheList(searchID) == true) {
                            System.out.println("");
                            customers.search(searchID);
                            System.out.print("\nEnter any number to return: ");
                            choice = scanner.nextInt();
                            break;
                        }
                        else
                            System.out.println("--> There is no data that matches your ID.");
                        
                        System.out.print("\nEnter any number to return: ");
                        choice = scanner.nextInt();
                        break;

                    //4. Update Data
                    case 4:
                        
                        int updateID;
                        
                        System.out.println("\n----------\nUPDATE DATA\n");
                        System.out.print("Enter customer ID to update: ");
                        updateID = scanner.nextInt();

                        if (customers.isTheTargetOnTheList(updateID) == true) {
                            scanner.nextLine();
                            
                            while (true) {
                                try {
                                    System.out.println("\nSelect info to update for customer ID " + updateID);
                                    System.out.println("-- 1. Update Personal Info (Name, Phone Number)");
                                    System.out.println("-- 2. Update Products Info");
                                    System.out.print("Enter number 1 or 2 to update respective info, or any other number to cancel: ");
                                    choice = scanner.nextInt();
                                    
                                    break;
                                } catch (InputMismatchException imx) {
                                    System.out.println("--> Insert digits only! Try again.");
                                    scanner.nextLine();
                                }
                            }
                            
                            if ((choice != 1) && (choice != 2))
                                break;
                            
                            //user chooses to update personal info
                            if (choice == 1) {
                                scanner.nextLine();
                                System.out.print("Enter customer name: ");
                                customerName = scanner.nextLine();

                                while (true) {
                                    try {
                                        System.out.print("Enter customer phone number: ");
                                        phoneNumber = scanner.nextInt();
                                        scanner.nextLine();
                                        break;
                                    } catch (InputMismatchException imx) {
                                        System.out.println("--> Phone number can only have digits! Try again.");
                                        scanner.nextLine();
                                    }
                                }
                                
                                Customer updateCustomer = new Customer(customerName, phoneNumber);;
                                customers.updateTarget(updateID, updateCustomer, 1);
                                
                            }
                            
                            //if user chooses to update products info
                            else {
                                scanner.nextLine();
                                
                                while (true) {
                                    try {
                                        System.out.print("Enter number of products purchased: ");
                                        noOfProducts = scanner.nextInt();

                                        if ((noOfProducts <= 0))
                                            throw new Exception("--> Invalid digit! Try again.");

                                        scanner.nextLine();
                                        break;
                                    } catch (InputMismatchException imx) {
                                        System.out.println("--> Insert digits only! Try again.");
                                        scanner.nextLine();
                                    } catch (Exception x) {
                                        System.out.println(x.getMessage());
                                        scanner.nextLine();
                                    }
                                }

                                ArrayList<Product> updatedpList = new ArrayList<>();

                                for (int i=1; i<=noOfProducts; i++) {
                                    boolean cond = true;
                                    while (cond) {
                                        try {
                                            System.out.println("\nProduct " + i);
                                            System.out.println("-- 1. Air purifier");
                                            System.out.println("-- 2. Water purifier");
                                            System.out.println("-- 3. Air conditioner");
                                            System.out.print("Select product type for Product " + i + ": ");
                                            productNo = scanner.nextInt();

                                            if ((productNo != 1) && (productNo != 2) && (productNo != 3))
                                                throw new Exception("--> Invalid digit! Try again.");

                                            if (productNo == 1)
                                                pName = "Air purifier";
                                            else if (productNo == 2)
                                                pName = "Water purifier";
                                            else
                                                pName = "Air conditioner";

                                            scanner.nextLine();

                                            System.out.print("Enter purchase date: ");
                                            pDate = scanner.nextLine();

                                            while (true) {
                                                try {
                                                    System.out.print("Enter quantity: ");
                                                    pQuantity = scanner.nextInt();

                                                    if (pQuantity <= 0)
                                                        throw new Exception("--> Invalid quantity! Try again.");

                                                    break;

                                                } catch (InputMismatchException imx) {
                                                    System.out.println("--> Quantity can only have digits! Try again.");
                                                    scanner.nextLine();
                                                } catch (Exception x) {
                                                    System.out.println(x.getMessage());
                                                }
                                            }

                                            Product product = new Product(pName, pQuantity, pDate);
                                            updatedpList.add(product);

                                            break;

                                        } catch (InputMismatchException imx) {
                                            System.out.println("--> Enter digits only! Try again.");
                                            scanner.nextLine();
                                        } catch (Exception x) {
                                            System.out.println(x.getMessage());
                                            scanner.nextLine();
                                        }
                                    }
                                }
                                
                                Customer updateCustomer = new Customer(updatedpList);;
                                customers.updateTarget(updateID, updateCustomer, 2);

                            }
                            
                            System.out.println("\n--> Data with ID: " + updateID + " is updated successfully.");
                            
                        }
                        else 
                            System.out.println("--> There is no data that matches your ID.");
                        
                        System.out.print("\nEnter any number to return: ");
                        choice = scanner.nextInt();
                        break;
                        
                    //5. Delete Data
                    case 5:
                        
                        System.out.println("\n----------\nDELETE DATA\n");
                        System.out.print("Enter customer ID to delete: ");
                        int deleteID = scanner.nextInt();
                        
                        if (customers.isTheTargetOnTheList(deleteID) == true) {
                            System.out.println("Are you sure to delete all data for ID: " + deleteID + "?");
                            System.out.print("Enter 1 to confirm or any number to cancel: ");
                            choice = scanner.nextInt();
                            
                            if (choice == 1) {
                                customers.deleteTarget(deleteID);
                                System.out.println("\n--> Data deleted successfully.");
                            }
                            else
                                break;
                        }
                        else 
                            System.out.println("--> There is no data that matches your ID.");
                        
                        System.out.print("\nEnter any number to return: ");
                        choice = scanner.nextInt();
                        break;
                                            
                    //6. Exit
                    case 6:
                        
                        System.out.println("\nAre you sure to exit program?");
                        System.out.print("Enter 1 to confirm, or any number to cancel: ");
                        choice = scanner.nextInt();
                        
                        if (choice == 1) {
                            System.out.println("\nThank You!");
                            System.exit(0);         //terminates the program
                        }
                        
                        break;
                        
                    default:
                        System.out.println("--> Enter digits from 1-6 only! Try again.");
                        break;
                }

            }
            catch (InputMismatchException imx) {
                System.out.println("--> Enter digits only! Try again.");
                scanner.nextLine();
            }
            
            System.out.println("");
        }
        
    }

}
