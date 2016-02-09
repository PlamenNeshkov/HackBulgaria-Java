package _1Monday;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * Week 11 Task 2
 * Created by plamen on 2/8/16.
 */
public class Crawler {
    private final CrawlerState mCrawlerState;

    private ExecutorService executor = Executors.newFixedThreadPool(2);
    private PoolingHttpClientConnectionManager mConnectionManager = new PoolingHttpClientConnectionManager();
    private CloseableHttpClient mClient = HttpClients.custom()
            .setConnectionManager(mConnectionManager)
            .build();

    public Crawler(String startingUrl, String needle) throws MalformedURLException {
        mCrawlerState = new CrawlerState(new URL(startingUrl), needle);
    }

    public void start() {
        crawl(mCrawlerState.getStartingUrl().toString());
    }

    public void crawl(String url) {
        if (mCrawlerState.isFound()) {
            System.out.print("Found @ ");
            System.out.println(mCrawlerState.getFoundUrl());
            executor.shutdownNow();
            return;
        }

        mCrawlerState.visit(url);

        HttpGet get = new HttpGet(url);
        Future<String> futureContents = executor.submit(new GetCallable(mClient, get));
        executor.submit(new ParserRunnable(mCrawlerState, futureContents, url));

        String nextUrl = mCrawlerState.dequeue();
        crawl(nextUrl);
    }
}
