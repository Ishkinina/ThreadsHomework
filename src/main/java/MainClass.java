/**
 * Created by eishkinina on 10.02.17.
 */
public class MainClass{

    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        startProviders(buffer, 8);

        startConsumers(buffer, 5);

        }

    private static void startConsumers(Buffer buffer, int consumerAmount) {
        for (int i = 0; i<consumerAmount; i++){
            new Consumer("Consumer_"+ i, buffer).start();
        }
    }

    private static void startProviders(Buffer buffer, int providersAmount) {
        for (int i = 0; i< providersAmount; i++){
            new Provider("Provider_"+ i, buffer).start();
        }
    }
}


