package is.ru.honn.rupin.feeds;

public abstract class AbstractFeedReader implements FeedReader
{
  protected FeedHandler feedHandler;
  protected String source;

  public void setSource(String source)
  {
    this.source = source;
  }

  public void setFeedHandler(FeedHandler feedHandler)
  {
    this.feedHandler = feedHandler;
  }

  public abstract boolean read() throws FeedException;
}
