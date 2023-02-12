package atomic;

import static atomic.Main.*;

public class Similar extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < texts.length; i++) {
            if (byHeight(texts[i]) == SIMILAR) {
                adder(texts[i].length());
            }
        }
        stop.set(stop.get() + 1);
    }
}
