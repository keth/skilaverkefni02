package is.ru.honn.rupin.service;

public class UserNotFoundException extends Exception
{
  public UserNotFoundException()
  {
    super();
  }

  public UserNotFoundException(String s)
  {
    super(s);
  }

  public UserNotFoundException(String s, Throwable throwable)
  {
    super(s, throwable);
  }
}
