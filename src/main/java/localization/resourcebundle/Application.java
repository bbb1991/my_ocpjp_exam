package localization.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class Application {
    public static void main(String[] args) {
        Locale ru = new Locale.Builder().setLanguage("ru").build();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("label", ru);
        System.out.println(resourceBundle.getString("title"));
    }
}
