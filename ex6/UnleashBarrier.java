package ex6;

/**
 * @author luizASSilveira
 */

import java.util.concurrent.Semaphore;

public class UnleashBarrier extends Thread{
    private Semaphore semaphore;
    private Semaphore semaphore2;
    private int numeroPermitions;
    private int numeroThreads;

    public UnleashBarrier(Semaphore semaphore, Semaphore semaphore2, int numeroPermitions, int numeroThreads) {
        this.semaphore = semaphore;
        this.semaphore2 = semaphore2;
        this.numeroPermitions = numeroPermitions;
        this.numeroThreads = numeroThreads;
    }

    @Override
    public void run(){
        try {


            this.semaphore.acquire(this.numeroPermitions);
            while (true){

                this.semaphore2.acquire(this.numeroPermitions);
                while (true){
                    if( this.semaphore.getQueueLength() == this.numeroThreads){
                        System.out.println("unleash 1");
                        this.semaphore.release(this.numeroPermitions);
                        break;
                    }
                }
                this.semaphore.acquire(this.numeroPermitions);

                while (true){
                    if( this.semaphore2.getQueueLength() == this.numeroThreads ){
                        System.out.println("unleash 2");
                        this.semaphore2.release(this.numeroPermitions);
                        break;
                    }
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
