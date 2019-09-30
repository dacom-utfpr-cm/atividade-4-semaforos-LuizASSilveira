package ex6;

/**
 * @author luizASSilveira
 */

import java.util.concurrent.Semaphore;

public class UnleashBarrier extends Thread{
    private Semaphore semaphore;
    private int numeroPermitions;
    private int numeroThreads;
    private int i;

    public UnleashBarrier(Semaphore semaphore, int numeroPermitions, int numeroThreads, int i) {
        this.semaphore = semaphore;
        this.numeroPermitions = numeroPermitions;
        this.numeroThreads = numeroThreads;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            this.semaphore.acquire(this.numeroPermitions);

            while (true){
                if( this.semaphore.getQueueLength() == this.numeroThreads){
                    System.out.println("Open Barrier: "+ this.i);
                    this.semaphore.release(this.numeroPermitions);
                    break;
                }
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
