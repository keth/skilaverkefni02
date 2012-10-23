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
 * @author Birgir S. Ásþórsson og Kristján Eldjárn Þóroddsson
 *
 * Útfærsla á PinDataGateway
 * Sér um tengingu við gagnagrunn fyrir pins
 */
public class PinData extends RuData implements PinDataGateway
{
    /**
     * addPin sér um að taka saman upplýsingar fyrir pin og setja pinna í gagnagrunn
     *
     * @param pin
     * @return
     */
    public int addPin(Pin pin)
    {
        SimpleJdbcInsert insertPin =
                new SimpleJdbcInsert(getDataSource())
                .withTableName("ru_pins");

        Map<String, Object>parameters = new HashMap<String, Object>(5);

        parameters.put("description", pin.getDescription());
        parameters.put("link", pin.getLink());
        parameters.put("image", pin.getImage());
        parameters.put("boardname", "hestur1");
        parameters.put("username", pin.getCreator());

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

    /**
     * getPinsOnBoard sækir alla pinna sem tengdir eru ákveðnu usernam og boardname
     *
     * @param username
     * @param boardname
     * @return
     */
    public List<Pin> getPinsOnBoard(String username, String boardname)
    {
        JdbcTemplate queryForPins = new JdbcTemplate(getDataSource());
        List<Pin> pins = queryForPins.query("select * from ru_pins where username = ? AND where boardname = ? ",
                new PinRowMapper());
        return pins;
    }
}
