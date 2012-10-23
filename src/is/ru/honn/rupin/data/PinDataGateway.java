package is.ru.honn.rupin.data;

import is.ru.honn.rupin.domain.Pin;
import is.ruframework.data.RuDataAccess;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Birgir Ásþórsson
 * Date: 23.10.2012
 * Háskólinn í Reykjavík
 * Hönnun og smíði hugbúnaðar
 * To change this template use File | Settings | File Templates.
 */
public interface PinDataGateway extends RuDataAccess
{
    public int addPin(Pin pin);
    public List<Pin> getPinsOnBoard(String username, String boardname);
}
