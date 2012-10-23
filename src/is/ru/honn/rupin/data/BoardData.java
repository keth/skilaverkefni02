package is.ru.honn.rupin.data;

import is.ru.honn.rupin.domain.Board;
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
public class BoardData extends RuData implements BoardDataGateway
{

    @Override
    public void addBoard(Board board)
    {
        SimpleJdbcInsert insertBoard =
                new SimpleJdbcInsert(getDataSource())
                .withTableName("ru_boards")
                .usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<String, Object>(3);
        parameters.put("boardname", board.getName());
        parameters.put("category", board.getCategory());
        parameters.put("username", board.getCreator());
        //parameters.put("created", board.getCreated());
        insertBoard.execute(parameters);

        /*int returnKey = 0;
        try
        {
            returnKey = insertBoard.execute(parameters);
        }
        catch (DataIntegrityViolationException divex)
        {
            log.warning("Board with same name exists");
        }

        return returnKey; */
    }

    @Override
    public List<Board> getBoards()
    {
        JdbcTemplate queryForBoards = new JdbcTemplate(getDataSource());
        List<Board> boards = queryForBoards.query("select * from ru_boards",
                new BoardRowMapper());
        return boards;
    }

    @Override
    public Board getBoard(String boardname, String username)
    {
        JdbcTemplate queryForBoard = new JdbcTemplate(getDataSource());
        List<Board> boards = queryForBoard.query("select * from ru_boards where boardname=? and username=?",
                new BoardRowMapper(), new Object[]{boardname, username});
        return boards.get(0);
    }
}
