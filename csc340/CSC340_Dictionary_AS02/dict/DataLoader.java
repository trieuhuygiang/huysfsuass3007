import java.util.Arrays;

public class DataLoader {
    public static Dictionary load() {
        Dictionary dict = new Dictionary();
        dict.loadAll(Arrays.asList(DataSource.values()));
        return dict;
    }
}
