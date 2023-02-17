package atomic;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static atomic.methods.Methods.*;

public class Main {


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
        Thread palindrom = new Palindrome();
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


}