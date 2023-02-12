package atomic;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static AtomicInteger counter3 = new AtomicInteger(0);
    static AtomicInteger counter4 = new AtomicInteger(0);
    static AtomicInteger counter5 = new AtomicInteger(0);
    static short SIMILAR = 1;
    static short BY_HEIGHT = 2;
    public static final int masSize = 100_000;
    static final int stringSizePlus = 3;
    static AtomicInteger stop = new AtomicInteger(0);
    ;
    static final String symbol = "abc";

    static String[] texts = new String[masSize];

    public static void main(String[] args) {

        Random random = new Random();

        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText(symbol, stringSizePlus + random.nextInt(3));
        }
        Thread palindrom = new Palindrom();
        palindrom.start();
        Thread similar = new Similar();
        similar.start();
        Thread nickByHeight = new NickByHeight();
        nickByHeight.start();
        while (stop.get() != 3) ;
        System.out.println("Красивых слов с длиной 3: " + counter3 + " шт.");
        System.out.println("Красивых слов с длиной 4: " + counter4 + " шт.");
        System.out.println("Красивых слов с длиной 5: " + counter5 + " шт.");
    }

    static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    static short byHeight(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(0)) {
                for (int j = 0; j < s.length() - 1; j++) {
                    if (s.charAt(j) > s.charAt(j + 1))
                        return 0;
                }

                return BY_HEIGHT;
            }

        }
        return SIMILAR;
    }

    static void adder(int length) {
        if (length == 3) {
            counter3.set(counter3.get() + 1);
        } else if (length == 4) {
            counter4.set(counter4.get() + 1);
        } else {
            counter5.set(counter5.get() + 1);
        }

    }
}