package ex5;

/**
 * @author luizASSilveira
 */

import java.util.Random;
import java.util.concurrent.Semaphore;

public class AguardaBarreira extends Thread{
    private static boolean lock = false;
    private Semaphore semaphore;

    public AguardaBarreira(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        Random number = new Random();

        try {
            Thread.sleep(number.nextInt(15000));//faz alguma coisa
            System.out.println(this.getName() + " -> Esperando liberação Barreira");
            this.semaphore.acquire();
            System.out.println(this.getName() + " -> Liberada");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.semaphore.release();
        }

    }
}
