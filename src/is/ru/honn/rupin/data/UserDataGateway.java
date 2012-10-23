package is.ru.honn.rupin.data;

import is.ru.honn.rupin.domain.User;
import is.ruframework.data.RuDataAccess;

/**
 * Created with IntelliJ IDEA.
 * User: Birgir Ásþórsson
 * Date: 23.10.2012
 * Háskólinn í Reykjavík
 * Hönnun og smíði hugbúnaðar
 * To change this template use File | Settings | File Templates.
 */
public interface UserDataGateway extends RuDataAccess
{
    public int addUser(User user);
    public User getUserByUsername(String username);

}
