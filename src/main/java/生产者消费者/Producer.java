package 生产者消费者;

import java.util.Queue;
import java.util.Random;

/**
 * @author LinZebin
 * @date 2019-07-06 15:25
 */
public class Producer extends Thread {

    private Queue<Integer> queue;
    private String name;
    private int maxSize;
    private int i;

    public Producer(String name, Queue<Integer> queue, int maxSize) {
        super(name);
        this.queue = queue;
        this.name = name;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("Queue is full, Producer[" + name + "] thread waiting for "
                            + "consumer to take something from queue.");
                        queue.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println("[" + name + "] Producing value : +" + i);
                queue.offer(i++);
                queue.notifyAll();

                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
