package atomic;

import static atomic.Main.*;

public class NickByHeight extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < texts.length; i++) {
            if (byHeight(texts[i]) == BY_HEIGHT) {
                adder(texts[i].length());
            }
        }
        stop.set(stop.get() + 1);
    }
}
