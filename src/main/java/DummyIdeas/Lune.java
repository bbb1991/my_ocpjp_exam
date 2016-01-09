package DummyIdeas;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// Приложение для проверки корректности номера карт
// По задумке сумма всех чисел должна делиться на 10 без остатка
// 1234 5678 9012 3456
// первая цифра категория (1 - аэрофлот, 4..5 - банки и др)
// с 1 по 6 код организаций
// с 7 по 15 номер владельца
// 16-й - контрольной номер
// Итак берем и суммируем все числа. Каждую нечетную умножаем на 2
// если после умножения получилось 10 или больше, складываем числа, пример
// 7 * 2 = 14. 1 + 4 = 5

public class Lune {

    private static BufferedReader reader = null;
    private static long number = 0; // номер карты
    private static final int CARD_NO_LENGTH = 16;	// стандартная длина, нестандартных карт не берем в счет

    public static void main (String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            number = Long.parseLong(reader.readLine());
            // Если длина символов не равно 16 бросаем исключение
            if (String.valueOf(number).length() != CARD_NO_LENGTH) {
                throw new IllegalArgumentException("Incorrect card number length!");
            }
            System.out.println(cardNoCheck() ? "Correct!" : "Not Correct!");
        } catch (IllegalArgumentException ex) {	// Если длина на 16 символов
            System.err.println(ex.getMessage());


        } finally {
            if (reader != null) {
                reader.close();
            }
        }


    }

    private static boolean cardNoCheck() {
        // разбиваем на массив символов
        char[] n = String.valueOf(number).toCharArray();
        int sum = 0;	// сумма чисел
        int currentNumber = 0;	//текущее число

        for (int i = 0; i < CARD_NO_LENGTH; i++) {
            currentNumber = 0;
            currentNumber = Character.digit(n[i], 10);

            // если нечетное умножаем на 2
            if (i % 2 != 0) {
                currentNumber *= 2;

                if (currentNumber > 9) { // если больше 9 то складывем числа
                    currentNumber = (currentNumber / 10) + (currentNumber % 10);
                }
            }

            sum += currentNumber; // суммируем
        }

        return (sum % 10) == 0; // итог
    }
}