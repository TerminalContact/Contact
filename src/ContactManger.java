import util.FileHandler;
import util.Input;

import java.io.File;
import java.io.IOException;

public class ContactManger {
    public static void main(String[] args) throws IOException {
        FileHandler contactInfo=new FileHandler("contactData","contacts.txt");
        try {
            contactInfo.setFilePath();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("1. View Contacts.");
        System.out.println("2. Add a new contact");
        System.out.println("3. Search a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit Contact");
        System.out.println("Enter and option (1,2,3,4,5)");


    }


}
