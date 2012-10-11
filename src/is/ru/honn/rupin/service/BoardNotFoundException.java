package is.ru.honn.rupin.service;

public class BoardNotFoundException extends Exception
{
  public BoardNotFoundException()
  {
    super();
  }

  public BoardNotFoundException(String s)
  {
    super(s);
  }

  public BoardNotFoundException(String s, Throwable throwable)
  {
    super(s, throwable);
  }
}
