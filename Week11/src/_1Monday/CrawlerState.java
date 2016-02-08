package _1Monday;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by plamen on 2/8/16.
 */
public class CrawlerState {
    private final URL mStartingUrl;
    private final String mNeedle;

    private Set<String> mVisitedLinks = new HashSet<>();
    private BlockingQueue<String> mToVisit = new LinkedBlockingQueue<>();
    private boolean mFound = false;
    private String mFoundUrl = "";

    public CrawlerState(URL startingUrl, String needle) {
        mStartingUrl = startingUrl;
        mNeedle = needle;
    }

    public void enqueue(String url) {
        mToVisit.offer(url);
    }

    public String dequeue() {
        String url = "";
        try {
            url = mToVisit.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return url;
    }

    public synchronized void visit(String url) {
        mVisitedLinks.add(url);
    }

    public synchronized boolean isVisited(String url) {
        return mVisitedLinks.contains(url);
    }

    public synchronized void found(String url) {
        mFound = true;
        mFoundUrl = url;
    }

    public synchronized String getFoundUrl() {
        return mFoundUrl;
    }

    public synchronized boolean isFound() {
        return mFound;
    }

    public URL getStartingUrl() {
        return mStartingUrl;
    }

    public String getNeedle() {
        return mNeedle;
    }
}
