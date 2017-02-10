/**
 * Created by eishkinina on 10.02.17.
 */
public class Consumer extends Thread {


    private final Buffer buffer;

    public Consumer(String name, Buffer buffer) {
        super(name);
        this.buffer = buffer;
    }

    @Override
    public void run() {

        while (true) {

            System.out.println( getName() + buffer.getElement());

        }

    }
}
