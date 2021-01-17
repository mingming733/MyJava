import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

public class ProducerConsumer {
    int capacity = 100;
    private final Queue<Integer> data = new LinkedList();
    //非满锁
    private final Semaphore notFull;
    //非空锁
    private final Semaphore notEmpty;
    //互斥锁
    private final Semaphore mutex;

    public ProducerConsumer(int capacity) {
        this.notFull = new Semaphore(capacity);
        this.notEmpty = new Semaphore(0);
        mutex = new Semaphore(1);
    }
    public void offer() throws InterruptedException {
        notFull.acquire(100); //producer获取信号，notFull信号量减100
        mutex.acquire(); //当前进程获得信号，mutex信号量减1，其他线程被阻塞操作共享区块data
        Thread.sleep(1000);
        data.addAll(get100());
        mutex.release(); //mutex信号量+1, 其他线程可以继续信号操作共享区块data
        notEmpty.release(100); //成功生产数据，notEmpty信号量加100
    }
    public int getId() throws InterruptedException {
        notEmpty.acquire(); //notEmpty信号减一
        mutex.acquire();
        int id = data.poll();
        mutex.release();
        notFull.release(); //成功消耗数据, notFull信号量加1
        return id;
    }

    public List<Integer> get100 () {
        List<Integer> ids = new ArrayList<>();
        Random ram = new Random();
        for (int i = 0; i < 100; i++) {
            ids.add(ram.nextInt(100));
        }
        return ids;
    }
    public static void main(String[] args) throws IOException {
        ProducerConsumer producerConsumer = new ProducerConsumer(100);
        new Thread(new Producer(producerConsumer)).start();
        while(true) {
            try {
//                Thread.sleep(100);
                System.out.println(producerConsumer.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**Producer线程**/
 class Producer implements Runnable {
    private final ProducerConsumer producerConsumer;

    public Producer(final ProducerConsumer producerConsumer) {
        this.producerConsumer = producerConsumer;
    }

    @Override
    public void run() {
        while (true) {
            try {
//                Thread.sleep(100); // ???可以不加
                producerConsumer.offer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

