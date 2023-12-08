
package dsgroupproject;

public class Product {
    
    private String productName;
    private int purchaseQuantity;
    private String purchaseDate;

    public Product(String productName, int purchaseQuantity, String purchaseDate) {
        this.productName = productName;
        this.purchaseQuantity = purchaseQuantity;
        this.purchaseDate = purchaseDate;
    }
    
    //no-arg constructor to allow PList ArrayList to pass through without arguments
    public Product() {
    }
    
    public String getProductName() {
        return productName;
    }
    
    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public String getPurchaseDate(){
        return purchaseDate;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }
    
    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

}
