package ex2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadAux2 extends Thread{
    Semaphore mutex1;
    Semaphore mutex2;

    public ThreadAux2(Semaphore mutex1, Semaphore mutex2) {
        this.mutex1 = mutex1;
        this.mutex2 = mutex2;
    }
    @Override

    public void run() {
        Random number = new Random();

        try {
            this.mutex2.acquire();
            System.out.println("Thread:"+ this.getName() + "  Trecho 2.1");
            Thread.sleep(number.nextInt(5000));
            this.mutex2.release();

            this.mutex1.acquire();
            System.out.println("Thread:"+ this.getName() +"  Treccho 2.2");
            Thread.sleep(number.nextInt(2000));
            this.mutex1.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
