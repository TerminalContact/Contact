import util.Contacts;
import util.FileHandler;
import util.Input;

import java.io.File;
import java.util.HashMap;

import java.io.IOException;
import java.util.ArrayList;

public class ContactManger {
    public static void main(String[] args) throws IOException {
        FileHandler contactPath = new FileHandler("contactData", "contacts.txt");
        try {
            contactPath.setFilePath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Print Menu will initialize the application.
        printMenu(contactPath);


    }

    // addContact will pass the user inputs into variable Strings name, and number.
    // It will then print the Strings to the file contacts.txt.
    public static void addContact(Input input, FileHandler contactPath) throws IOException {
        System.out.println("Please enter a name");
        String name = input.getString();
        Contacts contacts = new Contacts(name);
        System.out.println("Please enter a number");
        String number = input.getString();

        if (isNumber(number)) {
            if (number.length() != 7 && number.length() != 10) {
                System.out.println("That is not a valid input.");
                addContact(input, contactPath);
            }
            else {
                contacts.addNumber(number);
                String finalContact = contacts.getName() + "," + contacts.getNumber();
                contactPath.writeFileInfo(finalContact);
                System.out.println("Thank you!");
                System.out.println("");

                //After the user inputs the name, and number the program will run again using printMenu();
                printMenu(contactPath);
            }
        }
        else {
                System.out.println("That is not a valid input.");
                addContact(input, contactPath);
            }

    }

    public static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void viewContacts(FileHandler contactPath) throws IOException {
        contactPath.readFileInfo();
        System.out.println("");
        printMenu(contactPath);
    }

    public static void searchByName(FileHandler contactPath) throws IOException {
        System.out.println("Please enter a name");
        Input input = new Input();
        String name = input.getString();
        Contacts contacts = new Contacts(name);
        contacts.searchContactInfo(name, contactPath);
        System.out.println("");
        printMenu(contactPath);
    }

    public static void deleteExisting(FileHandler contactPath) throws IOException {
        System.out.println("Please enter a name");
        Input input = new Input();
        String name = input.getString();
        System.out.println("Are you sure you want to delete this contact?");
        if (input.yesNo()) {
            contactPath.replaceInfo(name);
            System.out.println("");
            printMenu(contactPath);
        } else {
            System.out.println("");
            printMenu(contactPath);
        }
    }

    public static void printMenu(FileHandler contactPath) throws IOException {
        //Starts the application, and will continue to run at the end of each switch case until the user exits by pressing "5".
        System.out.println("1. View Contacts.");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit Contact");
        System.out.println("Enter and option (1,2,3,4,5)");
        Menu(contactPath);

    }

    public static void exitContact() {
        System.exit(0);
    }

    //Handles the functions that the user will enter and starts the given function based on the users entry.
    public static void Menu(FileHandler contactPath) throws IOException {
        Input input = new Input();
        switch (input.getInt()) {
            case 1:
                viewContacts(contactPath);
                break;

            case 2:
                addContact(input, contactPath);
                break;

            case 3:
                searchByName(contactPath);
                break;

            case 4:
                deleteExisting(contactPath);
                break;

            case 5:
                exitContact();
                break;
        }

    }
}
