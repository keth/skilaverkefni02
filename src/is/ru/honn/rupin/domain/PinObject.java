package is.ru.honn.rupin.domain;

import java.util.Date;

public class PinObject
{
  protected User creator;
  protected Date created = new Date();

  public User getCreator()
  {
    return creator;
  }

  public void setCreator(User creator)
  {
    this.creator = creator;
  }

  public Date getCreated()
  {
    return created;
  }

  public void setCreated(Date created)
  {
    this.created = created;
  }
}
