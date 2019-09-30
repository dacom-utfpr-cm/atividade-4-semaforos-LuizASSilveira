package ex3;

/**
 * @author luizASSilveira
 */

public class Mutex {
    private boolean permition;

    public Mutex(boolean stateInitial){
        this.permition = stateInitial;
    }

    public synchronized void P(){
        while ( !permition ) {
            try {
                this.wait();

            } catch (Exception e){
                System.out.println(e);
            }
        }
        this.permition = false;
    }

    public synchronized void V(){
        this.permition = true;
        this.notifyAll();
    }



}

