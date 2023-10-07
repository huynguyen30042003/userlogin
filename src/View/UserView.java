package View;

import java.util.Scanner;

public class UserView {
    private final Scanner scanner;

    public UserView() {
        scanner = new Scanner(System.in);
    }

    public int Menu() {
        System.out.println("1. Create a new account.");
        System.out.println("2. Login system.");
        System.out.println("3. Exit.");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public String inputUsername() {
        System.out.print("Enter username: ");
        return scanner.next();
    }

    public String inputPassword() {
        System.out.print("Enter password: ");
        return scanner.next();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}

