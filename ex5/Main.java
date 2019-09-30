package ex5;

/**
 * Após n threads sincronizarem em um ponto em comum, um trecho específico (ponto crítico) pode ser executado por cada
 * uma delas.Faça um código que possibilite barrar N threads em um ponto específico de execução e, após todas
 * alcançarem o ponto, todas devem executar o trecho de código após esse ponto.
 * @luizASSilveira
 */

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int nuberOfThread = 20;
        int nuberOfpermitions = 5;

        Semaphore semaphore = new Semaphore(nuberOfpermitions,true);
        new Thread(new UnleashBarrier(semaphore, nuberOfpermitions, nuberOfThread )).start();


        ArrayList<Thread> arrayThread = new ArrayList<>();
        for (int i = 0; i < nuberOfThread; i++) {
            arrayThread.add(i, new Thread(new AguardaBarreira( semaphore ))) ;
            arrayThread.get(i).start();
        }


    }
}
