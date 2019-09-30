package ex6;

/**
 * @author luizASSilveira
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class AguardaBarreira extends Thread{
    private static boolean lock = false;
    private ArrayList<Semaphore> semaphore;

    public AguardaBarreira(ArrayList<Semaphore> semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        Random number = new Random();

        for (Semaphore semaphore: this.semaphore) {
            try {
                Thread.sleep(number.nextInt(15000));//faz alguma coisa
                System.out.println(this.getName() + " -> Esperando liberação Barreira");
                semaphore.acquire();
                System.out.println(this.getName() + " -> Liberada");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }


    }
}
