package is.ru.honn.rupin.service;

import is.ru.honn.rupin.data.BoardDataGateway;
import is.ru.honn.rupin.data.PinDataGateway;
import is.ru.honn.rupin.data.UserDataGateway;
import is.ru.honn.rupin.domain.Board;
import is.ru.honn.rupin.domain.Gender;
import is.ru.honn.rupin.domain.Pin;
import is.ru.honn.rupin.domain.User;
import is.ruframework.data.RuDataAccessFactory;
import is.ruframework.domain.RuException;
import org.springframework.dao.EmptyResultDataAccessException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Birgir Ásþórsson
 * Date: 23.10.2012
 * Háskólinn í Reykjavík
 * Hönnun og smíði hugbúnaðar
 * @author Birgir S. Ásþórsson og Kristján Eldjárn Þóroddsson
 */
public class PinServiceData implements PinService
{
    protected UserDataGateway userDataGateway;
    protected BoardDataGateway boardDataGateway;
    protected PinDataGateway pinDataGateway;

    Logger logger = Logger.getLogger(this.getClass().getName());

    /**
     * Tómur smiður sem sér um tengingu við data.xml og les inn upplýsingar þaðan
     * Kastar villu ef hann nær ekki að lesa data.xml
     */
    public PinServiceData()
    {
        RuDataAccessFactory factory = null;

        try
        {
            factory = RuDataAccessFactory.getInstance("data.xml");
        }
        catch (RuException e)
        {
            logger.severe("Could not load data from data.xml" + e.getMessage());
        }

        userDataGateway = (UserDataGateway)factory.getDataAccess("userDataAccess");
        boardDataGateway = (BoardDataGateway)factory.getDataAccess("boardDataAccess");
        pinDataGateway = (PinDataGateway)factory.getDataAccess("pinDataAccess");
    }

    /**
     * signUpUser býr til nýjan user og skráir hann síðan í gagnagrunn
     * Kastar villu ef user er til í grunni
     * @param username
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param gender
     * @return
     * @throws UsernameExistsException
     */
    public User signUpUser(String username, String firstName, String lastName, String email, String password, Gender gender) throws UsernameExistsException
    {
        if(getUser(username) == null)
        {
            User addUser = new User(username, firstName, lastName, email, password, gender);
            userDataGateway.addUser(addUser);
            return addUser;
        }
        else
        {
            throw new UsernameExistsException("this username is taken, chooosh another");
        }
    }

    /**
     * getUser sækir user með ákveðið username úr grunni
     * @param username
     * @return user með ákveðið username
     */
    public User getUser(String username)
    {
        User returnUser;
        try
        {
        returnUser = userDataGateway.getUserByUsername(username);

        }
        catch (EmptyResultDataAccessException e)
        {
            return null;
        }
        return returnUser;
    }

    /**
     * getBoard sér um að sækja borð með ákveðnu username og boardname
     * @param username
     * @param boardname
     * @return
     */
    public Board getBoard(String username, String boardname)
    {
        return boardDataGateway.getBoard(username, boardname);
    }

    /**
     * getBoards sér um að sækja borð tengd ákveðnu username
     * @param username
     * @return
     */
    public List<Board> getBoards(String username)
    {
        return boardDataGateway.getBoardsByUsername(username);
    }

    /**
     * createBoard tekur saman upplýsingar um nýt board og skráir það síðan í gagnagrunn
     * @param username
     * @param boardname
     * @param category
     * @return
     * @throws UserNotFoundException
     */
    public Board createBoard(String username, String boardname, String category) throws UserNotFoundException
    {
        User user =userDataGateway.getUserByUsername(username);
        if(userDataGateway == null)
        {
            throw new UserNotFoundException("user not found");
        }
        Board createBoard = new Board(boardname, category);
        createBoard.setCreator(userDataGateway.getUserByUsername(username));
        boardDataGateway.addBoard(createBoard);
        return createBoard;
    }

    /**
     * createPin tekur saman upplýsingar um nýjan pin og skráir hann síðan í gagnagrunn
     * @param username
     * @param boardname
     * @param link
     * @param description
     * @return
     * @throws BoardNotFoundException
     */
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
        pinDataGateway.addPin(newPin);
        return newPin;
    }

    /**
     * getPinOnBoard nær í alla pinna sem eru á ákveðnu borði og tengt ákveðnu username
     * @param username
     * @param boardname
     * @return
     */
    public List<Pin> getPinsOnBoard(String username, String boardname)
    {
        Board board = this.getBoard(username,boardname);
        if (board != null)
        {
            return pinDataGateway.getPinsOnBoard(username,boardname);
        }
        return null;
    }
}
