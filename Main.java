import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InventoryManagementSystem {
    private static Map<String, Product> inventory = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Product\n2. Sell Product\n3. View Inventory\n4. Generate Reports\n5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    sellProduct(scanner);
                    break;
                case 3:
                    viewInventory();
                    break;
                case 4:
                    generateReports();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        Product product = new Product(name, quantity, price);
        inventory.put(name, product);

        System.out.println("Product added successfully.");
    }

    private static void sellProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        if (inventory.containsKey(name)) {
            Product product = inventory.get(name);

            System.out.print("Enter quantity to sell: ");
            int quantityToSell = scanner.nextInt();

            if (quantityToSell <= product.getQuantity()) {
                product.sell(quantityToSell);
                System.out.println("Sale successful. Total cost: $" + (quantityToSell * product.getPrice()));
            } else {
                System.out.println("Not enough stock available.");
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void viewInventory() {
        System.out.println("\nInventory:");
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    private static void generateReports() {
        System.out.println("\nBest-Selling Products Report:");
        inventory.values().stream()
                .sorted((p1, p2) -> Integer.compare(p2.getTotalSold(), p1.getTotalSold()))
                .limit(5) // Display the top 5 best-selling products
                .forEach(product -> System.out.println(product.getName() + " - Quantity Sold: " + product.getTotalSold()));
        int lowStockThreshold = 10; 
        System.out.println("\nLow-Stock products Report:");
        inventory.values().stream()
                .filter(product -> product.getQuantity() < lowStockThreshold)
                .forEach(product -> System.out.println(product.getName() + " -Quantiy instock: " + product.getQuantity()));
    }

    static class Product {
        private String name;
        private int quantity;
        private double price;
        private int totalSold;

        public Product(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
            this.totalSold = 0;
        }

        public void sell(int quantitySold) {
            if (quantitySold <= quantity) {
                quantity -= quantitySold;
                totalSold += quantitySold;
            } else {
                System.out.println("Error: trying to sell more quantity than available.");
            }
        }

        public String toString() {
            return "Product: " + name + ", Quantity: " + quantity + ", Price: " + price;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }

        public int getTotalSold() {
            return totalSold;
        }

        public String getName() {
            return name;
        }
    }
}
