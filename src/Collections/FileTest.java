package Collections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileTest {

    public static void main(String[] args) throws IOException{

        String currentDir = System.getProperty("user.dir");

        Files.list(Paths.get(currentDir)).forEach(System.out::println);
    }
}
