package _1Monday;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * Week 11 Task 2
 * Created by plamen on 2/8/16.
 */
public class GetCallable implements Callable<String> {
    private final CloseableHttpClient mHttpClient;
    private final HttpContext mContext;
    private final HttpGet mGet;

    public GetCallable(CloseableHttpClient httpClient, HttpGet get) {
        mHttpClient = httpClient;
        mContext = HttpClientContext.create();
        mGet = get;
    }

    @Override
    public String call() throws Exception {
        System.out.println(mGet.toString());
        String contents = null;

        try (CloseableHttpResponse response = mHttpClient.execute(mGet, mContext)) {
            HttpEntity entity = response.getEntity();
            contents = EntityUtils.toString(entity);
        } catch (ClientProtocolException e) {
            System.err.println("Protocol error");
        } catch (IOException e) {
            System.err.println("I/O error");
        }
        return contents;
    }
}