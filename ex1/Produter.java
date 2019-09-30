package ex1;

/**
 * @author luizASSilveira
 */

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Produter extends Thread {

    Semaphore mutex;

    public Produter(Semaphore mutex) {
        this.mutex = mutex;
    }

    @Override
    public void run() {
        Random number = new Random();

            try {
                this.mutex.acquire();
                System.out.println("Produter executando ... ");
                Thread.sleep(number.nextInt(4000));

            } catch (InterruptedException e) {
                    System.out.println(e);
            } finally {
                    this.mutex.release();
                }
    }
}
