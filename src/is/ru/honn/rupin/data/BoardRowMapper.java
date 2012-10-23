package is.ru.honn.rupin.data;

import is.ru.honn.rupin.domain.Board;
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
public class BoardRowMapper implements ParameterizedRowMapper
{
    public Board mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Board board = new Board(rs.getString("boardname"),
                                rs.getString("category"));
   //     User user = new User();
     //   user.setUsername(rs.getString(3));
     //   board.setCreator(user);

        return board;
    }
}
