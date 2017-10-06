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
        System.out.printf("%-11s %-1s %-12s %-4s\n", "Name", "|", "Phone number","|");

        for(int i=0; i<28;i++){
            System.out.print("-");
        }

        System.out.println("");

        for (String contactName:retrievedFileInfo){
            String[] part=contactName.split(",");
            //Created private string and set the value equal to the array at index 0, which has the value of the name.
            this.searchedName=part[0];
            //In this if statement returns a boolean value if our searched name starts with the input string provided by the user.
            if(this.searchedName.toLowerCase().startsWith(name.toLowerCase())){
                //Saves that current value of the name and phone number to the array at the given indexes.
                if(part[1].length()==7){
//                    this.searchedNumber=part[1];
                    String number=part[1].substring(0,3)+"-"+ part[1].substring(3);
                    this.searchedName=part[0].substring(0,1).toUpperCase()+part[0].substring(1);
                    this.searchedNumber=number;
                    System.out.printf("%-11s %-1s %-12s %-4s\n", this.searchedName, "|", this.searchedNumber,"|");
                }
                else if(part[1].length()==10){
                    this.searchedNumber=part[1];
                    String number=part[1].substring(0,3)+"-"+part[1].substring(3,6)+"-"+part[1].substring(6);
                    this.searchedName=part[0].substring(0,1).toUpperCase()+part[0].substring(1);
                    this.searchedNumber=number;
                    System.out.printf("%-11s %-1s %-12s %-4s\n", this.searchedName, "|", this.searchedNumber,"|");

                }
                else{
                    this.searchedNumber=part[1];
                }
                break;
            }
        }
        //Prints out the phone number for the user of the given name searched.
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
