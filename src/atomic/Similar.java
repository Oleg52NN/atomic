package atomic;

import static atomic.Main.*;
import static atomic.methods.Methods.adder;
import static atomic.methods.Methods.similar;

public class Similar extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < texts.length; i++) {
            if (similar(texts[i])) {
                adder(texts[i].length());
            }
        }
        stop.set(stop.get() + 1);
    }
}
