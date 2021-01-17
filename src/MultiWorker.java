import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.function.Consumer;

public class MultiWorker {
    Queue<Worker> workers;
    int count;
    Lock lock = new Lock();
    public MultiWorker(Queue<Worker> workers) {
        this.workers = workers;
        count = workers.size();
    }
    public void addWorker(String task, Consumer<String> callback) {
        workers.add(new Worker(task));
    }
    public void startAll(Consumer<String> finalCallBack) throws Exception{
        for (Worker worker : workers) {
            Thread one = new Thread(){
                public void run() {
                    try {
                        worker.start((name) -> {
                            lock.acquire();
                            count--;
                            System.out.println("call back" + name);
                            if (count == 0) {
                                finalCallBack.accept("final call back!");
                            }
                            lock.release();
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            one.start();
        }
    }
    public static void main(String[] args) throws Exception {
        Queue<Worker> workers = new LinkedList<>();
        workers.add(new Worker("A"));
        workers.add(new Worker("B"));
        workers.add(new Worker("C"));
        workers.add(new Worker("D"));
        workers.add(new Worker("E"));

        MultiWorker multiWorker = new MultiWorker(workers);
        multiWorker.startAll(task ->{
            System.out.println(task);
        });

    }
}
class Worker {
    String task;
    Consumer<String> callback;
    public Worker(String task) {
        this.task = task;
    }
    public void start(Consumer<String> callback) throws Exception{
        System.out.println("start work" + task);
        Random ram = new Random();
        Thread.sleep(1000 + ram.nextInt(100));
        callback.accept(task);
    }
}
class Lock{
    public void acquire(){}
    public void release() {}
}