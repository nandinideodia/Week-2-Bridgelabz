import java.util.Scanner;

public class ThisStaticSubmission{

    // Sample Program 1: Bank Account System
    static class BankAccount {
        // Static variable shared by all accounts
        private static String bankName = "Global Bank";
        private static int totalAccounts = 0;

        // Instance variables
        private final String accountNumber;  // final variable
        private String accountHolderName;
        private double balance;

        // Constructor using 'this' to resolve ambiguity
        public BankAccount(String accountNumber, String accountHolderName, double balance) {
            this.accountNumber = accountNumber;  // using 'this' to refer to instance variable
            this.accountHolderName = accountHolderName;
            this.balance = balance;
            totalAccounts++;  // increment total accounts when a new one is created
        }

        // Static method to get total accounts
        public static void getTotalAccounts() {
            System.out.println("Total accounts in " + bankName + ": " + totalAccounts);
        }

        // Method to display account details
        public void displayAccountDetails() {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
        }

        // Method to check if an object is a BankAccount instance before displaying details
        public static void checkAndDisplay(Object obj) {
            if (obj instanceof BankAccount) {
                System.out.println("This is a valid BankAccount object:");
                ((BankAccount) obj).displayAccountDetails();
            } else {
                System.out.println("This is not a BankAccount object");
            }
        }

        public static void testBankAccount() {
            // Create some bank accounts
            BankAccount account1 = new BankAccount("123456789", "John Doe", 1000.0);
            BankAccount account2 = new BankAccount("987654321", "Jane Smith", 5000.0);

            // Display account details
            System.out.println("Account 1 Details:");
            account1.displayAccountDetails();
            System.out.println();

            System.out.println("Account 2 Details:");
            account2.displayAccountDetails();
            System.out.println();

            // Show total accounts
            BankAccount.getTotalAccounts();

            // Try to change account number (this would cause a compilation error)
            // account1.accountNumber = "111111111";  // Error: cannot assign to final variable

            // Change bank name (affects all accounts)
            BankAccount.bankName = "International Bank";
            System.out.println("\nAfter bank name change:");
            account1.displayAccountDetails();
            System.out.println();

            // Check objects using instanceof
            System.out.println("Checking objects with instanceof:");
            BankAccount.checkAndDisplay(account1);  // Valid BankAccount
            BankAccount.checkAndDisplay("Not an account");  // Not a BankAccount

            // Create another account
            BankAccount account3 = new BankAccount("555555555", "Alice Johnson", 2500.0);
            System.out.println("\nCreated a new account:");
            account3.displayAccountDetails();
            System.out.println();

            // Show updated total accounts
            BankAccount.getTotalAccounts();
        }
    }

    // Sample Program 2: Library Management System
    static class Book {
        private String title;
        private String author;
        private final String isbn; // Final variable
        private static String libraryName = "Central Library"; // Static variable

        public Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getIsbn() {
            return isbn;
        }

        public static void displayLibraryName() { // Static method
            System.out.println("Library Name: " + libraryName);
        }

        public void displayBookDetails() {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }

        public static void testBook() {
            Book book1 = new Book("The Lord of the Rings", "J.R.R. Tolkien", "978-0547928227");
            Book book2 = new Book("Pride and Prejudice", "Jane Austen", "978-0141439518");

            Book.displayLibraryName();

            if (book1 instanceof Book) {
                System.out.println("\nBook 1 Details:");
                book1.displayBookDetails();
            }

            if (book2 instanceof Book) {
                System.out.println("\nBook 2 Details:");
                book2.displayBookDetails();
            }
        }
    }

    // Sample Program 3: Employee Management System
    static class Employee {
        private String name;
        private final int id; // Final variable
        private String designation;
        private static String companyName = "Tech Innovators Inc."; // Static variable
        private static int totalEmployees = 0;

        public Employee(String name, int id, String designation) {
            this.name = name;
            this.id = id;
            this.designation = designation;
            totalEmployees++; // Increment the employee count
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public String getDesignation() {
            return designation;
        }

        public static void displayTotalEmployees() { // Static method
            System.out.println("Total Employees: " + totalEmployees);
        }

        public void displayEmployeeDetails() {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Designation: " + designation);
            System.out.println("Company: " + companyName);
        }

        public static void testEmployee() {
            Employee emp1 = new Employee("Alice Smith", 101, "Software Engineer");
            Employee emp2 = new Employee("Bob Johnson", 102, "Senior Developer");
            Employee emp3 = new Employee("Charlie Brown", 103, "Project Manager");


            // Using the static method to display total employees
            Employee.displayTotalEmployees();

            // Using instanceof to verify the object type before displaying details
            if (emp1 instanceof Employee) {
                System.out.println("\nEmployee 1 Details:");
                emp1.displayEmployeeDetails();
            }

            if (emp2 instanceof Employee) {
                System.out.println("\nEmployee 2 Details:");
                emp2.displayEmployeeDetails();
            }

            if (emp3 instanceof Employee) {
                System.out.println("\nEmployee 3 Details:");
                emp3.displayEmployeeDetails();
            }

            //Demonstrate final
            //emp1.id = 200; //This line would cause a compilation error.
        }
    }

    // Sample Program 4: Shopping Cart System
    static class Product {
        private String productName;
        private double price;
        private int quantity;
        private final int productID; // Final variable
        private static double discount = 0.0; // Static variable

