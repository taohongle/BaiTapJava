package BTVN_QLNV;

import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private String code;
    private double salaryRate;

    public Employee(int id, String name, int age, String department, String code, double salaryRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.code = code;
        this.salaryRate = salaryRate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public String getCode() {
        return code;
    }

    public double getSalaryRate() {
        return salaryRate;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Department: " + department +
                ", Code: " + code + ", Salary Rate: " + salaryRate);
    }
}

public class EmployeeManagement {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static int nextId = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void displayEmployees() {
        System.out.println("\nList of employees:");
        for (Employee employee : employees) {
            employee.displayInfo();
        }
    }

    public static void addEmployee() {
        System.out.println("\nAdding a new employee:");
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter employee department: ");
        String department = scanner.nextLine();
        System.out.print("Enter employee code: ");
        String code = scanner.nextLine();
        System.out.print("Enter employee salary rate: ");
        double salaryRate = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        Employee employee = new Employee(nextId++, name, age, department, code, salaryRate);
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    public static void removeEmployee() {
        System.out.print("\nEnter ID of employee to remove: ");
        int idToRemove = scanner.nextInt();
        boolean found = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == idToRemove) {
                employees.remove(i);
                System.out.println("Employee with ID " + idToRemove + " removed successfully.");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Employee with ID " + idToRemove + " not found. Please try again.");
            removeEmployee();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee(nextId++, "Employee " + (i + 1), 25 + i, "IT", "E" + (1 + i), 1000 + i * 20);
            employees.add(employee);
        }

        int choice = 0;
        while (choice != 4) {
            System.out.println("\nMenu:");
            System.out.println("1. List employee");
            System.out.println("2. Add employee");
            System.out.println("3. Remove employee");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    displayEmployees();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            if (choice != 4 && choice != 1) {
                System.out.println("\nUpdated list of employees:");
                for (Employee employee : employees) {
                    employee.displayInfo();
                }
            }
        }
    }
}
