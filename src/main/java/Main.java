import java.io.*;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TsvReader reader = new TsvReader(new File("C:\\Users\\Magickio\\Downloads\\title.basics.tsv"));
        List<Title> titles = reader.read();
        HashMap<Title.Type, Integer> histograma = new HashMap<>();
        for (Title title : titles) {
            histograma.put(title.type(), histograma.getOrDefault(title.type(), 0) + 1);
        }
        for (Title.Type type : histograma.keySet()) {
            System.out.println(type + " " + histograma.get(type));
        }
    }
}
