package is.ru.honn.rupin.data;

import is.ru.honn.rupin.domain.Pin;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Birgir Ásþórsson
 * Date: 23.10.2012
 * Háskólinn í Reykjavík
 * Hönnun og smíði hugbúnaðar
 * @author Birgir S. Ásþórsson og Kristján Eldjárn Þóroddsson
 *
 * pinRowMapper sér um að ná í gildi úr tölflu
 */
public class PinRowMapper implements ParameterizedRowMapper<Pin>
{
    public Pin mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Pin pin = new Pin(rs.getString("username"),
                rs.getString("boardname"),
                rs.getString("link"));

        return pin;
    }
}
