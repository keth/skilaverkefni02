package is.ru.honn.rupin.feeds;

public class FeedException extends Exception
{
  public FeedException()
  {
    super();
  }

  public FeedException(String s)
  {
    super(s);
  }

  public FeedException(String s, Throwable throwable)
  {
    super(s, throwable);
  }
}
