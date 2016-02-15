import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * Created by plamen on 2/10/16.
 */

@WebServlet(urlPatterns = "/News/*")
public class NewsAggregator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        URL feedUrl = new URL("http://localhost");
        String category = req.getPathInfo();
        if (category.equals("/Bulgaria")) {
            feedUrl = new URL("http://www.dnevnik.bg/rssc/?rubrid=1657");
            out.printf("<h1>Новини от България</h1><hr>");
        } else if (category.equals("/Technology")) {
            feedUrl = new URL("http://www.dnevnik.bg/rssc/?rubrid=1660");
            out.printf("<h1>Новини от Технологии</h1><hr>");
        } else if (category.equals("/Sports")) {
            feedUrl = new URL("http://www.dnevnik.bg/rssc/?rubrid=2368");
            out.printf("<h1>Новини от Спорт</h1><hr>");
        }

        HttpURLConnection conn = (HttpURLConnection)feedUrl.openConnection();
        try {
            SyndFeed feed = new SyndFeedInput().build(new XmlReader(conn));
            List entries = feed.getEntries();
            Iterator it = entries.iterator();
            while (it.hasNext()) {
                SyndEntry entry = (SyndEntry) it.next();
                out.printf("<a href=\"%s\"><h2>%s</h2></a>", entry.getLink(), entry.getTitle());
                out.printf("<h4>%s пише на %s</h4>", entry.getAuthor(), entry.getPublishedDate());
                out.printf("<article>%s</article>", entry.getDescription().getValue());
                out.printf("<hr/>");
            }
        } catch (FeedException e) {
            e.printStackTrace();
        }
    }
}
