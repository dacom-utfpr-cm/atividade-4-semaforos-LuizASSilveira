package ex7;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * Semáforos podem ser usadas para representar uma fila.Faça um código que implemente duas filas (F1 e F2) com
 * semáforos. As threads colocadas na F1 sópodem executar se tiver um par na F2. Nesse caso, ambas
 * as threads na primeira fila são executadas.
 * @author luizASSilveira
 */




public class Main {
    public static void main(String[] args) {
        int numbThreadFila1 = 5;
        int numbThreadFila2 = 2;

        Semaphore fila1 = new Semaphore(1, true);
        Semaphore fila2 = new Semaphore(1, true);

        ArrayList<Thread> arrayThread = new ArrayList<>();

        for (int i = 0; i < numbThreadFila1; i++) {
            arrayThread.add(i, new Thread(new ThreadFilaPar( fila1, fila2 ))) ;
            arrayThread.get(i).start();
        }

        for (int i = 0; i < numbThreadFila2; i++) {
            arrayThread.add(i, new Thread(new ThreadFilaPar( fila2, fila1 ))) ;
            arrayThread.get(i).start();
        }


    }
}
