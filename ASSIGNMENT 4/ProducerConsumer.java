import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

    public static void main(String[] args) {

        List<Integer> sharedQueue = new LinkedList<Integer>();

        Lock lock = new ReentrantLock();

        Condition producerCondition = lock.newCondition();

        Condition consumerCondition = lock.newCondition();

        Producers producer=new Producers(sharedQueue,lock,producerCondition,consumerCondition);
        Consumers consumer=new Consumers(sharedQueue,lock,producerCondition,consumerCondition);

        Thread producerThread = new Thread(producer, "ProducerThread");
        Thread consumerThread = new Thread(consumer, "ConsumerThread");
        producerThread.start();
        consumerThread.start();

    }


}



class Producers implements Runnable {

    private List<Integer> sharedQueue;
    private int maxSize=5;
    Lock lock;
    Condition producerCondition;
    Condition consumerCondition;


    public Producers(List<Integer> sharedQueue, Lock lock,
                    Condition producerCondition, Condition consumerCondition) {
        this.sharedQueue = sharedQueue;
        this.lock=lock;
        this.producerCondition=producerCondition;
        this.consumerCondition=consumerCondition;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                produce(i);
            } catch (InterruptedException e) {  e.printStackTrace();   }
        }
    }

    public void produce(int i) throws InterruptedException {
        lock.lock();

        if (sharedQueue.size() == maxSize) {
            producerCondition.await();
        }

        System.out.println("Produced : " + i);
        sharedQueue.add(i);
        consumerCondition.signal();

        lock.unlock();

    }

}


class Consumers implements Runnable {
    private List<Integer> sharedQueue;
    Lock lock;
    Condition producerCondition;
    Condition consumerCondition;

    public Consumers(List<Integer> sharedQueue, Lock lock,
                    Condition producerCondition, Condition consumerCondition) {
        this.sharedQueue = sharedQueue;
        this.lock=lock;
        this.producerCondition=producerCondition;
        this.consumerCondition=consumerCondition;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {   
            try {
                consume();
            } catch (InterruptedException e) {  e.printStackTrace();   }
        }

    }


    public void consume() throws InterruptedException {
        lock.lock();


        if (sharedQueue.size() == 0) {
            consumerCondition.await();
        }



        System.out.println("CONSUMED: " + sharedQueue.remove(0));
        producerCondition.signal();

        lock.unlock();

    }


}
