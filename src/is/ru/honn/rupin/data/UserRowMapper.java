package is.ru.honn.rupin.data;

import is.ru.honn.rupin.domain.Gender;
import is.ru.honn.rupin.domain.User;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Birgir Ásþórsson
 * Date: 23.10.2012
 * Háskólinn í Reykjavík
 * Hönnun og smíði hugbúnaðar
 * To change this template use File | Settings | File Templates.
 */
public class UserRowMapper implements ParameterizedRowMapper
{
    public User mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        User user = new User(rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                Gender.valueOf(rs.getString(7)));

        user.setId(rs.getInt(1));

        return user;
    }
}
