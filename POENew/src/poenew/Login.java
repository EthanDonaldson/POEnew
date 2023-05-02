/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poenew;

/**
 *
 * @author Ethan
 */
public class Login {
    private User[] users;

    public Login() {
        this.users = new User[0];
    }

    public void registerUser(String firstName, String lastName, String username, String password) {
        if (!checkUsername(username)) {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
            return;
        }
        if (!checkPasswordComplexity(password)) {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character");
            return;
        }
        User user = new User(firstName, lastName, username, password);
        User[] newUsers = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            newUsers[i] = this.users[i];
        }
        newUsers[this.users.length] = user;
        this.users = newUsers;
        System.out.println("Username and password is successfully captured");
    }

    public boolean loginUser(String username, String password) {
        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i].getUsername().equals(username) && this.users[i].getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkUsername(String username) {
        if (username.length() > 5) {
            return false;
        }
        boolean hasUnderscore = false;
        for (int i = 0; i < username.length(); i++) {
            if (username.charAt(i) == '_') {
                hasUnderscore = true;
                break;
            }
        }
        return hasUnderscore;
    }
    
    private boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasCapitalLetter = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasCapitalLetter = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }
        return hasCapitalLetter && hasNumber && hasSpecialChar;
    }

}
