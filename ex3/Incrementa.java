package ex3;

/**
 * @author luizASSilveira
 */

import java.util.Random;

public class Incrementa extends Thread {
    private static int cont = 0;
    private Mutex mutex;

    public Incrementa(Mutex mutex) {
        this.mutex = mutex;

    }

    @Override
    public void run() {
        Random number = new Random();
        while (true){
            try {
                this.mutex.P();
                Thread.sleep(number.nextInt(1000));
                cont++;
                System.out.println("Thread:"+ this.getName() +" valor: " + cont);
                this.mutex.V();
                Thread.sleep(number.nextInt(2000));

            } catch (Exception e){
                System.out.println(e);
            }
        }

    }
}
