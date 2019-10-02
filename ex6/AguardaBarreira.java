package ex6;

/**
 * @author luizASSilveira
 */


import java.util.Random;
import java.util.concurrent.Semaphore;

public class AguardaBarreira extends Thread{
    private static boolean lock = false;
    private Semaphore semaphore;
    private Semaphore semaphore2;

    public AguardaBarreira(Semaphore semaphore, Semaphore semaphore2) {
        this.semaphore = semaphore;
        this.semaphore2 = semaphore2;
    }

    @Override
    public void run() {
        Random number = new Random();

        while (true){
            try {
                Thread.sleep(number.nextInt(3000));//faz alguma coisa
                System.out.println(this.getName() + " -> Esperando liberação Barreira1");
                semaphore.acquire();
                System.out.println(this.getName() + " -> Liberada semaphpre1");
                semaphore.release();

                System.out.println(this.getName() + " -> Esperando liberação Barreira2");
                semaphore2.acquire();
                System.out.println(this.getName() + " -> Liberada semaphpre2");
                semaphore2.release();

                Thread.sleep(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
