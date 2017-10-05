package util;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileHandler {

    private String directory;
    private String filename;
    private String searchedNumber;
    private String searchedName;

    public FileHandler(String directory, String filename){
        this.directory=directory;
        this.filename=filename;
    }
    public String getDirectory(){
        return this.directory;
    }
    public String getFilename(){
        return this.filename;
    }

    //This method will check and see if there is specified directory and filename, if not it will create them.

    public void setFilePath() throws IOException {
        Path dataDirectory = Paths.get(getDirectory());
        Path dataFilename = Paths.get(getDirectory(), getFilename());

        if (!Files.exists(dataDirectory)) {
            Files.createDirectory(dataDirectory);
        }
        if (!Files.exists(dataFilename)) {
            Files.createFile(dataFilename);
        }
    }
    //Method will write items to the file specified.

    //Items are already set, will add ability to change based on user input later.

        public void writeFileInfo(String input) throws IOException {
        //Add append parameter in order to build the contacts list, at this point it will erase the previous entry with each new run.
            List<String> fileInfo= new ArrayList<>();
            fileInfo.add(input);
            Files.write(Paths.get(getDirectory(),getFilename()),fileInfo, StandardOpenOption.APPEND);
        }

        public void replaceInfo(String name) throws IOException {
            List<String> oldList=Files.readAllLines(Paths.get(getDirectory(),getFilename()));
            List<String> newList= new ArrayList<>();

        for(String oldListItem: oldList) {
            if(oldListItem.toLowerCase().startsWith(name.toLowerCase())) {
                continue;
            }
            newList.add(oldListItem);
        }
            Files.write(Paths.get(getDirectory(),getFilename()),newList);

        }
        //Retrieves the items on the text file and writes them to the terminal.
        public void readFileInfo() throws IOException{
        List<String> retrievedFileInfo=Files.readAllLines(Paths.get(getDirectory(),getFilename()));
            for(String info:retrievedFileInfo) {
                String[] part = info.split(",");
                this.searchedName=part[0];
            if(part[1].length()==7){
                String number=part[1].substring(0,3)+"-"+ part[1].substring(3);
                this.searchedNumber=number;
            }
            else if(part[1].length()==10){
                this.searchedNumber=part[1];
                String number=part[1].substring(0,3)+"-"+part[1].substring(3,6)+"-"+part[1].substring(6);
                this.searchedNumber=number;
            }
                System.out.println(this.searchedName+": "+this.searchedNumber);
                System.out.println("");
            }


        }


}
