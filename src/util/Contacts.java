package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Contacts {
    private String name;
    private String number;
    private String searchedName;
    private String searchedNumber;

    public Contacts (String name){
        this.name= name;
    }
    public void addNumber(String number){
        this.number= number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

//    public String searchContactInfo() throws IOException {
//        List<String> retrievedFileInfo = Files.readAllLines(Paths.get(getDirectory(), getFilename()));
//        for (String info : retrievedFileInfo) {
//            String[] part = info.split(",");
//            return part[0];
//        }

//        return "";
//
//    }

    public void searchContactInfo(String name, FileHandler filePath) throws IOException {
        List<String> retrievedFileInfo = Files.readAllLines(Paths.get(filePath.getDirectory(), filePath.getFilename()));
        for (String contactName:retrievedFileInfo){
            String[] part=contactName.split(",");
            //Created private string and set the value equal to the array at index 0, which has the value of the name.
            this.searchedName=part[0];
            System.out.println("The length of the number is:"+part[1].length());
            //In this if statement returns a boolean value if our searched name starts with the input string provided by the user.
            if(this.searchedName.toLowerCase().startsWith(name.toLowerCase())){
                //Saves that current value of the name and phone number to the array at the given indexes.
                if(part[1].length()==7){
//                    this.searchedNumber=part[1];
                    String number=part[1].substring(0,3)+"-"+ part[1].substring(3);
                    this.searchedNumber=number;
                }
                else if(part[1].length()==10){
                    this.searchedNumber=part[1];
                    String number=part[1].substring(0,3)+"-"+part[1].substring(3,6)+"-"+part[1].substring(6);
                    System.out.println(name);
                    this.searchedNumber=number;
                }
                else{
                    this.searchedNumber=part[1];
                }
                break;
            }
        }
        //Prints out the phone number for the user of the given name searched.
        System.out.println(this.searchedName+": "+this.searchedNumber);
        System.out.println("");
    }
//    public void deleteContact(String name, FileHandler filePath) throws IOException {
//        List<String> retrievedFileInfo = Files.readAllLines(Paths.get(filePath.getDirectory(), filePath.getFilename()));
//        for (String contactName:retrievedFileInfo){
//            String[] part=contactName.split(",");
//            //Created private string and set the value equal to the array at index 0, which has the value of the name.
//            this.searchedName=part[0];
//            this.searchedNumber=part[1];
//
//            //In this if statement returns a boolean value if our searched name starts with the input string provided by the user.
//            if(this.searchedName.toLowerCase().startsWith(name.toLowerCase())){
//                //Saves that current value of the name and phone number to the array at the given indexes.
//                this.searchedName.replaceAll(part[0],"");
//                this.searchedNumber.(part[1],"");
//                break;
//            }
//        }
        //Prints out the phone number for the user of the given name searched.
//        System.out.println("Contact has been deleted");
//        System.out.println("");
//    }
}