        public Product(String productName, double price, int quantity, int productID) {
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
            this.productID = productID;
        }

        public String getProductName() {
            return productName;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public int getProductID() {
            return productID;
        }

        public static void updateDiscount(double newDiscount) { // Static method
            discount = newDiscount;
        }

        public double calculateDiscountedPrice() {
            return price * (1 - discount);
        }

        public void displayProductDetails() {
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Product ID: " + productID);
            System.out.println("Discounted Price: $" + calculateDiscountedPrice());
        }

        public static void testProduct() {
            Product product1 = new Product("Laptop", 1200.00, 5, 1);
            Product product2 = new Product("Mouse", 25.00, 10, 2);
            Product.updateDiscount(0.10);

            if (product1 instanceof Product) {
                System.out.println("\nProduct 1 Details:");
                product1.displayProductDetails();
            }

            if (product2 instanceof Product) {
                System.out.println("\nProduct 2 Details:");
                product2.displayProductDetails();
            }
        }
    }

    // Sample Program 5: University Student Management
    static class Student {
        private String name;
        private final int rollNumber; // Final variable
        private String grade;
        private static String universityName = "Tech University"; // Static variable
        private static int totalStudents = 0;

        public Student(String name, int rollNumber, String grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
            totalStudents++;
        }

        public String getName() {
            return name;
        }

        public int getRollNumber() {
            return rollNumber;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public static void displayTotalStudents() {
            System.out.println("Total Students: " + totalStudents);
        }

        public void displayStudentDetails() {
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
            System.out.println("University Name: " + universityName);
        }

        public static void testStudent() {
            Student student1 = new Student("Alice", 101, "A");
            Student student2 = new Student("Bob", 102, "B");

            Student.displayTotalStudents();

            if (student1 instanceof Student) {
                System.out.println("\nStudent 1 Details:");
                student1.displayStudentDetails();
            }

            if (student2 instanceof Student) {
                System.out.println("\nStudent 2 Details:");
                student2.displayStudentDetails();
            }

            student1.setGrade("A+");
            System.out.println("\nUpdated " + student1.getName() + "'s grade to: " + student1.getGrade());
        }
    }

    // Sample Program 6: Vehicle Registration System
    static class Vehicle {
        private String ownerName;
        private String vehicleType;
        private final String registrationNumber; // Final variable
        private static double registrationFee = 100.0;

        public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
            this.ownerName = ownerName;
            this.vehicleType = vehicleType;
            this.registrationNumber = registrationNumber;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public String getRegistrationNumber() {
            return registrationNumber;
        }

        public static void updateRegistrationFee(double newFee) { // Static method
            registrationFee = newFee;
        }

        public void displayVehicleDetails() {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        }

        public static void testVehicle() {
            Vehicle vehicle1 = new Vehicle("John Doe", "Car", "XYZ123");
            Vehicle vehicle2 = new Vehicle("Jane Smith", "Motorcycle", "ABC456");

            Vehicle.updateRegistrationFee(150.0); // Update to $150.00

            if (vehicle1 instanceof Vehicle) {
                System.out.println("\nVehicle 1 Details:");
                vehicle1.displayVehicleDetails();
            }

            if (vehicle2 instanceof Vehicle) {
                System.out.println("\nVehicle 2 Details:");
                vehicle2.displayVehicleDetails();
            }
        }
    }

    // Sample Program 7: Hospital Management System
    static class Patient {
        private String name;
        private int age;
        private String ailment;
        private final int patientID; // Final variable
        private static String hospitalName = "City General Hospital"; // Static variable
        private static int totalPatients = 0;

        public Patient(String name, int age, String ailment, int patientID) {
            this.name = name;
            this.age = age;
            this.ailment = ailment;
            this.patientID = patientID;
            totalPatients++; // Increment patient count
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getAilment() {
            return ailment;
        }

        public int getPatientID() {
            return patientID;
        }

        public static int getTotalPatients() { // Static method
            return totalPatients;
        }

        public void displayPatientDetails() {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Hospital: " + hospitalName);
        }

        public static void testPatient() {
            Patient patient1 = new Patient("Alice Johnson", 30, "Fever", 1001);
            Patient patient2 = new Patient("Bob Williams", 45, "Fracture", 1002);

            // Using the static method to get the total number of patients
            System.out.println("\nTotal Patients: " + Patient.getTotalPatients());

            // Using instanceof to validate object type before processing
            if (patient1 instanceof Patient) {
                System.out.println("\nPatient 1 Details:");
                patient1.displayPatientDetails();
            }

            if (patient2 instanceof Patient) {
                System.out.println("\nPatient 2 Details:");
                patient2.displayPatientDetails();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Choose a Program to Run ---");
            System.out.println("1. Bank Account System");
            System.out.println("2. Library Management System");
            System.out.println("3. Employee Management System");
            System.out.println("4. Shopping Cart System");
            System.out.println("5. University Student Management");
            System.out.println("6. Vehicle Registration System");
            System.out.println("7. Hospital Management System");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    BankAccount.testBankAccount();
                    break;
                case 2:
                    Book.testBook();
                    break;
                case 3:
                    Employee.testEmployee();
                    break;
                case 4:
                    Product.testProduct();
                    break;
                case 5:
                    Student.testStudent();
                    break;
                case 6:
                    Vehicle.testVehicle();
                    break;
                case 7:
                    Patient.testPatient();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
