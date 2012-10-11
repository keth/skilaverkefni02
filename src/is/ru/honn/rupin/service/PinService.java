package is.ru.honn.rupin.service;

import is.ru.honn.rupin.domain.*;

import java.util.List;

public interface PinService
{
  public User signUpUser(String username, String firstName, String lastName, String email,
                         String password, Gender gender)
    throws UsernameExistsException;
  public User getUser(String username);
  public Board getBoard(String username, String boardname);
  public List<Board> getBoards(String username);
  public Board createBoard (String username, String boardname,
                            String category)
    throws UserNotFoundException;
  public Pin createPin (String username, String boardname,
                        String link, String description)
    throws BoardNotFoundException;
  public List<Pin> getPinsOnBoard(String username, String boardname);
}
