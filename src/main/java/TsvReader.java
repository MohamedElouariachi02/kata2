import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TsvReader implements Reader {
    private final File file;

    public TsvReader(File file) {
        this.file = file;
    }

    @Override
    public List<Title> read() {
        ArrayList<Title> titles = new ArrayList<>();
        TsvDeserializer deserializer = new TsvDeserializer();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            readHeader(reader);
            while (true)
            {
                String line = reader.readLine();
                if (line == null) break;
                Title title = deserializer.deserialize(line);
                titles.add(title);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return titles;
    }

    private static String readHeader(BufferedReader reader) throws IOException {
        return reader.readLine();
    }
}
