
package Controller;

import Model.UserModel;
import View.UserView;

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
            userView.displayMessage("Username does not exist. What would you like to do?");

            int choice = userView.Menu(); 

            switch (choice) {
                case 1:
                    userView.displayMessage("Creating a new account...");
                    String newUsername = userView.inputUsername(); 
                    String newPassword = userView.inputPassword(); 
                    createUserAccount(); 
                    userView.displayMessage("Account created successfully.");
                    return;
                case 2:
                    break;
                default:
                    userView.displayMessage("Invalid choice.");
                    break;
            }
        } else {
            while (true) {
                password = userView.inputPassword();

                if (userModel.validateUser(username, password)) {
                    userView.displayMessage("Login successful.");
                    return; 
                } else {
                    userView.displayMessage("Password incorrect. Please try again.");
                }
            }
        }
    }
}

}
