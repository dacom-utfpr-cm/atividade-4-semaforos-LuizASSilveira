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
        int nuberOfThread = 10;
        int nuberOfpermitions = 5;
        int numberIntervalo = 10;

        ArrayList<Semaphore> arraySemaphore = new ArrayList<>();
        for (int i = 0; i < numberIntervalo; i++) {
            arraySemaphore.add(i, new Semaphore(nuberOfpermitions,true));
        }

        ArrayList<Thread> arrayBarrier = new ArrayList<>();
        for (int i = 0; i < numberIntervalo; i++) {
            arrayBarrier.add(i, new Thread(new UnleashBarrier( arraySemaphore.get(i), nuberOfpermitions, nuberOfThread, i ))) ;
            arrayBarrier.get(i).start();
        }

        ArrayList<Thread> arrayThread = new ArrayList<>();
        for (int i = 0; i < nuberOfThread; i++) {
            arrayThread.add(i, new Thread(new AguardaBarreira( arraySemaphore ))) ;
            arrayThread.get(i).start();
        }
    }

}
