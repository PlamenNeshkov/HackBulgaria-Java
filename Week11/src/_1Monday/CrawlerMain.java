package _1Monday;

import java.io.IOException;

/**
 * Week 11 Task 2
 * Created by plamen on 2/8/16.
 */
public class CrawlerMain {
    public static void main(String[] args) throws IOException {
        Crawler crawler = new Crawler(args[0], args[1]);
        crawler.start();
    }
}
