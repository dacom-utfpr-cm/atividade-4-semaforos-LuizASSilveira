package ex1;

import java.util.concurrent.Semaphore;

/**
 * Enviar sinal para outra thread para indicar que um evento ocorreu. Faça um código que uma thread t1 e t2 são
 * inicializadas simultaneamente, mas a t2 pode somente continuar a execução após a sinalização de t1.
 *
 * @author luizASSilveira
 * **/

public class main {
    public static void main(String[] args) {
        int n = 5;

        Semaphore mutex = new Semaphore(1, true);


        Thread t1 = new Thread(new Produter(mutex));
        Thread t2 = new Thread(new Consumer(mutex));

        t1.start();
        t2.start();




    }
}
