package atomic;

import static atomic.Main.*;
import static atomic.methods.Methods.*;

public class Palindrome extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < texts.length; i++) {
            if (palindrome(texts[i]) && !similar(texts[i])) {
                adder(texts[i].length());
            }
        }
        stop.set(stop.get() + 1);
    }
}
