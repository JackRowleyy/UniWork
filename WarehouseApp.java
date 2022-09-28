package part03;

public class WarehouseApp {

    final int MAX = 50;

    static Department department;
    static Warehouse warehouse = new Warehouse("1");
    static String options[] = { "Add New Product", "Delete a Product", "List Products for Department",
            "List All Products",
            "Add Stock for a Product", "Sales Report", "Record Purchase", "Exit" };
    static ConsoleMenu con = new ConsoleMenu("Warehouse", options);

    public static void main(String[] args) {
        initialize();
        int choice;
        do {
            choice = con.getUserChoice();
            if (choice == options.length) {
                break;
            }
            processChoice(choice);
        } while (true);

        con.println("App Terminated.");

    }

    public static void initialize() {
        warehouse.addProduct("Model1", "Make1", 100.0, Department.ELECTRICAL);
        warehouse.addProduct("Model2", "Make2", 200.0, Department.ELECTRICAL);
        warehouse.addProduct("Model3", "Make3", 300.0, Department.PHOTOGRAPHIC);
        warehouse.addProduct("Model4", "Make4", 400.0, Department.PHOTOGRAPHIC);
        warehouse.addProduct("Model5", "Make5", 500.0, Department.COMPUTING);
        warehouse.addProduct("Model6", "Make6", 600.0, Department.COMPUTING);
        warehouse.addProduct("Model7", "Make7", 700.0, Department.BOOKS);
        warehouse.addProduct("Model8", "Make8", 800.0, Department.BOOKS);
        warehouse.addProduct("Model9", "Make9", 900.0, Department.MUSIC);
        warehouse.addProduct("Model10", "Make10", 1000.0, Department.MUSIC);
        warehouse.addProduct("Model11", "Make11", 1100.0, Department.FASHION);
        warehouse.addProduct("Model12", "Make12", 1200.0, Department.FASHION);
        warehouse.addProduct("Model13", "Make13", 1300.0, Department.OTHER);
        warehouse.addProduct("Model14", "Make14", 1400.0, Department.OTHER);

    }

    private static void processChoice(int choice) {
        switch (choice) {
            case 1:
                addNewProduct();
                break;
            case 2:
                deleteProduct();
                break;
            case 3:
                listProductDep();
                break;
            case 4:
                listAllProducts();
                break;
            case 5:
                addStock();
                break;
            case 6:
                salesReport();
                break;
            case 7:
                recordPurchase();
                break;
            default:
                con.println("Error - Invalid Option.");
        }
    }

    public static void addNewProduct() {

        String model;
        String make;
        double price;
        String departmentStr;
        String temp;

        int quantity;
        con.println("Enter model: ");
        model = con.readLn();
        con.println("Enter make: ");
        make = con.readLn();
        con.println("Enter price: ");
        temp = con.readLn();
        price = Double.parseDouble(temp);
        con.println("Enter Department: ");
        departmentStr = con.readLn();
        con.println("Enter Quantity: ");
        temp = con.readLn();
        quantity = Integer.parseInt(temp);
        if (departmentStr.equals("Electrical")) {
            department = Department.ELECTRICAL;
        }
        if (departmentStr.equals("Photographic")) {
            department = Department.PHOTOGRAPHIC;
        }
        if (departmentStr.equals("Computing")) {
            department = Department.COMPUTING;
        }
        if (departmentStr.equals("Books")) {
            department = Department.BOOKS;
        }
        if (departmentStr.equals("Music")) {
            department = Department.MUSIC;
        }
        if (departmentStr.equals("Fashion")) {
            department = Department.FASHION;
        }
        if (departmentStr.equals("Other")) {
            department = Department.OTHER;
        }
        if (quantity > 1) {
            warehouse.addProduct(model, make, price, department, quantity);
        } else {
            warehouse.addProduct(model, make, price, department);

        }

    }

    public static void deleteProduct() {
        String code;
        if (warehouse != null) {
            con.println("Enter code of product to delete");
            code = con.readLn();
            warehouse.deleteProduct(code);
        } else {
            con.println("No products to delete.");
        }
    }

    public static void listProductDep() {
        String departmentStr = "";

        con.println("Enter Department: ");
        departmentStr = con.readLn();
        if (departmentStr.equals("Electrical")) {
            department = Department.ELECTRICAL;
            con.println(warehouse.search(department).toString());
            con.println(warehouse.search(department).get(0).getImage());

        } else if (departmentStr.equals("Photographic")) {
            department = Department.PHOTOGRAPHIC;
            con.println(warehouse.search(department).toString());
            con.println(warehouse.search(department).get(0).getImage());
        } else if (departmentStr.equals("Computing")) {
            department = Department.COMPUTING;
            con.println(warehouse.search(department).toString());
            con.println(warehouse.search(department).get(0).getImage());
        } else if (departmentStr.equals("Books")) {
            department = Department.BOOKS;
            con.println(warehouse.search(department).toString());
            con.println(warehouse.search(department).get(0).getImage());
        } else if (departmentStr.equals("Music")) {
            department = Department.MUSIC;
            con.println(warehouse.search(department).toString());
            con.println(warehouse.search(department).get(0).getImage());
        } else if (departmentStr.equals("Fashion")) {
            department = Department.FASHION;
            con.println(warehouse.search(department).toString());
            con.println(warehouse.search(department).get(0).getImage());
        } else if (departmentStr.equals("Other")) {
            department = Department.OTHER;
            con.println(warehouse.search(department).toString());
            con.println(warehouse.search(department).get(0).getImage());
        } else {
            con.println("Invalid Deparment");
        }

    }

    public static void listAllProducts() {
        for (int index = 0; index < warehouse.getAllProducts().length; index++) {
            con.println(warehouse.getAllProducts()[index].toString());
            con.print(warehouse.getAllProducts()[index].getImage());

        }

    }

    public static void addStock() {
        String code;
        String temp;
        int quantity;
        if (warehouse != null) {
            con.println("Enter code: ");
            code = con.readLn();
            con.println("Enter quantity: ");
            temp = con.readLn();
            quantity = Integer.parseInt(temp);
            warehouse.restock(code, quantity);

        } else {
            con.println("No products.");
        }
    }

    public static void salesReport() {
        int swaps;
        Product[] products = warehouse.getAllProducts();
        do {
            swaps = 0;
            for (int index = 0; index < products.length - 1; index++) {
                if (products[index].getPurchases() < products[index + 1].getPurchases()) {
                    Product temp = products[index];
                    products[index] = products[index + 1];
                    products[index + 1] = temp;
                    swaps++;
                }
            }
        } while (swaps > 0);
        con.println("Sales Report: ");
        for (int i = 0; i < products.length; i++) {
            con.println(products[i].getCode() + " Number of sales: "
                    + products[i].getPurchases());
        }

    }

    public static void recordPurchase() {
        String code;
        String temp;
        int quantity;
        if (warehouse != null) {
            con.println("Enter code: ");
            code = con.readLn();
            con.println("Enter amount of purchases: ");
            temp = con.readLn();
            quantity = Integer.parseInt(temp);
            for (int index = 0; index < warehouse.getAllProducts().length - 1; index++) {
                if (warehouse.getAllProducts()[index].getCode().equals(code)) {
                    for (int i = 0; i < quantity; i++) {
                        warehouse.getAllProducts()[index].recordPurchase();
                    }
                }
            }

        } else {
            con.println("No products.");
        }
    }

}
