package com.company;

/**
 * Created by chris on 27.06.16.
 */
public class Counter {
    private int val = 0;

    public synchronized void inc() {
        val++;
        fireModelChanged();
    }

    public synchronized void reset() {
        val = 0;
        fireModelChanged();
    }

    private void fireModelChanged() {
        new Thread() {
            public void run() {
                String s = "Value changed: " + val + " | " + Thread.currentThread();
                System.out.println(s);
            }
        }.start();
    }
}
