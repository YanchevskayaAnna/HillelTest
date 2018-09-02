import java.awt.*;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> result = Parsing.Parse(Parsing.LowerCase(FilesApp.readFile()));
        FilesApp.writeFile(result.toString());
        System.out.println(result.toString());
    }
}
