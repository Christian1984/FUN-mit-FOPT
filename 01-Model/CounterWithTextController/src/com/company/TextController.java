package com.company;

import java.io.IOException;

/**
 * Created by chris on 27.06.16.
 */
public class TextController extends Thread {
    private Counter c;

    public TextController(Counter c) {
        this.c = c;
        start();
    }

    public void run() {
        while (true) {
            try {
                char key = (char) System.in.read();
                //System.out.println("Controller read key: " + key  + " | " + Thread.currentThread());

                if (key == 'i') {
                    c.inc();
                }
                else if (key == 'r') {
                    c.reset();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
