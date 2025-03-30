public class EncapsulationSubmission {
    // Employee.java
    public abstract class Employee {
        private String employeeId;
        private String name;
        protected double baseSalary;
        private String department;

        public Employee(String employeeId, String name, double baseSalary) {
            this.employeeId = employeeId;
            this.name = name;
            this.baseSalary = baseSalary;
        }

        public abstract double calculateSalary();

        public void displayDetails() {
            System.out.println("ID: " + employeeId);
            System.out.println("Name: " + name);
            System.out.println("Base Salary: " + baseSalary);
            System.out.println("Department: " + department);
        }

        // Getters and setters
        public String getEmployeeId() { return employeeId; }
        public String getName() { return name; }
        public double getBaseSalary() { return baseSalary; }
        public String getDepartment() { return department; }
        public void setDepartment(String department) { this.department = department; }
    }

    // FullTimeEmployee.java
    public class FullTimeEmployee extends Employee {
        private double bonus;

        public FullTimeEmployee(String employeeId, String name, double baseSalary, double bonus) {
            super(employeeId, name, baseSalary);
            this.bonus = bonus;
        }

        @Override
        public double calculateSalary() {
            return getBaseSalary() + bonus;
        }
    }

    // PartTimeEmployee.java
    public class PartTimeEmployee extends Employee {
        private int hoursWorked;
        private double hourlyRate;

        public PartTimeEmployee(String employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
            super(employeeId, name, baseSalary);
            this.hoursWorked = hoursWorked;
            this.hourlyRate = hourlyRate;
        }

        @Override
        public double calculateSalary() {
            return hoursWorked * hourlyRate;
        }
    }

    // Department.java (interface)
    public interface Department {
        void assignDepartment(String department);
        String getDepartmentDetails();
    }

    // Main.java
    public class Main {
        public static void main(String[] args) {
            Employee emp1 = new FullTimeEmployee("E001", "John Doe", 50000, 10000);
            Employee emp2 = new PartTimeEmployee("E002", "Jane Smith", 0, 80, 25);

            emp1.setDepartment("IT");
            emp2.setDepartment("HR");

            Employee[] employees = {emp1, emp2};

            for (Employee emp : employees) {
                emp.displayDetails();
                System.out.println("Total Salary: " + emp.calculateSalary());
                System.out.println("-------------------");
            }
        }
    }


    // Product.java
    public abstract class Product {
        private String productId;
        private String name;
        protected double price;

        public Product(String productId, String name, double price) {
            this.productId = productId;
            this.name = name;
            this.price = price;
        }

        public abstract double calculateDiscount();

        // Getters and setters
        public String getProductId() { return productId; }
        public String getName() { return name; }
        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }
    }

    // Electronics.java
    public class Electronics extends Product implements Taxable {
        private double warrantyCost;

        public Electronics(String productId, String name, double price, double warrantyCost) {
            super(productId, name, price);
            this.warrantyCost = warrantyCost;
        }

        @Override
        public double calculateDiscount() {
            return price * 0.1; // 10% discount
        }

        @Override
        public double calculateTax() {
            return price * 0.15; // 15% tax
        }

        @Override
        public String getTaxDetails() {
            return "Electronics tax rate: 15%";
        }
    }

    // Taxable.java (interface)
    public interface Taxable {
        double calculateTax();
        String getTaxDetails();
    }

    // Main.java
    public class Main {
        public static void printFinalPrice(Product product) {
            double discount = product.calculateDiscount();
            double tax = 0;

            if (product instanceof Taxable) {
                tax = ((Taxable) product).calculateTax();
            }

            double finalPrice = product.getPrice() + tax - discount;

            System.out.println("Product: " + product.getName());
            System.out.println("Base Price: " + product.getPrice());
            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("-------------------");
        }

        public static void main(String[] args) {
            Product[] products = {
                    new Electronics("P001", "Laptop", 1000, 100),
                    new Clothing("P002", "T-Shirt", 20)
            };

            for (Product product : products) {
                printFinalPrice(product);
            }
        }
    }

    // Key components:
    public abstract class Vehicle {
        private String vehicleNumber;
        private String type;
        protected double rentalRate;

        public abstract double calculateRentalCost(int days);
    }

    public interface Insurable {
        double calculateInsurance();
        String getInsuranceDetails();
    }

    public class Car extends Vehicle implements Insurable {
        @Override
        public double calculateRentalCost(int days) {
            return days * rentalRate;
        }

        @Override
        public double calculateInsurance() {
            return rentalRate * 0.1;
        }
    }

    // Key components:
    public abstract class BankAccount {
        private String accountNumber;
        private String holderName;
        protected double balance;

        public abstract double calculateInterest();

        public void deposit(double amount) { balance += amount; }
        public void withdraw(double amount) { balance -= amount; }
    }

    public interface Loanable {
        void applyForLoan(double amount);
        double calculateLoanEligibility();
    }

    public class SavingsAccount extends BankAccount {
        @Override
        public double calculateInterest() {
            return balance * 0.04; // 4% interest
        }
    }

    // Key components:
    public abstract class LibraryItem {
        private String itemId;
        private String title;
        private String author;

        public abstract int getLoanDuration();
        public String getItemDetails() {
            return "Title: " + title + ", Author: " + author;
        }
    }

    public interface Reservable {
        boolean reserveItem(String borrowerId);
        boolean checkAvailability();
    }

    public class Book extends LibraryItem implements Reservable {
        @Override
        public int getLoanDuration() {
            return 21; // 3 weeks
        }
    }

    // Key components:
    public abstract class FoodItem {
        private String itemName;
        protected double price;
        private int quantity;

        public abstract double calculateTotalPrice();
    }

    public interface Discountable {
        void applyDiscount(double percentage);
        String getDiscountDetails();
    }

    public class NonVegItem extends FoodItem implements Discountable {
        private double premiumCharge = 1.2;

        @Override
        public double calculateTotalPrice() {
            return price * quantity * premiumCharge;
        }
    }

    // Key components:
    public abstract class Patient {
        private String patientId;
        private String name;
        private int age;

        public abstract double calculateBill();
        public String getPatientDetails() {
            return "ID: " + patientId + ", Name: " + name;
        }
    }

    public interface MedicalRecord {
        void addRecord(String record);
        List<String> viewRecords();
    }

    public class InPatient extends Patient {
        private int daysAdmitted;

        @Override
        public double calculateBill() {
            return daysAdmitted * 500; // $500 per day
        }
    }

    // Key components:
    public abstract class Vehicle {
        private String vehicleId;
        private String driverName;
        protected double ratePerKm;

        public abstract double calculateFare(double distance);
        public String getVehicleDetails() {
            return "Vehicle ID: " + vehicleId + ", Driver: " + driverName;
        }
    }

    public interface GPS {
        String getCurrentLocation();
        void updateLocation(String newLocation);
    }

    public class Auto extends Vehicle implements GPS {
        @Override
        public double calculateFare(double distance) {
            return distance * ratePerKm * 1.1; // 10% premium
        }

        @Override
        public String getCurrentLocation() {
            return "Current location from GPS";
        }
    }
}
