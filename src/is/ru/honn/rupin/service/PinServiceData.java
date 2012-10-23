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

import java.util.List;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Birgir Ásþórsson
 * Date: 23.10.2012
 * Háskólinn í Reykjavík
 * Hönnun og smíði hugbúnaðar
 * To change this template use File | Settings | File Templates.
 */
public class PinServiceData implements PinService
{
    protected UserDataGateway userDataGateway;
    protected BoardDataGateway boardDataGateway;
    protected PinDataGateway pinDataGateway;

    Logger logger = Logger.getLogger(this.getClass().getName());

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
    }

   // @Override
    public User signUpUser(String username, String firstName, String lastName, String email, String password, Gender gender) throws UsernameExistsException
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

  //  @Override
    public User getUser(String username)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

  //  @Override
    public Board getBoard(String username, String boardname)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

 //   @Override
    public List<Board> getBoards(String username)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

  //  @Override
    public Board createBoard(String username, String boardname, String category) throws UserNotFoundException
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

 //   @Override
    public Pin createPin(String username, String boardname, String link, String description) throws BoardNotFoundException
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

  //  @Override
    public List<Pin> getPinsOnBoard(String username, String boardname)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
