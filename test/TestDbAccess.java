import is.ru.honn.rupin.data.BoardDataGateway;
import is.ru.honn.rupin.data.PinDataGateway;
import is.ru.honn.rupin.data.UserDataGateway;
import is.ru.honn.rupin.domain.Board;
import is.ru.honn.rupin.domain.Gender;
import is.ru.honn.rupin.domain.Pin;
import is.ru.honn.rupin.domain.User;
import is.ruframework.data.RuDataAccessFactory;
import is.ruframework.domain.RuException;

import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Birgir Ásþórsson
 * Date: 23.10.2012
 * Háskólinn í Reykjavík
 * Hönnun og smíði hugbúnaðar
 * To change this template use File | Settings | File Templates.
 */
public class TestDbAccess
{
    public static void main(String[] args)
    {
        Logger log = Logger.getLogger("Test");
        RuDataAccessFactory factory = null;
        try
        {
            factory = RuDataAccessFactory.getInstance("data.xml");
        }
        catch (RuException e)
        {
            log.severe("Unable to load data specification in data.xml" + e.getMessage());

        }
        UserDataGateway userDataGateway =
                (UserDataGateway)factory.getDataAccess("userDataAccess");

        userDataGateway.addUser(
                new User("freddie", "Freddie", "Mercury", "freddie@gmail.com", "12345", Gender.MALE)
        );

        userDataGateway.addUser(
                new User("david", "David", "Bowie", "david@gmail.com", "54321", Gender.UNSPECIFIED)
        );

        userDataGateway.addUser(
                new User("patti", "Patti", "Smith", "patti@gmail.com", "12543", Gender.FEMALE)
        );

        BoardDataGateway boardDataGateway =
                (BoardDataGateway)factory.getDataAccess("boardDataAccess");

        boardDataGateway.addBoard(
                new Board("board1", "category1")
        );


        PinDataGateway pinDataGateway =
                        (PinDataGateway)factory.getDataAccess("pinDataAccess");

        pinDataGateway.addPin(
                new Pin("link", "bescription", "smu")
        );


        System.out.println(userDataGateway.getUserByUsername("freddie"));
        System.out.println(boardDataGateway.getBoardsByUsername("Jonas"));
/       System.out.println(pinDataGateway.getPinsOnBoard("Jonas", "hestur1"));



    }
}

