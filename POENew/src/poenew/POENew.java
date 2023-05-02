/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poenew;
import java.util.Scanner;
/**
 *
 * @author Ethan
 */
public class POENew {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Login login = new Login();
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("Welcome to the Login System. Enter your choice:");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");

        int choice = scanner.nextInt();

        if (choice == 1) {
                System.out.println("Enter your first name:");
                String firstName = scanner.next();

                System.out.println("Enter your last name:");
                String lastName = scanner.next();

                System.out.println("Enter your username:");
                String username = scanner.next();

                System.out.println("Enter your password:");
                String password = scanner.next();

                login.registerUser(firstName, lastName, username, password);
            } else if (choice == 2) {
                System.out.println("Enter your username:");
                String username = scanner.next();

                System.out.println("Enter your password:");
                String password = scanner.next();

                if (login.loginUser(username, password)) {
                    System.out.println("Welcome user it is great to see you" );
                } else {
                    System.out.println("Login failed. Please check your username and password.");
                }
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }
}
