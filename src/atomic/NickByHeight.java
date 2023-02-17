package atomic;

import static atomic.Main.*;
import static atomic.methods.Methods.adder;
import static atomic.methods.Methods.byHeight;

public class NickByHeight extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < texts.length; i++) {
            if (byHeight(texts[i])) {
                adder(texts[i].length());
            }
        }
        stop.set(stop.get() + 1);
    }
}
