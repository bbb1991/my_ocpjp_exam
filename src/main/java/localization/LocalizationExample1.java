package localization;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Обьект locale можно создать следующими способами:
 * 1. конструтор 
 *  - Locale(String language, String country, String variant) - Locale("en", "US", "MAC")
 *  - Locale(String language, String country) - Locate("en", "US")
 *  - Locale(String language) - Locale("ru")
 * 2. метод getDefault() 
 *  - Locale.getDefault()
 * 3. константы
 *  - Locale.CHINA
 * 4. Builder
 *  - Locale locale = new Locale.Builder().setLanguage("ru").build()
 */

public class LocalizationExample1 {
    public static void main(String[] args) {
        Locale[] locales = new Locale[] {
                Locale.CHINA,
                Locale.FRANCE,
                Locale.GERMANY,
                Locale.ITALY,
                new Locale.Builder().setLanguage("ru").build(),
        };

        for (Locale locale : locales) {
            System.out.println("Locale: " + locale.getDisplayCountry() + ", " + locale.getDisplayName());
            System.out.println(" - " + DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locale).format(new Date()));
            System.out.println(" - " + NumberFormat.getCurrencyInstance(locale).format(123.45));
        }


    }
}
