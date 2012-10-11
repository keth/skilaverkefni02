package is.ru.honn.rupin.feeds;

public class FeedEntry
{
  protected String title;
  protected String link;
  protected String description;

  public FeedEntry()
  {
  }

  public FeedEntry(String title, String link, String description)
  {
    this.title = title;
    this.link = link;
    this.description = description;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getLink()
  {
    return link;
  }

  public void setLink(String link)
  {
    this.link = link;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String toString()
  {
    return title + "\n" + description;
  }

}
