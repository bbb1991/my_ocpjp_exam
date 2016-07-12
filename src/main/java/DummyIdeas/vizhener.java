package DummyIdeas;

public class vizhener {
    private int smesh = (int)'a';//смещение алфавита относительно таблицы юникодов
    public String encrypt(String text, String keyWord)
    {
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < text.length();i++)
        {
            int num = ((text.charAt(i) + keyWord.charAt(i % keyWord.length()) - 2 * smesh) % 26);
            //в num лежит номер буквы в алфавите
            char c = (char)(num + smesh);//получаем нужный символ
            ans.append(c);
        }
        return ans.toString();
    }
    public String decrypt(String shifr, String keyWord)
    {
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < shifr.length();i++)
        {
            int num = ((shifr.charAt(i)  - keyWord.charAt(i % keyWord.length()) + 26) % 26);
            //обратные преобразования с номером буквы в алфавите
            char c = (char)(num + smesh);
            ans.append(c);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println((int )'я');
    }
}