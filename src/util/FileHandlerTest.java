package util;

import java.io.File;
import java.io.IOException;

public class FileHandlerTest {
    public static void main(String[] args) throws IOException {
        FileHandler newFile=new FileHandler("data","info.txt");
        try {
            newFile.setFilePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Please enter an item to add to the list.");
        Input input=new Input();
        newFile.writeFileInfo("String");
        newFile.readFileInfo();
    }

}
