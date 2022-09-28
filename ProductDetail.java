package part03;

import javax.swing.ImageIcon;

public class ProductDetail extends Product {
    private String description;
    private ImageIcon image;
    public ProductDetail(String description, ImageIcon image,String model, String make, double price,Department department,int quantity){
        super(model, make, price, department, quantity);
        
        this.image = image;
        this.description = description;
        
    }
    public ProductDetail(String description, ImageIcon image,String model, String make, double price,Department department){
        super(model, make, price, department);
        this.image = image;
        this.description = description;
        
    }
    
    public String getDesc(){
        return description;
    }
    public ImageIcon getImage(){
        return image;
    }
}
