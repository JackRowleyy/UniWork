package part03;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Warehouse implements iWare {
    private String name;
    private ArrayList<ProductDetail> products;
    private String ok = "Ok";
    private ImageIcon image;
    private String Desc;

    /**
     * 
     * @param name
     */
    public Warehouse(String name) {
        this.name = name;
        this.products = new ArrayList<ProductDetail>();

    }

    /**
     * 
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * @param model
     * @param make
     * @param price
     * @param department
     * @param quantity
     * @return
     */
    public String addProduct(String model, String make, double price, Department department, int quantity) {
        String path;
        if (department.equals(Department.ELECTRICAL)) {
            path = "images\\electrical.jpeg";
            image = new ImageIcon(path);
            Desc = "Electrical";
        }
        if (department.equals(Department.PHOTOGRAPHIC)) {
            path = "images\\Photographic.jpeg";
            image = new ImageIcon(path);
            Desc = "Photographic";
        }
        if (department.equals(Department.COMPUTING)) {
            path = "images\\Computing.jpeg";
            image = new ImageIcon(path);
            Desc = "Computing";
        }
        if (department.equals(Department.BOOKS)) {
            path = "images\\Books.jpeg";
            image = new ImageIcon(path);
            Desc = "Books";
        }
        if (department.equals(Department.MUSIC)) {
            path = "images\\Music.jpeg";
            image = new ImageIcon(path);
            Desc = "Music";
        }
        if (department.equals(Department.FASHION)) {
            path = "images\\Fashion.jpeg";
            image = new ImageIcon(path);
            Desc = "Fashion";
        }
        if (department.equals(Department.OTHER)) {
            path = "images\\Other.jpeg";
            image = new ImageIcon(path);
            Desc = "Other";
        }
        ProductDetail product = new ProductDetail(Desc, image,model, make, price, department, quantity);
        products.add(product);
        return ok;
    }

    /**
     * 
     * @param model
     * @param make
     * @param price
     * @param department
     * @return
     */
    public String addProduct(String model, String make, double price, Department department) {
        String path;
        if (department.equals(Department.ELECTRICAL)) {
            path = "images\\electrical.jpeg";
            image = new ImageIcon(path);
            Desc = "Electrical";
        }
        if (department.equals(Department.PHOTOGRAPHIC)) {
            path = "images\\Photographic.jpeg";
            image = new ImageIcon(path);
            Desc = "Photographic";
        }
        if (department.equals(Department.COMPUTING)) {
            path = "images\\Computing.jpeg";
            image = new ImageIcon(path);
            Desc = "Computing";
        }
        if (department.equals(Department.BOOKS)) {
            path = "images\\Books.jpeg";
            image = new ImageIcon(path);
            Desc = "Books";
        }
        if (department.equals(Department.MUSIC)) {
            path = "images\\Music.jpeg";
            image = new ImageIcon(path);
            Desc = "Music";
        }
        if (department.equals(Department.FASHION)) {
            path = "images\\Fashion.jpeg";
            image = new ImageIcon(path);
            Desc = "Fashion";
        }
        if (department.equals(Department.OTHER)) {
            path = "images\\Other.jpeg";
            image = new ImageIcon(path);
            Desc = "Other";
        }
        
        ProductDetail product = new ProductDetail(Desc, image,model, make, price, department);
        products.add(product);
        return ok;
    }

    /**
     * 
     * @return
     */
    public ProductDetail[] getAllProducts() {
        ProductDetail[] allProducts = new ProductDetail[products.size()];
        if (products.size() > 0) {
            for (int index = 0; index < products.size(); index++) {
                allProducts[index] = products.get(index);
            }
            return allProducts;
        } else {
            return null;
        }
    }

    /**
     * 
     * @param code
     * @return
     */
    public boolean deleteProduct(String code) {
        for (int index = 0; index < products.size(); index++) {
            if (products.get(index).getCode().equals(code)) {
                products.remove(index);
                return true;
            }

        }
        System.out.println("Invalid Code");
        return false;
    }

    /**
     * 
     * @param code
     * @param quantity
     * @return
     */
    public boolean restock(String code, int quantity) {
        for (int index = 0; index < products.size(); index++) {
            if (products.get(index).getCode().equals(code)) {
                products.get(index).addToQuantity(quantity);
                return true;
            }

        }
        System.out.println("Invalid input");
        return false;
    }

    /**
     * 
     * @param code
     * @return
     */
    public ProductDetail search(String code) {
        if (products.size() > 0) {
            for (int index = 0; index < products.size(); index++) {
                if (products.get(index).getCode().equals(code)) {
                    return products.get(index);
                }
            }
        }
        return null;
    }

    /**
     * 
     * @param make
     * @param model
     * @return
     */
    public ProductDetail search(String make, String model) {
        if (products.size() > 0) {
            for (int index = 0; index < products.size(); index++) {
                if (products.get(index).getMake().equals(make) && products.get(index).getModel().equals(model)) {
                    return products.get(index);
                }
            }
        }
        return null;
    }

    /**
     * 
     * @param department
     * @return
     */
    public ArrayList<ProductDetail> search(Department department) {
        ArrayList<ProductDetail> depProducts = new ArrayList<ProductDetail>();
        if (products.size() > 0) {

            for (int index = 0; index < products.size(); index++) {
                if (products.get(index).getDepartment().equals(department)) {
                    depProducts.add(products.get(index));
                }
            }
            return depProducts;
        }
        return null;
    }

    
    /** 
     * @return String
     */
    public String toString(){
        String result = "";
            for(int index = 0; index < products.size(); index++)
                if(products.get(index).getDepartment()== Department.ELECTRICAL){
                    result += products.get(index).toString(); 
            }
            for(int index = 0; index < products.size(); index++)
                if(products.get(index).getDepartment()== Department.PHOTOGRAPHIC){
                    result += products.get(index).toString(); 
            }
            for(int index = 0; index < products.size(); index++)
                if(products.get(index).getDepartment()== Department.COMPUTING){
                    result += products.get(index).toString(); 
            }
            for(int index = 0; index < products.size(); index++)
                if(products.get(index).getDepartment()== Department.BOOKS){
                    result += products.get(index).toString(); 
            }
            for(int index = 0; index < products.size(); index++)
                if(products.get(index).getDepartment()== Department.MUSIC){
                    result += products.get(index).toString(); 
            }
            for(int index = 0; index < products.size(); index++)
                if(products.get(index).getDepartment()== Department.FASHION){
                    result += products.get(index).toString(); 
            }
            for(int index = 0; index < products.size(); index++)
                if(products.get(index).getDepartment()== Department.OTHER){
                    result += products.get(index).toString(); 
            }
            return result;
            
    

}
}
