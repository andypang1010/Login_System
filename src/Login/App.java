package Login;

import java.util.HashSet;
import java.util.Scanner;

public class App {

    static HashSet<User> db;
    static Scanner inputScanner;

    public static void main(String[] args) throws Exception {
        db= new HashSet<>();
        inputScanner= new Scanner(System.in);
        System.out.println("LOGIN SYSTEM");
        System.out.println("-----------------------------");

        System.out.println("1. Log in \n2. Sign up \n3. Quit");
        System.out.println();

        boolean functionNumValid= false;
        int functionNum= 0;

        while (!functionNumValid) {
            System.out.print("Please enter the corresponding number: ");
            functionNum= inputScanner.nextInt();

            if (functionNum < 4 && functionNum > 0) {
                functionNumValid= true;
            } else {
                System.out.println("Input invalid. Please try again.");
                System.out.println();
            }
        }

        switch (functionNum) {
        case 1:
            login();
        case 2:
            signup();
        case 3:
            inputScanner.close();
            quit();
        }

    }

    public static void login() {
        boolean inputValid= false;
        String usernameInput= "";
        String passwordInput= "";
        User user= null;

        while (!inputValid) {
            System.out.print("Please enter your username: ");
            usernameInput= inputScanner.nextLine();
            System.out.print("Please enter your password: ");
            passwordInput= inputScanner.nextLine();

            user= new User(usernameInput, passwordInput);

            if (!db.contains(user)) {
                System.out.println("Your username or password is incorrect. Please try again.");
                System.out.println();
            } else {
                inputValid= true;
            }
        }
        System.out.println("Welcome, " + user.id());
    }

    public static void signup() {
        boolean inputValid= false;
        String usernameInput= "";
        String passwordInput= "";

        while (!inputValid) {
            System.out.print("Please enter a new username: ");
            usernameInput= inputScanner.nextLine();

            boolean duplicateFound= true;
            for (User u : db) {
                if (u.id().equals(usernameInput)) {
                    System.out.println("Username already exists. Please try again.");
                    duplicateFound= true;
                    break;
                }
            }
            if (!duplicateFound) {
                inputValid= true;
            }
        }

        inputValid= false;
        while (!inputValid) {
            System.out.print("Please enter a new password: ");
            passwordInput= inputScanner.nextLine();

            if (passwordInput.length() < 8) {
                System.out.println("Password is too short. Please try again.");
            } else {
                inputValid= true;
            }
        }

        User newUser= new User(usernameInput, passwordInput);
        db.add(newUser);
    }

    public static void quit() {
        System.out.println("Thank you for using LOGIN SYSTEM");
        System.out.println("We will be logging you out shortly...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Process interrupted by: " + e.getMessage());
            System.exit(-1);
        }

        System.exit(0);
    }
}
