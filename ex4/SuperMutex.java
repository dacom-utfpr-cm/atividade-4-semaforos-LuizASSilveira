package ex4;
/**
 * @author luizASSilveira
 */

public class SuperMutex {
    private int permition;


    public SuperMutex(int numberPermition) {
        this.permition = numberPermition;
    }

    public synchronized void P(){
        while ( permition == 0) {
            try {
                this.wait();

            } catch (Exception e){
                System.out.println(e);
            }
        }
        this.permition --;
    }

    public synchronized void V(){
        this.permition++;
        this.notifyAll();
    }
}
