package is.ru.honn.rupin.service;

public class UsernameExistsException extends Exception
{
  public UsernameExistsException()
  {
    super();
  }

  public UsernameExistsException(String s)
  {
    super(s);
  }

  public UsernameExistsException(String s, Throwable throwable)
  {
    super(s, throwable);
  }
}
