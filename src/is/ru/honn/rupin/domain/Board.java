package is.ru.honn.rupin.domain;

import java.util.ArrayList;
import java.util.List;

public class Board extends PinObject
{
  protected String name;
  protected String category;
  List<Pin> pins = new ArrayList<Pin>();

  public Board()
  {
  }
             //
  public Board(String name, String category)
  {
    this.name = name;
    this.category = category;
  }

  public Pin addPin(Pin pin)
  {
    pins.add(pin);
    return pin;
  }

  public List<Pin> getPins()
  {
    return pins;
  }

  public void setPins(List<Pin> pins)
  {
    this.pins = pins;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getCategory()
  {
    return category;
  }

  public void setCategory(String category)
  {
    this.category = category;
  }

  @Override
  public String toString()
  {
    return name;
  }
}
