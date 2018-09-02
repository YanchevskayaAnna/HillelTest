import java.util.*;

public class Parsing {
    public static List<String> LowerCase(List<String> lines){
        List<String> result = new ArrayList<>();
        for (String line: lines) {
            result.add(line.toLowerCase());
        }
        return result;
    }

    public static Set<String> Parse(List<String> lines) {

        Set<String> result = new HashSet<>();
        for (String line:lines) {
            List<String> words = Arrays.asList(line.split("[\\ |\\.|\\,|\\/|\\-|\\;|\\:|\\!]+"));
            result.addAll(words);
        }
        if (result.contains("")) {result.remove("");}
        return result;

    }
}
