package is.ru.honn.rupin.feeds.rss;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;

import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import is.ru.honn.rupin.feeds.AbstractFeedReader;
import is.ru.honn.rupin.feeds.FeedEntry;
import is.ru.honn.rupin.feeds.FeedException;

public class RssFeedReader extends AbstractFeedReader
{
  public RssFeedReader()
  {
  }

  public boolean read() throws FeedException
  {
    URL feedUrl = null;
    try
    {
      feedUrl = new URL(source);
    }
    catch (MalformedURLException murlex)
    {
      System.out.println("URL is not correct (Malformed)");
    }

    SyndFeedInput input = new SyndFeedInput();
    SyndFeed syndFeed = null;
    try
    {
      syndFeed = input.build(new XmlReader(feedUrl));
    }
    catch (Exception ex)
    {
      String msg = "URL is not correct";
      throw new FeedException(msg);
    }

    List list = syndFeed.getEntries();
    Iterator i = list.iterator();
    SyndEntry ent = null;
    while (i.hasNext())
    {
      ent = (SyndEntry) i.next();
      feedHandler.processEntry(new FeedEntry(ent.getTitle(), ent.getLink(),
          ent.getDescription().getValue()));

    }

    return true;
  }

}
