package ex3;

import java.util.ArrayList;

/**
 * Mutex (Exclusão Mútua)
 * Garantir acesso exclusivo à seção crítica.Faça um código que possibilite que 2 ou mais threads realizem o incremento
 * de um contador. Faça aexclusão mútua com semáforo.
 *
 * @LuizASSsilveira
 */

public class main {
    public static void main(String[] args) {

        Mutex m1 = new Mutex(true);

        ArrayList<Thread> arrayThread = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayThread.add(i, new Thread(new Incrementa(m1))) ;
            arrayThread.get(i).start();
        }



    }
}
