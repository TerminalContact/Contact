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
        newFile.writeFileInfo();
        newFile.readFileInfo();
    }

}
