package _1Monday;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by plamen on 1/29/16.
 */
public class Producer implements Runnable {
    BlockingQueue<Integer> mQueue;
    MonitorObject mMonitorObj;

    public Producer(BlockingQueue<Integer> queue, MonitorObject monitorObj) {
        mQueue = queue;
        mMonitorObj = monitorObj;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (mMonitorObj.shouldProduce()) {
            try {
                mQueue.offer(random.nextInt(100));
                mMonitorObj.produce();
            } catch (InterruptedException e) {
                System.out.println("Interrupted producer.");
            }
        }
        System.out.println("FINISHED PRODUCING:" + Thread.currentThread().getName());
    }
}
