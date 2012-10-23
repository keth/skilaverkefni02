package is.ru.honn.rupin.data;

import is.ru.honn.rupin.domain.Pin;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Birgir Ásþórsson
 * Date: 23.10.2012
 * Háskólinn í Reykjavík
 * Hönnun og smíði hugbúnaðar
 * To change this template use File | Settings | File Templates.
 */
public class PinData extends RuData implements PinDataGateway
{
    public int addPin(Pin pin)
    {
        SimpleJdbcInsert insertPin =
                new SimpleJdbcInsert(getDataSource())
                .withTableName("ru_pins");

        Map<String, Object>parameters = new HashMap<String, Object>(2);

        parameters.put("Link", pin.getLink());
        parameters.put("description", pin.getDescription());

        int returnKey = 0;
        try
        {
            returnKey = insertPin.execute(parameters);
        }
        catch (DataIntegrityViolationException divex)
        {
            log.warning("Pin already exists");
        }
        return returnKey;
    }

    public List<Pin> getPinsOnBoard(String username, String boardname)
    {
        JdbcTemplate queryForPins = new JdbcTemplate(getDataSource());
        List<Pin> pins = queryForPins.query("select * from ru_pins where username=?",
                new PinRowMapper());

        return pins;
    }
}
