**GIVEN PROJECT**
**Inventory Management System**

**Description:**
   This Java program is an Inventory Management System for a retail store. It allows users to add products to the inventory,
   sell products, view the current inventory, and generate reports.
 
**Main Features:**
   Add new products to the inventory with details such as name, quantity, and price.
   Sell products and update inventory levels accordingly.
   View the current inventory, displaying product details.
   Generate reports on best-selling products and low-stock products.

**Classes:**
   InventoryManagementSystem: The main class that drives the inventory management system.
   Product: Represents a product with attributes such as name, quantity, price, and total units sold.

**Main Methods:**
   main(String[] args): The entry point of the program. Displays a menu for users to interact with the system.
   addProduct(Scanner scanner): Allows users to add a new product to the inventory.
   sellProduct(Scanner scanner): Allows users to sell a specified quantity of a product.
   viewInventory(): Displays the current inventory with product details.
   generateReports(): Generates two reports - best-selling products and low-stock products.

**Classes and Key Methods:**
   Constructor: Initializes a new Product with a name, quantity, and price.
   sell(int quantitySold): Updates the quantity and total units sold when a product is sold.
   toString(): Returns a string representation of the product.
   getQuantity(): Returns the current quantity of the product.
   getPrice(): Returns the price of the product.
   getTotalSold(): Returns the total units sold for the product.
   getName(): Returns the name of the product.
 
