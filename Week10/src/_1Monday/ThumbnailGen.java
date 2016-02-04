package _1Monday;

/**
 * Created by plamen on 2/4/16.
 */
public class ThumbnailGen {
    public static void main(String[] args) {
        Thread thread = new Thread(new BulkThumbnailGenerator(args));
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
