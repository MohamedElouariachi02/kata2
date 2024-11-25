import java.util.ArrayList;
import java.util.List;

public class TsvDeserializer implements Deserializer {
    @Override
    public Title deserialize(String title) {
        String[] fields = title.split("\t");
        return new Title(fields[0], toTitleType(fields[1]), fields[2], toBoolean(fields[4]), toTitleGenre(fields[8]));
    }

    private List<Title.Genre> toTitleGenre(String field) {
        if (field.equals("\\N")) return null;
        ArrayList<Title.Genre> result = new ArrayList<>();
        String[] genres = field.split(",");
        for (String genre : genres) {
            result.add(Title.Genre.valueOf(normalize(genre)));
        }
        return result;
    }

    private String normalize(String genre) {
        return genre.replace("-", "");
    }

    private boolean toBoolean(String field) {
        return field.equals("1");
    }

    private Title.Type toTitleType(String field) {
        return Title.Type.valueOf(capitalize(field));
    }

    private String capitalize(String field) {
        if (field.equals("\\N")) return null;
        return field.toUpperCase().charAt(0) + field.toLowerCase().substring(1);
    }
}
