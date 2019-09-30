package ex5;

import java.util.concurrent.Semaphore;

/**
 * @author luizASSilveira
 */

public class UnleashBarrier extends Thread{
    private Semaphore semaphore;
    private int numeroPermitions;
    private int numeroThreads;


    public UnleashBarrier(Semaphore semaphore, int numeroPermitions, int numeroThreads) {
        this.semaphore = semaphore;
        this.numeroPermitions = numeroPermitions;
        this.numeroThreads = numeroThreads;
    }

    @Override
    public void run() {
        try {
            this.semaphore.acquire(this.numeroPermitions);

            while (true){
                if( this.semaphore.getQueueLength() == this.numeroThreads){
                    System.out.println("Open Barrier");
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
