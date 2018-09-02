import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FilesApp {
    public static final String READFILE = "task1/src/main/resources/input.txt";
    public static final String WRITEFILE = "task1/src/main/resources/output.txt";

    public static List<String> readFileBuffer() {

        List<String> result = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(READFILE))) {
            String line;
            while ((line = bf.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;

    }

    public static List<String> readFile() {

        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Paths.get(READFILE), Charset.defaultCharset());
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return lines;
    }


    public static void writeFile(String maxSequence) {
        try (FileWriter writer = new FileWriter(WRITEFILE, false)) {
            writer.write(maxSequence);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
