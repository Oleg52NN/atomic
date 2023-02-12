package atomic;

import static atomic.Main.*;

public class Palindrom extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < texts.length; i++) {
            if (byHeight(texts[i]) != SIMILAR) {
                if (reverse(texts[i]).equals(texts[i])) {
                    adder(texts[i].length());
                }
            }
        }
        stop.set(stop.get() + 1);
    }
}
