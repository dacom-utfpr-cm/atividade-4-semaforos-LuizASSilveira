package ex7;

/**
 * @author luizASSilveira
 */

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadFilaPar extends Thread {
    private Semaphore fila1;
    private Semaphore fila2;
    private boolean controlSpace = false;

    public ThreadFilaPar(Semaphore fila1, Semaphore fila2) {
        this.fila1 = fila1;
        this.fila2 = fila2;
    }

    @Override
    public void run() {

        while (true){
            try {
                Random number = new Random();
                Thread.sleep(number.nextInt(5000));
                this.fila1.acquire();
                while (true){
                    if(this.fila2.availablePermits() == 0){
                        //significa que possue nas duas filas
                        System.out.println(this.getName() + " executando");

                        if(this.controlSpace){
                            this.controlSpace = false;

                        }
                        break;
                    }
                    this.controlSpace = true;
                    //System.out.println("Aguardando");
                }
                Thread.sleep(5000);
                this.fila1.release();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
