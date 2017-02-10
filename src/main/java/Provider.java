/**
 * Created by eishkinina on 10.02.17.
 */
public class Provider extends Thread {

    private final Buffer buffer;

    public Provider(String name, Buffer buffer) {
        super(name);
        this.buffer = buffer;
    }

    @Override
    public void run() {

        while(true){
            String message = generateMessage();
            buffer.put(message);
        }
    }

    private String generateMessage() {
        return ""+ Math.random();

    }

//    String write(){
//        return Number;
//    }
}
