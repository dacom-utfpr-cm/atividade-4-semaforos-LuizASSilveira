package ex6;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * Threds em um laço executam uma série de passos e sincronizam em uma barreira a cada passo.Faça um
 * código que implemente uma barreira reusável que feche a si própria após todas as threads passarem.
 */
/**
 * @author luizASSilveira
 */

public class Main {
    public static void main(String[] args) {
        int numberOfThread = 4;
        int numberOfpermitions = 5;


        Semaphore semaphore = new Semaphore(numberOfpermitions, true);
        Semaphore semaphore2 = new Semaphore(numberOfpermitions, true);
        Thread barrier = new Thread(new UnleashBarrier(semaphore, semaphore2, numberOfpermitions, numberOfThread));
        barrier.start();
        ArrayList<Thread> arrayThread = new ArrayList<>();
        for (int i = 0; i < numberOfThread; i++) {
            arrayThread.add(i, new Thread(new AguardaBarreira( semaphore, semaphore2 ))) ;
            arrayThread.get(i).start();
        }
    }

}
