/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UserModel;
import View.UserView;

/**
 *
 * @author sonhu
 */
public class UserController {
    private UserModel userModel;
    private UserView userView;

    public UserController() {
        userModel = new UserModel();
        userView = new UserView();
    }

    public void run() {
        while (true) {
            int choice = userView.Menu();
            switch (choice) {
                case 1:
                    createUserAccount();
                    break;
                case 2:
                    loginSystem();
                    break;
                case 3:
                userView.displayMessage("Exiting the program.");
                System.exit(0); // Đóng chương trình
                break;
            default:
                userView.displayMessage("Invalid choice.");
                break;
            }
        }
    }

    private void createUserAccount() {
        String username = userView.inputUsername();
        String password = userView.inputPassword();
        if (userModel.addUser(username, password)) {
            userView.displayMessage("Account created successfully.");
        } else {
            userView.displayMessage("Username already exists.");
        }
    }

    private void loginSystem() {
    while (true) {
        String username = userView.inputUsername();
        String password;

        if (!userModel.isUsernameExist(username)) {
            // Username does not exist
            userView.displayMessage("Username does not exist. What would you like to do?");

            int choice = userView.Menu(); // Get the user's choice

            switch (choice) {
                case 1:
                    // Create a new account
                    userView.displayMessage("Creating a new account...");
                    String newUsername = userView.inputUsername(); // Prompt for a new username
                    String newPassword = userView.inputPassword(); // Prompt for a password
                    createUserAccount(); // Gọi phiên bản không tham số của phương thức
                    userView.displayMessage("Account created successfully.");
                    return; // Return to the main menu after creating an account
                case 2:
                    // Try again (continue the loop)
                    break;
                default:
                    userView.displayMessage("Invalid choice.");
                    break;
            }
        } else {
            // Username exists, proceed with password validation
            while (true) {
                password = userView.inputPassword();

                if (userModel.validateUser(username, password)) {
                    userView.displayMessage("Login successful.");
                    return; // Exit the method on successful login
                } else {
                    userView.displayMessage("Password incorrect. Please try again.");
                }
            }
        }
    }
}

}
