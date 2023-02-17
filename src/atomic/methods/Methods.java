package atomic.methods;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Methods {
    public static AtomicInteger counter3 = new AtomicInteger(0);
    public static AtomicInteger counter4 = new AtomicInteger(0);
    public static AtomicInteger counter5 = new AtomicInteger(0);

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    public static boolean palindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public static boolean similar(String s) {
        for (int j = 0; j < s.length() - 1; j++) {
            if (s.charAt(j) != s.charAt(j + 1))
                return false;
        }
        return true;
    }

    public static boolean byHeight(String s) {
        for (int j = 0; j < s.length() - 1; j++) {
            if (s.charAt(j) > s.charAt(j + 1))
                return false;
        }
        return true;
    }

    public static void adder(int length) {
        if (length == 3) {
            counter3.getAndIncrement();
        } else if (length == 4) {
            counter4.getAndIncrement();
        } else {
            counter5.getAndIncrement();
        }

    }
}
