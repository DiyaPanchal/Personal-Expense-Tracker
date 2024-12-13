import java.io.*;
import java.util.*;

public class PersonalExpenseTracker {
    private static final String FILENAME = "expenses.csv";
    private static List<Expense> expenses = new ArrayList<>();
    public static void main(String[] args) {
        
    }
    private static void addExpense() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter description: ");
        String description = sc.nextLine();

        expenses.add(new Expense(date, category, amount, description));
        System.out.println("Expense added.");
    }
    
    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("\nRecorded Expenses:");
            for (int i = 0; i < expenses.size(); i++) {
                System.out.println((i + 1) + ". " + expenses.get(i));
            }
        }
    }
}

class Expense {
    private String date;
    private String category;
    private double amount;
    private String description;

    public Expense(String date, String category, double amount, String description) {
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public String toCsv() {
        return date + "," + category + "," + amount + "," + description;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Category: " + category + ", Amount: " + amount + ", Description: " + description;
    }
}