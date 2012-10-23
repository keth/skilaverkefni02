package is.ru.honn.rupin.service;

import is.ru.honn.rupin.domain.*;

import java.util.ArrayList;
import java.util.List;

public class PinServiceStub implements PinService
{
  protected List<Board> boards = new ArrayList<Board>();
  protected List<User> users = new ArrayList<User>();

  //@Override
  public User signUpUser(String username, String firstName, String lastName, String email,
                         String password, Gender gender)
      throws UsernameExistsException
  {
    if(getUser(username) != null)
      throw new UsernameExistsException("Notandi er þegar til");
    User newUser = new User(username, firstName, lastName, email, password, gender);
    users.add(newUser);
    return newUser;
  }

  //@Override
  public User getUser(String username)
  {
    for(User u : users)
    {
      if (u.getUsername().equals(username))
        return u;
    }
    return null;
  }

  //@Override
  public Board createBoard(String username, String name, String category)
      throws UserNotFoundException
  {
    User user = getUser(username);
    if(user == null)
      throw new UserNotFoundException("user not found");

    Board newBoard = new Board(name, category);

    newBoard.setCreator(user);
    boards.add(newBoard);
    return newBoard;
  }

  //@Override
  public Pin createPin(String username, String boardname, String link, String description) throws BoardNotFoundException
  {
    Pin newPin = new Pin();
    Board b = getBoard(username, boardname);
    if(null == b)
      throw new BoardNotFoundException("Board does not exist");
    newPin.setBoard(b);
    newPin.setLink(link);
    newPin.setDescription(description);
    newPin.setCreator(getUser(username));
    b.addPin(newPin);
    return newPin;
  }

  //@Override
  public Board getBoard(String username, String boardname)
  {
    List<Board> userBoards = getBoards(username);
    for(Board b : userBoards)
    {
      if(b.getName().equals(boardname)) return b;
    }
    return null;
  }

  //@Override
  public List<Board> getBoards(String username)
  {
    List<Board> userBoards = new ArrayList<Board>();
    for(Board b : boards)
    {
      if(b.getCreator().getUsername().equals(username))
        userBoards.add(b);
    }
    return userBoards;
  }

  //@Override
  public List<Pin> getPinsOnBoard(String username, String boardname)
  {
    List<Pin> pinsOnBoard = new ArrayList<Pin>();
    Board b = getBoard(username, boardname);
    return b.getPins();
  }
}
