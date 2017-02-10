/**
 * Created by eishkinina on 10.02.17.
 */
public class Buffer {
    public String[] buffer = new String[1];
    private Object lock = new Object();

    public void put(String message) {
        synchronized (lock) {
            while (buffer[0] != null) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+ "I'm putting" + message);
            buffer[0] = message;
            lock.notifyAll();
        }
    }


    public String getElement() {

        synchronized (lock){
            while(buffer[0]== null){
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String message = buffer[0];
            System.out.println(Thread.currentThread().getName()+ "I'm reading" + message);
            lock.notifyAll();
            buffer[0]=null;

            return message;
        }

    }

}
