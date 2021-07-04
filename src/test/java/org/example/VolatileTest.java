package org.example;

import org.junit.Test;

/**
 * @author lvle
 * @date 2021-02-17 15:56
 *
 */
public class VolatileTest {
    public volatile int inc = 0;

    public synchronized void inc(){
        inc++;
    }

    public static void main(String[] args) {
      final  VolatileTest vol = new VolatileTest();

      for (int i=0;i<10;i++){
          new Thread(){
              @Override
              public void run() {
                  for (int j=0;j<1000;j++){
                    vol.inc();
                  }
              }
          }.start();
      }
      while (Thread.activeCount()>1){
             Thread.yield();
          System.out.println(vol.inc);
      }
    }
}
