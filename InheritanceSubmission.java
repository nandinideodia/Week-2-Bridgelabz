import java.util.Scanner;

public class InheritanceSubmission {

    // Animal Hierarchy
    static class Animal {
        String name;
        int age;

        void makeSound() {
            System.out.println("Animal sound");
        }
    }

    static class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Barking");
        }
    }

    static class Cat extends Animal {
        @Override
        void makeSound() {
            System.out.println("Meow");
        }
    }

    static void testAnimalHierarchy() {
        Cat cat = new Cat();
        cat.makeSound();
    }

    // Employee Management System
    static class Employee {
        String name;
        int id;
        int salary;

        public Employee() {
            this.name = "Nandini";
            this.id = 1;
            this.salary = 9999;
        }

        void displayDetails() {
            System.out.println(name);
            System.out.println(id);
            System.out.println(salary);
        }
    }

    static class Manager extends Employee {
        int teamSize = 5;

        @Override
        void displayDetails() {
            super.displayDetails(); // Call the superclass method to display common details
            System.out.println(teamSize);
        }
    }

    static void testEmployeeManagementSystem() {
        Manager manager = new Manager();
        manager.displayDetails();
    }

    // Vehicle and Transport System
    // Superclass Vehicle
    static class Vehicle {
        protected int maxSpeed;
        protected String fuelType;

        public Vehicle(int maxSpeed, String fuelType) {
            this.maxSpeed = maxSpeed;
            this.fuelType = fuelType;
        }

        public void displayInfo() {
            System.out.println("Vehicle Information:");
            System.out.println("Max Speed: " + maxSpeed + " km/h");
            System.out.println("Fuel Type: " + fuelType);
        }
    }

    // Subclass Car
    static class Car extends Vehicle {
        private int seatCapacity;
        private String carType;

        public Car(int maxSpeed, String fuelType, int seatCapacity, String carType) {
            super(maxSpeed, fuelType);
            this.seatCapacity = seatCapacity;
            this.carType = carType;
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Type: Car");
            System.out.println("Seat Capacity: " + seatCapacity);
            System.out.println("Car Type: " + carType);
        }
    }

    // Subclass Truck
    static class Truck extends Vehicle {
        private double cargoCapacity;
        private int axleCount;

        public Truck(int maxSpeed, String fuelType, double cargoCapacity, int axleCount) {
            super(maxSpeed, fuelType);
            this.cargoCapacity = cargoCapacity;
            this.axleCount = axleCount;
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Type: Truck");
            System.out.println("Cargo Capacity: " + cargoCapacity + " tons");
            System.out.println("Axle Count: " + axleCount);
        }
    }

    // Subclass Motorcycle
    static class Motorcycle extends Vehicle {
        private boolean hasSidecar;
        private String bikeType;

        public Motorcycle(int maxSpeed, String fuelType, boolean hasSidecar, String bikeType) {
            super(maxSpeed, fuelType);
            this.hasSidecar = hasSidecar;
            this.bikeType = bikeType;
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Type: Motorcycle");
            System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
            System.out.println("Bike Type: " + bikeType);
        }
    }

    static void testVehicleAndTransportSystem() {
        // Create an array of Vehicle type to store different vehicle objects
        Vehicle[] vehicles = new Vehicle[4];

        // Initialize different vehicle types
        vehicles[0] = new Car(180, "Petrol", 5, "Sedan");
        vehicles[1] = new Truck(120, "Diesel", 15.5, 3);
        vehicles[2] = new Motorcycle(160, "Petrol", false, "Sports");
        vehicles[3] = new Car(200, "Electric", 2, "Sports Car");

        System.out.println("Transport System Vehicle Information:");
        System.out.println("------------------------------------");

        // Demonstrate polymorphism by calling displayInfo() on each vehicle
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
            System.out.println("------------------------------------");
        }
    }

    // Single Inheritance
    // Sample Problem 1: Library Management with Books and Authors
    // Superclass Book
    static class Book {
        protected String title;
        protected int publicationYear;

        public Book(String title, int publicationYear) {
            this.title = title;
            this.publicationYear = publicationYear;
        }

        public void displayInfo() {
            System.out.println("Book Title: " + title);
            System.out.println("Publication Year: " + publicationYear);
        }
    }

    // Subclass Author
    static class Author extends Book {
        private String name;
        private String bio;

        public Author(String title, int publicationYear, String name, String bio) {
            super(title, publicationYear);
            this.name = name;
            this.bio = bio;
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Author Name: " + name);
            System.out.println("Author Bio: " + bio);
        }
    }

    static void testBookSystem() {
        Author book1 = new Author("The Great Gatsby", 1925, "F. Scott Fitzgerald", "American novelist and short story writer");
        Author book2 = new Author("To Kill a Mockingbird", 1960, "Harper Lee", "American novelist best known for this novel");

        System.out.println("Book System Information:");
        System.out.println("-----------------------");
        book1.displayInfo();
        System.out.println("-----------------------");
        book2.displayInfo();
        System.out.println("-----------------------");
    }

    // Sample Problem 2: Smart Home Devices
    // Description: Create a hierarchy for a smart home system where Device is the superclass and Thermostat is a subclass.
    // Tasks:
    // Define a superclass Device with attributes like deviceId and status.
    // Create a subclass Thermostat with additional attributes like temperatureSetting.
    // Implement a method displayStatus() to show each device's current settings.
    // Goal: Understand single inheritance by adding specific attributes to a subclass, keeping the superclass general.
    static class Device {
        protected int deviceId;
        protected boolean status;

        public Device(int deviceId, boolean status) {
            this.deviceId = deviceId;
            this.status = status;
        }

        public void displayStatus() {
            System.out.println("Device ID: " + deviceId);
            System.out.println("Status: " + (status ? "On" : "Off"));
        }
    }

    static class Thermostat extends Device {
        private double temperatureSetting;

        public Thermostat(int deviceId, boolean status, double temperatureSetting) {
            super(deviceId, status);
            this.temperatureSetting = temperatureSetting;
        }

        @Override
        public void displayStatus() {
            super.displayStatus();
            System.out.println("Temperature Setting: " + temperatureSetting + "°C");
        }
    }

    static void testSmartHomeDevices() {
        Thermostat thermostat = new Thermostat(1, true, 22.5);
        System.out.println("Thermostat Status:");
        thermostat.displayStatus();
    }


    // Multilevel Inheritance
    // Sample Problem 1: Online Retail Order Management
    static class Order {
        protected String orderId;
        protected String orderDate;

        public Order(String orderId, String orderDate) {
            this.orderId = orderId;
            this.orderDate = orderDate;
        }

        public String getOrderStatus() {
            return "Order placed";
        }
    }

    static class ShippedOrder extends Order {
        protected String trackingNumber;

        public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
            super(orderId, orderDate);
            this.trackingNumber = trackingNumber;
        }

        @Override
        public String getOrderStatus() {
            return "Order shipped with tracking: " + trackingNumber;
        }
    }

    static class DeliveredOrder extends ShippedOrder {
        private String deliveryDate;

        public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
            super(orderId, orderDate, trackingNumber);
            this.deliveryDate = deliveryDate;
        }

        @Override
        public String getOrderStatus() {
            return "Order delivered on " + deliveryDate + " (Tracking: " + trackingNumber + ")";
        }
    }

    static void testOrderManagement() {
        Order order1 = new Order("ORD001", "2023-10-01");
        ShippedOrder order2 = new ShippedOrder("ORD002", "2023-10-02", "TRK12345");
        DeliveredOrder order3 = new DeliveredOrder("ORD003", "2023-10-03", "TRK67890", "2023-10-05");

        System.out.println("Order Status:");
        System.out.println(order1.getOrderStatus());
        System.out.println(order2.getOrderStatus());
        System.out.println(order3.getOrderStatus());
    }

    // Sample Problem 2: Educational Course Hierarchy
    static class Course {
        protected String courseName;
        protected int duration;

        public Course(String courseName, int duration) {
            this.courseName = courseName;
            this.duration = duration;
        }

        public void displayCourseInfo() {
            System.out.println("Course: " + courseName);
            System.out.println("Duration: " + duration + " weeks");
        }
    }

    static class OnlineCourse extends Course {
        protected String platform;
        protected boolean isRecorded;

        public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
            super(courseName, duration);
            this.platform = platform;
            this.isRecorded = isRecorded;
        }

        @Override
        public void displayCourseInfo() {
            super.displayCourseInfo();
            System.out.println("Platform: " + platform);
            System.out.println("Recorded: " + isRecorded);
        }
    }

    static class PaidOnlineCourse extends OnlineCourse {
        private double fee;
        private double discount;

        public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
            super(courseName, duration, platform, isRecorded);
            this.fee = fee;
            this.discount = discount;
        }

        @Override
        public void displayCourseInfo() {
            super.displayCourseInfo();
            System.out.println("Fee: $" + fee);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Final Price: $" + (fee - (fee * discount / 100)));
        }
    }

    static void testCourseSystem() {
        Course basicCourse = new Course("Java Basics", 4);
        OnlineCourse webCourse = new OnlineCourse("Web Development", 8, "Udemy", true);
        PaidOnlineCourse advancedCourse = new PaidOnlineCourse("Advanced Algorithms", 12, "Coursera", true, 199.99, 15);

        System.out.println("Course Information:");
        System.out.println("------------------");
        basicCourse.displayCourseInfo();
        System.out.println("------------------");
        webCourse.displayCourseInfo();
        System.out.println("------------------");
        advancedCourse.displayCourseInfo();
    }

    // Hierarchical Inheritance
    // Sample Problem 1: Bank Account Types
    static class BankAccount {
        protected String accountNumber;
        protected double balance;

        public BankAccount(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public void displayAccountInfo() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
        }
    }

    static class SavingsAccount extends BankAccount {
        private double interestRate;

        public SavingsAccount(String accountNumber, double balance, double interestRate) {
            super(accountNumber, balance);
            this.interestRate = interestRate;
        }

        public void displayAccountType() {
            System.out.println("Account Type: Savings Account");
            System.out.println("Interest Rate: " + interestRate + "%");
        }
    }

    static class CheckingAccount extends BankAccount {
        private double withdrawalLimit;

        public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
            super(accountNumber, balance);
            this.withdrawalLimit = withdrawalLimit;
        }

        public void displayAccountType() {
            System.out.println("Account Type: Checking Account");
            System.out.println("Daily Withdrawal Limit: $" + withdrawalLimit);
        }
    }

    static class FixedDepositAccount extends BankAccount {
        private int termMonths;

        public FixedDepositAccount(String accountNumber, double balance, int termMonths) {
            super(accountNumber, balance);
            this.termMonths = termMonths;
        }

        public void displayAccountType() {
            System.out.println("Account Type: Fixed Deposit Account");
            System.out.println("Term: " + termMonths + " months");
        }
    }

    static void testBankingSystem() {
        SavingsAccount savings = new SavingsAccount("SAV001", 5000.0, 3.5);
        CheckingAccount checking = new CheckingAccount("CHK001", 2500.0, 1000.0);
        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FD001", 10000.0, 12);

        System.out.println("Bank Account Information:");
        System.out.println("-----------------------");
        savings.displayAccountInfo();
        savings.displayAccountType();
        System.out.println("-----------------------");
        checking.displayAccountInfo();
        checking.displayAccountType();
        System.out.println("-----------------------");
        fixedDeposit.displayAccountInfo();
        fixedDeposit.displayAccountType();
    }

    // Sample Problem 2: School System with Different Roles
    // Description: Create a hierarchy for a school system where Person is the superclass, and Teacher, Student, and Staff are subclasses.
    // Tasks:
    // Define a superclass Person with common attributes like name and age.
    // Define subclasses Teacher, Student, and Staff with specific attributes (e.g., subject for Teacher and grade for Student).
    // Each subclass should have a method like displayRole() that describes the role.
    // Goal: Demonstrate hierarchical inheritance by modeling different roles in a school, each with shared and unique characteristics.
    static class Person {
        protected String name;
        protected int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void displayPersonInfo() {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        }
    }

    static class Teacher extends Person {
        private String subject;

        public Teacher(String name, int age, String subject) {
            super(name, age);
            this.subject = subject;
        }

        public void displayRole() {
            System.out.println("Role: Teacher");
            System.out.println("Subject: " + subject);
        }

        @Override
        public void displayPersonInfo() {
            super.displayPersonInfo();
            displayRole();
        }
    }

    static class Student extends Person {
        private int grade;

        public Student(String name, int age, int grade) {
            super(name, age);
            this.grade = grade;
        }

        public void displayRole() {
            System.out.println("Role: Student");
            System.out.println("Grade: " + grade);
        }

        @Override
        public void displayPersonInfo() {
            super.displayPersonInfo();
            displayRole();
        }
    }

    static class Staff extends Person {
        private String jobTitle;

        public Staff(String name, int age, String jobTitle) {
            super(name, age);
            this.jobTitle = jobTitle;
        }

        public void displayRole() {
            System.out.println("Role: Staff");
            System.out.println("Job Title: " + jobTitle);
        }

        @Override
        public void displayPersonInfo() {
            super.displayPersonInfo();
            displayRole();
        }
    }

    static void testSchoolSystem() {
        Teacher teacher = new Teacher("Mr. Smith", 35, "Mathematics");
        Student student = new Student("Alice", 16, 11);
        Staff staff = new Staff("Mrs. Johnson", 40, "Librarian");

        System.out.println("School System Information:");
        System.out.println("-----------------------");
        teacher.displayPersonInfo();
        System.out.println("-----------------------");
        student.displayPersonInfo();
        System.out.println("-----------------------");
        staff.displayPersonInfo();
    }


    // Hybrid Inheritance (Simulating Multiple Inheritance)
    // Sample Problem 1: Restaurant Management System with Hybrid Inheritance
    static class Person2 {
        protected String name;
        protected int id;

        public Person2(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public void displayPersonInfo() {
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
        }
    }

    interface Worker {
        void performDuties();
    }

    static class Chef extends Person2 implements Worker {
        private String specialization;

        public Chef(String name, int id, String specialization) {
            super(name, id);
            this.specialization = specialization;
        }

        @Override
        public void performDuties() {
            System.out.println("Chef " + name + " is cooking " + specialization + ".");
        }

        @Override
        public void displayPersonInfo() {
            super.displayPersonInfo();
            System.out.println("Specialization: " + specialization);

        }
    }

    static class Waiter extends Person2 implements Worker {
        private int tableNumber;

        public Waiter(String name, int id, int tableNumber) {
            super(name, id);
            this.tableNumber = tableNumber;
        }

        @Override
        public void performDuties() {
            System.out.println("Waiter " + name + " is serving table " + tableNumber + ".");
        }

        @Override
        public void displayPersonInfo() {
            super.displayPersonInfo();
            System.out.println("Table Number: " + tableNumber);
        }
    }

    static void testRestaurantManagementSystem() {
        Chef chef = new Chef("Gordon Ramsay", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("John", 201, 5);

        System.out.println("Restaurant Staff Information:");
        System.out.println("-----------------------");
        chef.displayPersonInfo();
        chef.performDuties();
        System.out.println("-----------------------");
        waiter.displayPersonInfo();
        waiter.performDuties();
    }

    // Sample Problem 2: Vehicle Management System with Hybrid Inheritance
    interface Refuelable {
        void refuel();
    }

    static class Vehicle2 {
        private int maxSpeed;
        private String model;

        public Vehicle2(int maxSpeed, String model) {
            this.maxSpeed = maxSpeed;
            this.model = model;
        }

        public int getMaxSpeed() {
            return maxSpeed;
        }

        public String getModel() {
            return model;
        }

        public void displayVehicleInfo() {
            System.out.println("Model: " + model);
            System.out.println("Max Speed: " + maxSpeed);
        }
    }

    static class ElectricVehicle extends Vehicle2 {
        private int batteryCapacity;

        public ElectricVehicle(int maxSpeed, String model, int batteryCapacity) {
            super(maxSpeed, model);
            this.batteryCapacity = batteryCapacity;
        }

        public int getBatteryCapacity() {
            return batteryCapacity;
        }

        public void charge() {
            System.out.println("Charging the electric vehicle.");
        }

        @Override
        public void displayVehicleInfo() {
            super.displayVehicleInfo();
            System.out.println("Battery Capacity: " + batteryCapacity);
        }
    }

    static class PetrolVehicle extends Vehicle2 implements Refuelable {
        private int fuelCapacity;

        public PetrolVehicle(int maxSpeed, String model, int fuelCapacity) {
            super(maxSpeed, model);
            this.fuelCapacity = fuelCapacity;
            this.fuelCapacity = fuelCapacity;
        }

        public int getFuelCapacity() {
            return fuelCapacity;
        }

        @Override
        public void refuel() {
            System.out.println("Refueling the petrol vehicle.");
        }

        @Override
        public void displayVehicleInfo() {
            super.displayVehicleInfo();
            System.out.println("Fuel Capacity: " + fuelCapacity);
        }
    }

    static void testVehicleManagementSystem() {
        ElectricVehicle tesla = new ElectricVehicle(200, "Tesla Model S", 100);
        PetrolVehicle toyota = new PetrolVehicle(180, "Toyota Camry", 70);

        System.out.println("Vehicle Information:");
        System.out.println("-----------------------");
        tesla.displayVehicleInfo();
        tesla.charge();
        System.out.println("-----------------------");
        toyota.displayVehicleInfo();
        toyota.refuel();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Choose a Program to Run ---");
            System.out.println("1. Animal Hierarchy");
            System.out.println("2. Employee Management System");
            System.out.println("3. Vehicle and Transport System");
            System.out.println("4. Single Inheritance - Book System");
            System.out.println("5. Single Inheritance - Smart Home Devices");
            System.out.println("6. Multilevel Inheritance - Order Management");
            System.out.println("7. Multilevel Inheritance - Course System");
            System.out.println("8. Hierarchical Inheritance - Bank Account Types");
            System.out.println("9. Hierarchical Inheritance - School System");
            System.out.println("10. Hybrid Inheritance - Restaurant System");
            System.out.println("11. Hybrid Inheritance - Vehicle System");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    testAnimalHierarchy();
                    break;
                case 2:
                    testEmployeeManagementSystem();
                    break;
                case 3:
                    testVehicleAndTransportSystem();
                    break;
                case 4:
                    testBookSystem();
                    break;
                case 5:
                    testSmartHomeDevices();
                    break;
                case 6:
                    testOrderManagement();
                    break;
                case 7:
                    testCourseSystem();
                    break;
                case 8:
                    testBankingSystem();
                    break;
                case 9:
                    testSchoolSystem();
                    break;
                case 10:
                    testRestaurantManagementSystem();
                    break;
                case 11:
                    testVehicleManagementSystem();
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
