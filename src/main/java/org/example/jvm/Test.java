package org.example.jvm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lvle
 * @date 2022-02-20 18:28
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        int start = 0;
        int end  = 5000;
        int num_threads = Runtime.getRuntime().availableProcessors();
        System.out.println(num_threads);
        AtomicInteger atomic = new AtomicInteger(start);
        final CountDownLatch countDownLatch = new CountDownLatch(num_threads);
        Map<Integer, List<Integer>> map = new ConcurrentHashMap<>();
        for (int threadId = 0; threadId < num_threads; ++threadId) {
            int finalThreadId = threadId;
            Thread thread = new Thread(() -> {
                int myId = finalThreadId;
                List<Integer> list = new ArrayList<>();
                try {
                    while (true) {
                        int id = atomic.getAndIncrement();
                        if (id >= end) {
                            break;
                        } else {
                            list.add(id);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    map.put(myId, list);
                    countDownLatch.countDown();
                }
            });
            thread.start();
        }
        countDownLatch.await();
        int count = 0;
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            int key = entry.getKey();
            List<Integer> value = entry.getValue();
            System.out.println("key:"+ key + " size:" + value.size());
            count += value.size();
            System.out.println(value);
        }
        System.out.println(count);
    }
}
