package ex2;

import javax.xml.namespace.QName;
import java.util.concurrent.Semaphore;

/**
 * Enviar sinalização para um ponto de encontro entre threads. Faça um código que uma thread t1 e t2 são inicializadas
 * e t1 espera por t2 e vice-versa.
 * @author luizASSilveira
 * **/

public class main {
    public static void main(String[] args) {

        Semaphore mutex1 = new Semaphore(1, true);
        Semaphore mutex2 = new Semaphore(1, true);

        Thread t1 = new Thread(new TheadAux(mutex1, mutex2));
        Thread t2 = new Thread(new ThreadAux2(mutex1, mutex2));


        t1.start();
        t2.start();



    }
}
