package is.ru.honn.rupin.feeds;

public interface FeedReader
{
  public void setSource(String source);
  public boolean read() throws FeedException;
  public void setFeedHandler(FeedHandler handler);
}
