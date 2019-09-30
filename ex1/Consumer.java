package ex1;

/**
 * @author luizASSilveira
 */

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Consumer extends Thread{

    Semaphore mutex;

    public Consumer(Semaphore mutex) {
        this.mutex = mutex;
    }

    @Override
    public void run() {

        Random number = new Random();
        try {
            System.out.println("Aguardando");
            this.mutex.acquire();
            System.out.println("Consumer Executando...");
            Thread.sleep(number.nextInt(4000));

        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            this.mutex.release();
        }

    }
}
