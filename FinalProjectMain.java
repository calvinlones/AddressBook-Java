/*
Calvin Lones
Final project CS 2336
Address Book
 */
package finalprojectmain;
import java.io.*;
import java.util.Scanner;
import java.util.*;

public class FinalProjectMain {
    public static void main(String[] args) throws IOException {
        Scanner stdin = new Scanner(System.in);
        //new AddressBook object
        AddressBook neighbors = new AddressBook();
        
        menu();
        int choice = stdin.nextInt();
        boolean continueInput = true;
        while (choice!=5){
            if (choice == 1)
            {
                if (neighbors.numContacts() < 10)
                {//get all information for contact
                    do {
                        try {
                            System.out.println("Enter your neighbor's name: ");
                            String name = stdin.next();
                            
                            System.out.println("Enter their age: ");
                            int age = stdin.nextInt();
                            
                            System.out.println("Enter their 9-digit phone number: ");
                            int number = stdin.nextInt();
                            
                            System.out.println("Enter the birthday, month first(1-12), then day(1-31): ");
                            int mon = stdin.nextInt();
                            int day = stdin.nextInt();
                            // use all this information to create an instance of addressbook
                            neighbors.addContact(new Contact(name, age, number, mon, day));
                            continueInput = false;
                            }
                        catch (InputMismatchException ex) {
                            System.out.println("Try again. (" + "Incorrect input: an integer is required)");
                            stdin.nextLine(); // discard input 
                        }
                    } while (continueInput);
                }
                else
                    System.out.println("Sorry, cannot add anyone, your book is full.");
            
                }
            else if (choice == 2)
            {
                System.out.println("What is the name of the contact that you want to delete?");
                String name = stdin.next();
                neighbors.deleteContact(name);
            }
            else if (choice == 3)
            {
                System.out.println("You have " + neighbors.numContacts() + " contacts.");
            }
            else if (choice == 4)
            {
                neighbors.printContacts();
            }
            else if (choice != 5)
            {
                System.out.println("Sorry, that was an invalid menu choice, try again.");
            }
            menu();
            choice = stdin.nextInt();
        }
    }
    
    public static void menu()
    {
        System.out.println("1. Add a new contact to your address book.");
        System.out.println("2. Delete a contact from your address book.");
        System.out.println("3. Print out the number of contacts you have.");
        System.out.println("4. Print out information of all your contacts.");
        System.out.println("5. Quit.");
        System.out.println("Enter your menu choice: ");
        
    }
    
}
