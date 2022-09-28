package part03;

public class Product implements iPro {
    private String code;
    private String make;
    private String model;
    private double price;
    private int quantity;
    private int purchases = 0;
    private Department department;
    private static int codenumE = 0001;
    private static int codenumP = 0001;
    private static int codenumC = 0001;
    private static int codenumB = 0001;
    private static int codenumF = 0001;
    private static int codenumM = 0001;
    private static int codenumO = 0001;
    



    public Product(String model, String make, double price, Department department, int quantity) {
        if (department.equals(Department.ELECTRICAL)) {
            String codeE = String.format("%04d",  codenumE);
            code = "E" + codeE;
            codenumE++;
        }
        if (department.equals(Department.PHOTOGRAPHIC)) {
            String codeP = String.format("%04d",  codenumP);
            code = "P" + codeP;
            codenumP++;
        }
        if (department.equals(Department.COMPUTING)) {
            String codeC = String.format("%04d",  codenumC);
            code = "C" + codeC;
            codenumC++;
        }
        if (department.equals(Department.BOOKS)) {
            String codeB = String.format("%04d",  codenumB);
            code = "B" + codeB;
            codenumB++;
        }
        if (department.equals(Department.MUSIC)) {
            String codeM = String.format("%04d",  codenumM);
            code = "M" + codeM;
            codenumM++;
        }
        if (department.equals(Department.FASHION)) {
            String codeF = String.format("%04d",  codenumF);
            code = "F" + codeF;
            codenumF++;
        }
        if (department.equals(Department.OTHER)) {
            String codeO = String.format("%04d",  codenumO);
            code = "O" + codeO;
            codenumO++;
        }
        
        this.model = model;
        this.make = make;
        this.price = price;
        this.quantity = quantity;

        this.department = department;
    }

    public Product(String model, String make, double price, Department department) {
        if (department.equals(Department.ELECTRICAL)) {
            String codeE = String.format("%04d",  codenumE);
            code = "E" + codeE;
            codenumE++;
        }
        if (department.equals(Department.PHOTOGRAPHIC)) {
            String codeP = String.format("%04d",  codenumP);
            code = "P" + codeP;
            codenumP++;
        }
        if (department.equals(Department.COMPUTING)) {
            String codeC = String.format("%04d",  codenumC);
            code = "C" + codeC;
            codenumC++;
        }
        if (department.equals(Department.BOOKS)) {
            String codeB = String.format("%04d",  codenumB);
            code = "B" + codeB;
            codenumB++;
        }
        if (department.equals(Department.MUSIC)) {
            String codeM = String.format("%04d",  codenumM);
            code = "M" + codeM;
            codenumM++;
        }
        if (department.equals(Department.FASHION)) {
            String codeF = String.format("%04d",  codenumF);
            code = "F" + codeF;
            codenumF++;
        }
        if (department.equals(Department.OTHER)) {
            String codeO = String.format("%04d",  codenumO);
            code = "O" + codeO;
            codenumO++;
        }
        this.model = model;
        this.make = make;
        this.price = price;
        this.department = department;
        this.quantity = 1;
    }

    public String toString() {
        String result = "\nPurchases: " + getPurchases() + " Code: " + getCode() + " Make: " + getMake() + " Model: "
                + getModel() + " Price: " + getPrice() + " Quantity: " + getQuantity() + " Department: "
                + getDepartment();
        return result;
    }

    public boolean recordPurchase() {

        if (quantity > 0) {
            purchases++;
            return true;
        } else {
            return false;
        }

    }

    public void addToQuantity(int amount) {
        quantity = quantity + amount;
    }

    public int getPurchases() {
        return purchases;
    }

    public String getCode() {
        return code;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Department getDepartment() {
        return department;
    }

}
