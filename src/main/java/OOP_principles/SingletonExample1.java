package OOP_principles;

import java.io.FileInputStream;
import java.util.Properties;

public class SingletonExample1 {

    public static void main(String[] args) {
        Settings settings = Settings.getInstance();
        System.out.println(settings.getDifficult());
    }
}

class Settings {

    private Difficult difficult;

    private Settings(Difficult difficult) {
        this.difficult = difficult;
    }

    private static Settings instance = null;

    public static Settings getInstance() {
        if (instance == null) {
            try {
                Properties properties = new Properties();
                FileInputStream fileInputStream =
                        new FileInputStream("/Users/bbb1991/IdeaProjects/OCPJP/src/main/java/OOP_principles/SingletonExample1.properties");
                properties.load(fileInputStream);

                instance = new Settings(Difficult.valueOf(properties.getProperty("Difficult")));
            } catch (Exception e) {
                instance = new Settings(Difficult.MEDIUM);
            }
        }
        return instance;
    }

    public Difficult getDifficult() {
        return difficult;
    }
}

enum Difficult {
    EASY,
    MEDIUM,
    HARD
}