import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        List<String> pathFile = Arrays.asList(
                "C://Games3",
                "C://Games3/src",
                "C://Games3/res",
                "C://Games3/savegames",
                "C://Games3/temp",
                "C://Games3/src/main",
                "C://Games3/src/test",
                "C://Games3/res/drawables",
                "C://Games3/res/vectors",
                "C://Games3/res/icons"
        );

        for (String s : pathFile) {
            File dir = new File(s);
            dir.mkdir();
            if (dir.isDirectory()) {
                sb.append("Каталог " + s + " создан\n");
            } else {
                sb.append("Каталог " + s + " не создан\n");
            }
        }
        
        createNewFile("C://Games3/src/main", "Main.java");
        createNewFile("C://Games3/src/main", "Utils.java");
        createNewFile("C://Games3/temp", "temp.txt");

        try (FileWriter writer = new FileWriter("C://Games3/temp/temp.txt", false)) {
            writer.write(sb.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void createNewFile(String path, String name) {
        File file = new File(path, name);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
