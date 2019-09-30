package ex4;
import java.util.ArrayList;

/**
 * Garantir acesso à seção crítica para no máximo N threads.Faça um código que possibilite que N threads estejam
 * na seção crítica simultaneamente.
 *
 * @author luizASSilveira
 **/

public class Main {
    public static void main(String[] args) {
        SuperMutex multex = new SuperMutex(3);

        ArrayList<Thread> arrayThread = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayThread.add(i, new Thread(new Incrementa(multex))) ;
            arrayThread.get(i).start();
        }


    }
}
