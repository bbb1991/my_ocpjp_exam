package DummyIdeas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JunitExample {
    public static String vowel2Index(String s) {
        //code me

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            if (isVowel(sb.charAt(i))) {
                sb.append(sb.su)
            }
        }

        return sb.toString();
    }

    private static boolean isVowel(char c) {
        char vowels[] = {'a', 'e', 'i', 'o', 'u'};
        for (char vowel : vowels) {
            if (c == vowel) {
                return true;
            }
        }
        return false;
    }

    public static String replaceCharAt(String s, int pos, String c) {
        return s.substring(0, pos) + c + s.substring(pos + 1);
    }

    @Test
    public void test1() {
        assertEquals("th3s 6s my str15ng", JunitExample.vowel2Index("this is my string"));
    }

    @Test public void test2() {
        assertEquals("C2d4w6rs 10s th15 b18st s23t25 27n th32 w35rld", JunitExample.vowel2Index("Codewars is the best site in the world"));
    }
    @Test public void test3() {
        assertEquals("T2m4rr7w 10s g1415ng t20 b23 r2627n29ng", JunitExample.vowel2Index("Tomorrow is going to be raining"));
    }
    @Test public void test4() {
        assertEquals("", JunitExample.vowel2Index(""));
    }


}