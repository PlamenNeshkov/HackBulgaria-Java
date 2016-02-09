package _1Monday;

import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Week 11 Task 2
 * Created by plamen on 2/8/16.
 */
public class ParserRunnable implements Runnable {
    private final CrawlerState mCrawlerState;
    private final String mUrl;
    private Future<String> mFutureContents;

    public ParserRunnable(CrawlerState cs, Future<String> futureContents, String url) {
        mCrawlerState = cs;
        mFutureContents = futureContents;
        mUrl = url;
    }

    @Override
    public void run() {
        String contents = "";
        try {
            contents = mFutureContents.get();
        } catch (InterruptedException | ExecutionException e) {}

        System.out.printf("Parsing %s...%n", mUrl);

        if (contents.contains(mCrawlerState.getNeedle())) {
            mCrawlerState.found(mUrl);
        }

        List<String> links = null;
        try {
            links = getLinks(contents);
        } catch (URISyntaxException e) {
            System.err.print("Invalid URI @ ");
            System.err.println(mUrl);
        }

        if (links != null) {
            for (String link : links) {
                if (mCrawlerState.isVisited(link)) {
                    continue;
                }
                mCrawlerState.enqueue(link);
            }
        }
    }

    private List<String> getLinks(String contents) throws URISyntaxException {
        ArrayList<String> result = new ArrayList<>();

        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contents);

        while (matcher.find()) {
            String match = matcher.group(1);
            URI matchUri = new URI(match);

            if (!match.contains("http")) {
                URI uri = new URIBuilder()
                        .setScheme(mCrawlerState.getStartingUrl().getProtocol())
                        .setHost(mCrawlerState.getStartingUrl().getHost())
                        .setPath("/" + match)
                        .build();
                result.add(uri.toString());
            } else if (matchUri.getHost().equals(mCrawlerState.getStartingUrl().getHost())) {
                result.add(match);
            }
        }
        return result;
    }
}
