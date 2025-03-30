import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class ClassObjectSubmission {

    public class ClassObjects {

        // Program to Display Employee Details
        static class Employee {
            private String name;
            private int id;
            private int salary;

            public Employee(String name, int id, int salary) {
                this.name = name;
                this.id = id;
                this.salary = salary;
            }

            public void display() {
                System.out.println("Name: " + name);
                System.out.println("Id: " + id);
                System.out.println("Salary: " + salary);
            }
        }

        // Program to Compute Area of a Circle
        static class Circle {
            public int radius;

            public Circle(int radius) {
                this.radius = radius;
            }

            public double area() {
                return 3.14 * radius * radius;
            }
        }

        // Program to Handle Book Details
        static class Book {
            public String title;
            public String author;
            public int price;

            public Book(String title, String author, int price) {
                this.title = title;
                this.author = author;
                this.price = price;
            }

            public void display() {
                System.out.println("Book Details");
                System.out.println("Title of the book: " + title);
                System.out.println("Author of the book: " + author);
                System.out.println("Price of the book: " + price);
            }
        }

        // Program to Track Inventory of Items
        static class Item {
            public int itemCode;
            public String itemName;
            public int price;

            public Item(int itemCode, String itemName, int price) {
                this.itemCode = itemCode;
                this.itemName = itemName;
                this.price = price;
            }

            public void display() {
                System.out.println("Item Details");
                System.out.println("Item Code: " + itemCode);
                System.out.println("Name of item: " + itemName);
                System.out.println("Price: " + price);
            }
        }

        // Program to Handle Mobile Phone Details
        static class MobilePhone {
            public String brand;
            public String model;
            public int price;

            public MobilePhone(String brand, String model, int price) {
                this.brand = brand;
                this.model = model;
                this.price = price;
            }

            public void display() {
                System.out.println("Mobile Phone Details");
                System.out.println("Brand: " + brand);
                System.out.println("Model: " + model);
                System.out.println("Price: " + price);
            }
        }

        // Program to Simulate Student Report
        static class Student {
            public int rollNumber;
            public String name;
            public int marks;

            public Student(int rollNumber, String name, int marks) {
                this.rollNumber = rollNumber;
                this.name = name;
                this.marks = marks;
            }

            public void display() {
                System.out.println("Student Details");
                System.out.println("Roll Number: " + rollNumber);
                System.out.println("Name: " + name);
                System.out.println("Marks: " + marks);
            }

            public void grade() {
                String grade;
                switch (marks / 10) {
                    case 10: // 100
                    case 9:  // 90-99
                        grade = "A+";
                        break;
                    case 8:  // 80-89
                        grade = "A";
                        break;
                    case 7:  // 70-79
                        grade = "B";
                        break;
                    case 6:  // 60-69
                        grade = "C";
                        break;
                    case 5:  // 50-59
                        grade = "D";
                        break;
                    default: // 0-49
                        grade = "F";
                        break;
                }
                System.out.println("Grade: " + grade);
            }
        }

        // Program to Simulate an ATM
        static class BankAccount {
            public int accountNumber;
            public String accountHolder;
            public int balance;

            public BankAccount(int accountNumber, String accountHolder, int balance) {
                this.accountNumber = accountNumber;
                this.accountHolder = accountHolder;
                this.balance = balance;
            }

            public void displayBalance() {
                System.out.println("Current Balance: " + balance);
            }

            public void deposit(int amount) {
                balance += amount;
            }

            public void withdraw(int amount) {
                if (balance > amount) {
                    balance -= amount;
                } else {
                    System.out.println("Insufficient balance");
                }
            }
        }

        // Program to Check Palindrome String
        static class PalindromeChecker {
            String text;

            public PalindromeChecker(String text) {
                this.text = text;
            }

            public boolean isPalindrome() {
                String reversedText = new StringBuilder(text).reverse().toString();
                return text.equalsIgnoreCase(reversedText);
            }

            public void displayResult() {
                if (isPalindrome()) {
                    System.out.println("\"" + text + "\" is a palindrome.");
                } else {
                    System.out.println("\"" + text + "\" is not a palindrome.");
                }
            }
        }

        // Program to Model a Movie Ticket Booking System
        static class MovieTicket {
            String movieName;
            int seatNumber;
            double price;
            boolean isBooked;

            public MovieTicket(String movieName) {
                this.movieName = movieName;
                this.seatNumber = 0; // 0 indicates not booked
                this.price = 0.0;
                this.isBooked = false;
            }

            public void bookTicket(int seatNumber, double price) {
                if (!isBooked) {
                    this.seatNumber = seatNumber;
                    this.price = price;
                    this.isBooked = true;
                    System.out.println("Ticket booked successfully!");
                } else {
                    System.out.println("Ticket already booked.");
                }
            }

            public void displayTicketDetails() {
                if (isBooked) {
                    System.out.println("Movie Name: " + movieName);
                    System.out.println("Seat Number: " + seatNumber);
                    System.out.println("Price: $" + price);
                } else {
                    System.out.println("Ticket not booked yet.");
                }
            }
        }

        // Program to Simulate a Shopping Cart
        static class CartItem {
            String itemName;
            double price;
            int quantity;

            public CartItem(String itemName, double price, int quantity) {
                this.itemName = itemName;
                this.price = price;
                this.quantity = quantity;
            }

            public double getTotalItemCost() {
                return price * quantity;
            }

            @Override
            public String toString() {
                return "Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity;
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("--- Employee Details ---");
            Employee employee = new Employee("Alice", 101, 50000);
            employee.display();

            System.out.println("\n--- Circle Area ---");
            System.out.print("Enter the radius of the circle: ");
            int circleRadius = scanner.nextInt();
            Circle circle = new Circle(circleRadius);
            System.out.println("Area: " + circle.area());
            scanner.nextLine(); // Consume newline

            System.out.println("\n--- Book Details ---");
            System.out.print("Enter title: ");
            String bookTitle = scanner.nextLine();
            System.out.print("Enter author: ");
            String bookAuthor = scanner.nextLine();
            System.out.print("Enter price: ");
            int bookPrice = scanner.nextInt();
            Book book = new Book(bookTitle, bookAuthor, bookPrice);
            book.display();
            scanner.nextLine(); // Consume newline

            System.out.println("\n--- Item Details ---");
            System.out.print("Enter item code: ");
            int itemCode = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter item name: ");
            String itemName = scanner.nextLine();
            System.out.print("Enter price: ");
            int itemPrice = scanner.nextInt();
            Item item = new Item(itemCode, itemName, itemPrice);
            item.display();
            scanner.nextLine(); // Consume newline

            System.out.println("\n--- Mobile Phone Details ---");
            System.out.print("Enter brand: ");
            String mobileBrand = scanner.nextLine();
            System.out.print("Enter model: ");
            String mobileModel = scanner.nextLine();
            System.out.print("Enter price: ");
            int mobilePrice = scanner.nextInt();
            MobilePhone mobilePhone = new MobilePhone(mobileBrand, mobileModel, mobilePrice);
            mobilePhone.display();
            scanner.nextLine(); // Consume newline

            System.out.println("\n--- Student Report ---");
            System.out.print("Enter roll number: ");
            int studentRollNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter name: ");
            String studentName = scanner.nextLine();
            System.out.print("Enter marks: ");
            int studentMarks = scanner.nextInt();
            Student student = new Student(studentRollNumber, studentName, studentMarks);
            student.display();
            student.grade();
            scanner.nextLine(); // Consume newline

            System.out.println("\n--- ATM Simulation ---");
            System.out.print("Enter account number: ");
            int accountNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter account holder name: ");
            String accountHolder = scanner.nextLine();
            System.out.print("Enter initial balance: ");
            int initialBalance = scanner.nextInt();
            BankAccount bankAccount = new BankAccount(accountNumber, accountHolder, initialBalance);

            int atmChoice;
            do {
                System.out.println("\nATM Menu:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Display Balance");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                atmChoice = scanner.nextInt();

                switch (atmChoice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        int depositAmount = scanner.nextInt();
                        bankAccount.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        int withdrawAmount = scanner.nextInt();
                        bankAccount.withdraw(withdrawAmount);
                        break;
                    case 3:
                        bankAccount.displayBalance();
                        break;
                    case 4:
                        System.out.println("Exiting ATM...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (atmChoice != 4);
            scanner.nextLine(); // Consume newline

            System.out.println("\n--- Palindrome Checker ---");
            System.out.print("Enter a string to check for palindrome: ");
            String palindromeText = scanner.nextLine();
            PalindromeChecker palindromeChecker = new PalindromeChecker(palindromeText);
            palindromeChecker.displayResult();

            System.out.println("\n--- Movie Ticket Booking ---");
            System.out.print("Enter movie name: ");
            String movieName = scanner.nextLine();
            MovieTicket movieTicket = new MovieTicket(movieName);

            int ticketChoice;
            do {
                System.out.println("\nMovie Ticket Menu:");
                System.out.println("1. Book Ticket");
                System.out.println("2. Display Ticket Details");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                ticketChoice = scanner.nextInt();

                switch (ticketChoice) {
                    case 1:
                        if (!movieTicket.isBooked) {
                            System.out.print("Enter seat number: ");
                            int seatNumber = scanner.nextInt();
                            System.out.print("Enter price: ");
                            double price = scanner.nextDouble();
                            movieTicket.bookTicket(seatNumber, price);
                        } else {
                            System.out.println("Ticket already booked. Cannot book again.");
                        }
                        break;
                    case 2:
                        movieTicket.displayTicketDetails();
                        break;
                    case 3:
                        System.out.println("Exiting Ticket Booking...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (ticketChoice != 3);
            scanner.nextLine(); // Consume newline

            System.out.println("\n--- Shopping Cart ---");
            List<CartItem> cartItems = new ArrayList<>();

            int cartChoice;
            do {
                System.out.println("\nShopping Cart Menu:");
                System.out.println("1. Add Item");
                System.out.println("2. Remove Item");
                System.out.println("3. Display Total Cost");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                cartChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (cartChoice) {
                    case 1:
                        System.out.print("Enter item name: ");
                        String itemNameCart = scanner.nextLine();
                        System.out.print("Enter price: ");
                        double priceCart = scanner.nextDouble();
                        System.out.print("Enter quantity: ");
                        int quantityCart = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        cartItems.add(new CartItem(itemNameCart, priceCart, quantityCart));
                        System.out.println(quantityCart + " " + itemNameCart + "(s) added to cart.");
                        break;
                    case 2:
                        System.out.print("Enter item name to remove: ");
                        String removeItemName = scanner.nextLine();
                        cartItems.removeIf(item -> item.itemName.equals(removeItemName));
                        System.out.println(removeItemName + "(s) removed from cart.");
                        break;
                    case 3:
                        double totalCost = 0;
                        if (cartItems.isEmpty()) {
                            System.out.println("Cart is empty.");
                        } else {
                            System.out.println("Cart Items:");
                            for (CartItem itemCart : cartItems) {
                                System.out.println(itemCart);
                                totalCost += itemCart.getTotalItemCost();
                            }
                            System.out.println("Total Cost: $" + totalCost);
                        }
                        break;
                    case 4:
                        System.out.println("Exiting Shopping Cart...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (cartChoice != 4);

            scanner.close();
        }    }
}
